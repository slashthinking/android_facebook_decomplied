package com.facebook.orca.server;

import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.facebook.background.BackgroundTaskManager;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.login.ContextAwareAuthTokenStringSupplier;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.common.util.ExceptionUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.google.common.collect.Maps;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public abstract class OrcaService extends Service
{
  private static final Class<?> a = OrcaService.class;
  private OrcaService.OrcaServiceStub b;
  private OrcaServiceQueueManager c;
  private OrcaServiceRegistry d;
  private BackgroundTaskManager e;
  private ContextAwareAuthTokenStringSupplier f;
  private FbErrorReporter g;
  private final Map<Class, OrcaServiceQueue> h = Maps.a();
  private final AtomicLong i = new AtomicLong(System.currentTimeMillis());

  private OrcaServiceQueue a(Class<? extends Annotation> paramClass, OrcaServiceHandler paramOrcaServiceHandler, Set<OrcaServiceQueueHook> paramSet)
  {
    return new OrcaServiceQueue(paramClass, paramOrcaServiceHandler, paramSet, this.c, this.e, this.f);
  }

  private String a(String paramString, Bundle paramBundle)
  {
    monitorenter;
    try
    {
      if (this.c.c())
        throw new RemoteException();
    }
    finally
    {
      monitorexit;
    }
    if (paramBundle != null);
    try
    {
      paramBundle.setClassLoader(getClassLoader());
      AppInitLockHelper.a(this);
      localClass1 = this.d.a(paramString);
      Class localClass2 = this.d.a(localClass1);
      if ((localClass2 != null) && (getClass() != localClass2))
        throw new RemoteException();
    }
    catch (RuntimeException localRuntimeException)
    {
      Class localClass1;
      String str1 = "Error occurred in startOperation(" + paramString + ", " + paramBundle + "), exception: " + ExceptionUtil.a(localRuntimeException);
      this.g.a("OrcaService", str1);
      if (Build.VERSION.SDK_INT >= 15)
      {
        throw new RemoteException(str1);
        OrcaServiceQueue localOrcaServiceQueue = (OrcaServiceQueue)this.h.get(localClass1);
        if (localOrcaServiceQueue == null)
        {
          FbInjector localFbInjector = FbInjector.a(this);
          localOrcaServiceQueue = a(localClass1, (OrcaServiceHandler)localFbInjector.a(OrcaServiceHandler.class, localClass1), localFbInjector.c(OrcaServiceQueueHook.class, localClass1));
          localOrcaServiceQueue.b();
          this.h.put(localClass1, localOrcaServiceQueue);
        }
        String str2 = Long.toString(this.i.getAndIncrement());
        localOrcaServiceQueue.a(new Operation(str2, paramString, paramBundle));
        monitorexit;
        return str2;
      }
    }
    throw localRuntimeException;
  }

  private boolean a(String paramString, ICompletionHandler paramICompletionHandler)
  {
    monitorenter;
    while (true)
    {
      try
      {
        Iterator localIterator = this.h.values().iterator();
        if (!localIterator.hasNext())
          break label83;
        localOrcaServiceQueue = (OrcaServiceQueue)localIterator.next();
        if (!localOrcaServiceQueue.a(paramString))
          continue;
        monitorexit;
        if ((localOrcaServiceQueue != null) && (localOrcaServiceQueue.a(paramString, paramICompletionHandler)))
        {
          j = 1;
          return j;
        }
      }
      finally
      {
        monitorexit;
      }
      int j = 0;
      continue;
      label83: OrcaServiceQueue localOrcaServiceQueue = null;
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.b;
  }

  public void onCreate()
  {
    super.onCreate();
    BLog.c(a, "onCreate");
    FbInjector localFbInjector = FbInjector.a(this);
    this.b = new OrcaService.OrcaServiceStub(this);
    this.c = ((OrcaServiceQueueManager)localFbInjector.a(OrcaServiceQueueManager.class));
    this.d = ((OrcaServiceRegistry)localFbInjector.a(OrcaServiceRegistry.class));
    this.e = ((BackgroundTaskManager)localFbInjector.a(BackgroundTaskManager.class));
    this.f = ((ContextAwareAuthTokenStringSupplier)localFbInjector.a(ContextAwareAuthTokenStringSupplier.class));
    this.g = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
  }

  // ERROR //
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 251	android/app/Service:onDestroy	()V
    //   4: getstatic 28	com/facebook/orca/server/OrcaService:a	Ljava/lang/Class;
    //   7: ldc 252
    //   9: invokestatic 236	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;)V
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 38	com/facebook/orca/server/OrcaService:h	Ljava/util/Map;
    //   18: invokeinterface 204 1 0
    //   23: invokeinterface 210 1 0
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 215 1 0
    //   35: ifeq +23 -> 58
    //   38: aload_2
    //   39: invokeinterface 219 1 0
    //   44: checkcast 54	com/facebook/orca/server/OrcaServiceQueue
    //   47: invokevirtual 254	com/facebook/orca/server/OrcaServiceQueue:c	()V
    //   50: goto -21 -> 29
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: aload_0
    //   59: getfield 38	com/facebook/orca/server/OrcaService:h	Ljava/util/Map;
    //   62: invokeinterface 257 1 0
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //
    // Exception table:
    //   from	to	target	type
    //   14	56	53	finally
    //   58	69	53	finally
  }

  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
  }

  // ERROR //
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_2
    //   5: ireturn
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokevirtual 268	android/content/Intent:getAction	()Ljava/lang/String;
    //   12: astore 5
    //   14: ldc_w 270
    //   17: aload 5
    //   19: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +15 -> 37
    //   25: aload_0
    //   26: monitorexit
    //   27: goto -23 -> 4
    //   30: astore 4
    //   32: aload_0
    //   33: monitorexit
    //   34: aload 4
    //   36: athrow
    //   37: ldc_w 278
    //   40: aload 5
    //   42: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifeq +11 -> 56
    //   48: aload_0
    //   49: iload_3
    //   50: invokevirtual 282	com/facebook/orca/server/OrcaService:stopSelf	(I)V
    //   53: goto -28 -> 25
    //   56: ldc_w 284
    //   59: aload 5
    //   61: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   64: ifeq -39 -> 25
    //   67: aload_0
    //   68: getfield 38	com/facebook/orca/server/OrcaService:h	Ljava/util/Map;
    //   71: invokeinterface 204 1 0
    //   76: invokeinterface 210 1 0
    //   81: astore 6
    //   83: aload 6
    //   85: invokeinterface 215 1 0
    //   90: ifeq +19 -> 109
    //   93: aload 6
    //   95: invokeinterface 219 1 0
    //   100: checkcast 54	com/facebook/orca/server/OrcaServiceQueue
    //   103: invokevirtual 254	com/facebook/orca/server/OrcaServiceQueue:c	()V
    //   106: goto -23 -> 83
    //   109: aload_0
    //   110: getfield 38	com/facebook/orca/server/OrcaService:h	Ljava/util/Map;
    //   113: invokeinterface 257 1 0
    //   118: goto -93 -> 25
    //
    // Exception table:
    //   from	to	target	type
    //   8	34	30	finally
    //   37	118	30	finally
  }

  public boolean onUnbind(Intent paramIntent)
  {
    super.onUnbind(paramIntent);
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OrcaService
 * JD-Core Version:    0.6.0
 */