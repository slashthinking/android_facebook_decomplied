package com.google.common.base;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalizableReferenceQueue
{
  private static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
  private static final Method startFinalizer = getStartFinalizer(loadFinalizer(arrayOfFinalizerLoader));
  final ReferenceQueue<Object> queue;
  final boolean threadStarted;

  static
  {
    FinalizableReferenceQueue.FinalizerLoader[] arrayOfFinalizerLoader = new FinalizableReferenceQueue.FinalizerLoader[3];
    arrayOfFinalizerLoader[0] = new FinalizableReferenceQueue.SystemLoader();
    arrayOfFinalizerLoader[1] = new FinalizableReferenceQueue.DecoupledLoader();
    arrayOfFinalizerLoader[2] = new FinalizableReferenceQueue.DirectLoader();
  }

  public FinalizableReferenceQueue()
  {
    try
    {
      ReferenceQueue localReferenceQueue2 = (ReferenceQueue)startFinalizer.invoke(null, new Object[] { FinalizableReference.class, this });
      localReferenceQueue1 = localReferenceQueue2;
      bool = true;
      this.queue = localReferenceQueue1;
      this.threadStarted = bool;
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", localThrowable);
        ReferenceQueue localReferenceQueue1 = new ReferenceQueue();
        boolean bool = false;
      }
    }
  }

  static Method getStartFinalizer(Class<?> paramClass)
  {
    try
    {
      Method localMethod = paramClass.getMethod("startFinalizer", new Class[] { Class.class, Object.class });
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new AssertionError(localNoSuchMethodException);
    }
  }

  private static Class<?> loadFinalizer(FinalizableReferenceQueue.FinalizerLoader[] paramArrayOfFinalizerLoader)
  {
    int i = paramArrayOfFinalizerLoader.length;
    for (int j = 0; j < i; j++)
    {
      Class localClass = paramArrayOfFinalizerLoader[j].loadFinalizer();
      if (localClass != null)
        return localClass;
    }
    throw new AssertionError();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.FinalizableReferenceQueue
 * JD-Core Version:    0.6.2
 */