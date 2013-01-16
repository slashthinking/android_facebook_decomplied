package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Finalizer extends Thread
{
  private static final Field inheritableThreadLocals = getInheritableThreadLocalsField();
  private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
  private final WeakReference<Class<?>> finalizableReferenceClassReference;
  private final PhantomReference<Object> frqReference;
  private final ReferenceQueue<Object> queue = new ReferenceQueue();

  private Finalizer(Class<?> paramClass, Object paramObject)
  {
    super(Finalizer.class.getName());
    this.finalizableReferenceClassReference = new WeakReference(paramClass);
    this.frqReference = new PhantomReference(paramObject, this.queue);
    setDaemon(true);
    try
    {
      if (inheritableThreadLocals != null)
        inheritableThreadLocals.set(this, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", localThrowable);
    }
  }

  private void cleanUp(Reference<?> paramReference)
  {
    Method localMethod = getFinalizeReferentMethod();
    while (true)
    {
      paramReference.clear();
      if (paramReference == this.frqReference)
        throw new Finalizer.ShutDown(null);
      try
      {
        localMethod.invoke(paramReference, new Object[0]);
        paramReference = this.queue.poll();
        if (paramReference != null)
          continue;
        return;
      }
      catch (Throwable localThrowable)
      {
        while (true)
          logger.log(Level.SEVERE, "Error cleaning up after reference.", localThrowable);
      }
    }
  }

  private Method getFinalizeReferentMethod()
  {
    Class localClass = (Class)this.finalizableReferenceClassReference.get();
    if (localClass == null)
      throw new Finalizer.ShutDown(null);
    try
    {
      Method localMethod = localClass.getMethod("finalizeReferent", new Class[0]);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new AssertionError(localNoSuchMethodException);
    }
  }

  public static Field getInheritableThreadLocalsField()
  {
    try
    {
      localField = Thread.class.getDeclaredField("inheritableThreadLocals");
      localField.setAccessible(true);
      return localField;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
        Field localField = null;
      }
    }
  }

  public static ReferenceQueue<Object> startFinalizer(Class<?> paramClass, Object paramObject)
  {
    if (!paramClass.getName().equals("com.google.common.base.FinalizableReference"))
      throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
    Finalizer localFinalizer = new Finalizer(paramClass, paramObject);
    localFinalizer.start();
    return localFinalizer.queue;
  }

  public void run()
  {
    try
    {
      while (true)
        label0: cleanUp(this.queue.remove());
    }
    catch (InterruptedException localInterruptedException)
    {
      break label0;
    }
    catch (Finalizer.ShutDown localShutDown)
    {
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.internal.Finalizer
 * JD-Core Version:    0.6.2
 */