package com.facebook.orca.server;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.facebook.background.BackgroundTaskManager;
import com.facebook.common.util.HandlerExecutorService;
import com.facebook.login.ContextAwareAuthTokenStringSupplier;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrcaServiceQueue
{
  private static final Class<?> a = OrcaServiceQueue.class;
  private final Class<? extends Annotation> b;
  private final OrcaServiceHandler c;
  private final Set<OrcaServiceQueueHook> d;
  private final OrcaServiceQueueManager e;
  private final BackgroundTaskManager f;
  private final ContextAwareAuthTokenStringSupplier g;
  private final LinkedList<Operation> h = Lists.b();
  private final Map<String, OrcaServiceQueue.OperationHolder> i = Maps.a();
  private final LinkedList<Operation> j = Lists.b();
  private volatile boolean k;
  private HandlerThread l;
  private Handler m;
  private HandlerExecutorService n;
  private OrcaServiceQueue.OperationHolder o;

  public OrcaServiceQueue(Class<? extends Annotation> paramClass, OrcaServiceHandler paramOrcaServiceHandler, Set<OrcaServiceQueueHook> paramSet, OrcaServiceQueueManager paramOrcaServiceQueueManager, BackgroundTaskManager paramBackgroundTaskManager, ContextAwareAuthTokenStringSupplier paramContextAwareAuthTokenStringSupplier)
  {
    this.b = paramClass;
    this.c = paramOrcaServiceHandler;
    this.d = paramSet;
    this.e = paramOrcaServiceQueueManager;
    this.f = paramBackgroundTaskManager;
    this.g = paramContextAwareAuthTokenStringSupplier;
  }

  private void a(long paramLong)
  {
    this.m.postDelayed(new OrcaServiceQueue.3(this), paramLong);
  }

  private void a(OrcaServiceQueue.OperationHolder paramOperationHolder, OperationResult paramOperationResult)
  {
    monitorenter;
    try
    {
      OrcaServiceQueue.OperationHolder.a(paramOperationHolder, paramOperationResult);
      OrcaServiceQueue.OperationHolder.b(paramOperationHolder, System.currentTimeMillis());
      this.j.add(OrcaServiceQueue.OperationHolder.d(paramOperationHolder));
      Iterator localIterator = OrcaServiceQueue.OperationHolder.e(paramOperationHolder).iterator();
      while (localIterator.hasNext())
      {
        ICompletionHandler localICompletionHandler = (ICompletionHandler)localIterator.next();
        try
        {
          localICompletionHandler.b(OrcaServiceQueue.OperationHolder.f(paramOperationHolder));
        }
        catch (RemoteException localRemoteException)
        {
        }
      }
      OrcaServiceQueue.OperationHolder.a(paramOperationHolder, null);
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void a(OrcaServiceQueue.OperationHolder paramOperationHolder, ListenableFuture<OperationResult> paramListenableFuture)
  {
    OrcaServiceQueue.OperationHolder.a(paramOperationHolder, paramListenableFuture);
    this.o = paramOperationHolder;
    Futures.a(OrcaServiceQueue.OperationHolder.a(paramOperationHolder), new OrcaServiceQueue.4(this, paramOperationHolder), this.n);
  }

  private void b(OrcaServiceQueue.OperationHolder paramOperationHolder, OperationResult paramOperationResult)
  {
    monitorenter;
    try
    {
      if (OrcaServiceQueue.OperationHolder.e(paramOperationHolder) != null)
      {
        Iterator localIterator = OrcaServiceQueue.OperationHolder.e(paramOperationHolder).iterator();
        while (localIterator.hasNext())
        {
          ICompletionHandler localICompletionHandler = (ICompletionHandler)localIterator.next();
          try
          {
            localICompletionHandler.a(paramOperationResult);
          }
          catch (RemoteException localRemoteException)
          {
          }
        }
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/facebook/orca/server/OrcaServiceQueue:o	Lcom/facebook/orca/server/OrcaServiceQueue$OperationHolder;
    //   4: ifnonnull +72 -> 76
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 52	com/facebook/orca/server/OrcaServiceQueue:h	Ljava/util/LinkedList;
    //   13: invokevirtual 187	java/util/LinkedList:isEmpty	()Z
    //   16: ifeq +65 -> 81
    //   19: aload_0
    //   20: getfield 67	com/facebook/orca/server/OrcaServiceQueue:d	Ljava/util/Set;
    //   23: invokeinterface 190 1 0
    //   28: astore 19
    //   30: aload 19
    //   32: invokeinterface 136 1 0
    //   37: ifeq +26 -> 63
    //   40: aload 19
    //   42: invokeinterface 140 1 0
    //   47: checkcast 192	com/facebook/orca/server/OrcaServiceQueueHook
    //   50: invokeinterface 194 1 0
    //   55: goto -25 -> 30
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    //   63: aload_0
    //   64: getfield 71	com/facebook/orca/server/OrcaServiceQueue:f	Lcom/facebook/background/BackgroundTaskManager;
    //   67: aload_0
    //   68: getfield 63	com/facebook/orca/server/OrcaServiceQueue:b	Ljava/lang/Class;
    //   71: invokevirtual 199	com/facebook/background/BackgroundTaskManager:b	(Ljava/lang/Class;)V
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_0
    //   77: invokespecial 201	com/facebook/orca/server/OrcaServiceQueue:e	()V
    //   80: return
    //   81: aload_0
    //   82: getfield 52	com/facebook/orca/server/OrcaServiceQueue:h	Ljava/util/LinkedList;
    //   85: invokevirtual 204	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   88: checkcast 206	com/facebook/orca/server/Operation
    //   91: astore_2
    //   92: aload_0
    //   93: getfield 61	com/facebook/orca/server/OrcaServiceQueue:i	Ljava/util/Map;
    //   96: aload_2
    //   97: invokevirtual 209	com/facebook/orca/server/Operation:b	()Ljava/lang/String;
    //   100: invokeinterface 215 2 0
    //   105: checkcast 100	com/facebook/orca/server/OrcaServiceQueue$OperationHolder
    //   108: astore_3
    //   109: aload_3
    //   110: ifnonnull +16 -> 126
    //   113: getstatic 41	com/facebook/orca/server/OrcaServiceQueue:a	Ljava/lang/Class;
    //   116: ldc 217
    //   118: invokestatic 222	com/facebook/orca/debug/BLog:d	(Ljava/lang/Class;Ljava/lang/String;)V
    //   121: aload_0
    //   122: monitorexit
    //   123: goto -123 -> 0
    //   126: aload_3
    //   127: invokestatic 109	java/lang/System:currentTimeMillis	()J
    //   130: invokestatic 224	com/facebook/orca/server/OrcaServiceQueue$OperationHolder:a	(Lcom/facebook/orca/server/OrcaServiceQueue$OperationHolder;J)J
    //   133: pop2
    //   134: aload_0
    //   135: monitorexit
    //   136: ldc2_w 225
    //   139: invokestatic 230	com/facebook/orca/debug/Tracer:b	(J)V
    //   142: new 232	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   149: ldc 235
    //   151: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_2
    //   155: invokevirtual 241	com/facebook/orca/server/Operation:a	()Ljava/lang/String;
    //   158: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 243
    //   163: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 249	com/facebook/orca/debug/Tracer:a	(Ljava/lang/String;)Lcom/facebook/orca/debug/Tracer;
    //   172: astore 6
    //   174: aload_0
    //   175: getfield 251	com/facebook/orca/server/OrcaServiceQueue:k	Z
    //   178: ifeq +67 -> 245
    //   181: new 253	java/lang/Exception
    //   184: dup
    //   185: ldc 255
    //   187: invokespecial 258	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   190: athrow
    //   191: astore 10
    //   193: getstatic 41	com/facebook/orca/server/OrcaServiceQueue:a	Ljava/lang/Class;
    //   196: ldc_w 260
    //   199: aload 10
    //   201: invokestatic 263	com/facebook/orca/debug/BLog:d	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   204: aload_0
    //   205: aload_3
    //   206: aload 10
    //   208: invokestatic 268	com/facebook/orca/server/ErrorCodeUtil:b	(Ljava/lang/Throwable;)Lcom/facebook/orca/server/ErrorCode;
    //   211: aload 10
    //   213: invokestatic 271	com/facebook/orca/server/ErrorCodeUtil:c	(Ljava/lang/Throwable;)Landroid/os/Bundle;
    //   216: invokestatic 276	com/facebook/orca/server/OperationResult:a	(Lcom/facebook/orca/server/ErrorCode;Landroid/os/Bundle;)Lcom/facebook/orca/server/OperationResult;
    //   219: invokespecial 181	com/facebook/orca/server/OrcaServiceQueue:a	(Lcom/facebook/orca/server/OrcaServiceQueue$OperationHolder;Lcom/facebook/orca/server/OperationResult;)V
    //   222: aload 6
    //   224: lconst_0
    //   225: invokevirtual 279	com/facebook/orca/debug/Tracer:a	(J)J
    //   228: pop2
    //   229: iconst_3
    //   230: invokestatic 282	com/facebook/orca/debug/BLog:b	(I)Z
    //   233: ifeq +186 -> 419
    //   236: getstatic 41	com/facebook/orca/server/OrcaServiceQueue:a	Ljava/lang/Class;
    //   239: invokestatic 284	com/facebook/orca/debug/Tracer:a	(Ljava/lang/Class;)V
    //   242: goto -242 -> 0
    //   245: aload_2
    //   246: invokevirtual 287	com/facebook/orca/server/Operation:c	()Landroid/os/Bundle;
    //   249: ldc_w 289
    //   252: invokevirtual 295	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   255: astore 13
    //   257: aload 13
    //   259: ifnull +12 -> 271
    //   262: aload_0
    //   263: getfield 73	com/facebook/orca/server/OrcaServiceQueue:g	Lcom/facebook/login/ContextAwareAuthTokenStringSupplier;
    //   266: aload 13
    //   268: invokevirtual 299	com/facebook/login/ContextAwareAuthTokenStringSupplier:a	(Ljava/lang/String;)V
    //   271: new 301	com/facebook/orca/server/OperationParams
    //   274: dup
    //   275: aload_2
    //   276: invokevirtual 241	com/facebook/orca/server/Operation:a	()Ljava/lang/String;
    //   279: aload_2
    //   280: invokevirtual 287	com/facebook/orca/server/Operation:c	()Landroid/os/Bundle;
    //   283: aload_3
    //   284: invokestatic 304	com/facebook/orca/server/OrcaServiceQueue$OperationHolder:b	(Lcom/facebook/orca/server/OrcaServiceQueue$OperationHolder;)Lcom/facebook/orca/server/OrcaServiceProgressCallback;
    //   287: invokespecial 307	com/facebook/orca/server/OperationParams:<init>	(Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/orca/server/OrcaServiceProgressCallback;)V
    //   290: astore 14
    //   292: aload_0
    //   293: getfield 65	com/facebook/orca/server/OrcaServiceQueue:c	Lcom/facebook/orca/server/OrcaServiceHandler;
    //   296: aload 14
    //   298: invokeinterface 312 2 0
    //   303: astore 16
    //   305: aload 13
    //   307: ifnull +10 -> 317
    //   310: aload_0
    //   311: getfield 73	com/facebook/orca/server/OrcaServiceQueue:g	Lcom/facebook/login/ContextAwareAuthTokenStringSupplier;
    //   314: invokevirtual 313	com/facebook/login/ContextAwareAuthTokenStringSupplier:a	()V
    //   317: aload 16
    //   319: instanceof 315
    //   322: ifeq +81 -> 403
    //   325: aload_0
    //   326: aload_3
    //   327: aload 16
    //   329: checkcast 315	com/facebook/orca/server/FutureOperationResult
    //   332: invokevirtual 318	com/facebook/orca/server/FutureOperationResult:a	()Lcom/google/common/util/concurrent/ListenableFuture;
    //   335: invokespecial 320	com/facebook/orca/server/OrcaServiceQueue:a	(Lcom/facebook/orca/server/OrcaServiceQueue$OperationHolder;Lcom/google/common/util/concurrent/ListenableFuture;)V
    //   338: aload 6
    //   340: lconst_0
    //   341: invokevirtual 279	com/facebook/orca/debug/Tracer:a	(J)J
    //   344: pop2
    //   345: iconst_3
    //   346: invokestatic 282	com/facebook/orca/debug/BLog:b	(I)Z
    //   349: ifeq +64 -> 413
    //   352: getstatic 41	com/facebook/orca/server/OrcaServiceQueue:a	Ljava/lang/Class;
    //   355: invokestatic 284	com/facebook/orca/debug/Tracer:a	(Ljava/lang/Class;)V
    //   358: goto -358 -> 0
    //   361: astore 15
    //   363: aload 13
    //   365: ifnull +10 -> 375
    //   368: aload_0
    //   369: getfield 73	com/facebook/orca/server/OrcaServiceQueue:g	Lcom/facebook/login/ContextAwareAuthTokenStringSupplier;
    //   372: invokevirtual 313	com/facebook/login/ContextAwareAuthTokenStringSupplier:a	()V
    //   375: aload 15
    //   377: athrow
    //   378: astore 7
    //   380: aload 6
    //   382: lconst_0
    //   383: invokevirtual 279	com/facebook/orca/debug/Tracer:a	(J)J
    //   386: pop2
    //   387: iconst_3
    //   388: invokestatic 282	com/facebook/orca/debug/BLog:b	(I)Z
    //   391: ifeq +34 -> 425
    //   394: getstatic 41	com/facebook/orca/server/OrcaServiceQueue:a	Ljava/lang/Class;
    //   397: invokestatic 284	com/facebook/orca/debug/Tracer:a	(Ljava/lang/Class;)V
    //   400: aload 7
    //   402: athrow
    //   403: aload_0
    //   404: aload_3
    //   405: aload 16
    //   407: invokespecial 181	com/facebook/orca/server/OrcaServiceQueue:a	(Lcom/facebook/orca/server/OrcaServiceQueue$OperationHolder;Lcom/facebook/orca/server/OperationResult;)V
    //   410: goto -72 -> 338
    //   413: invokestatic 322	com/facebook/orca/debug/Tracer:b	()V
    //   416: goto -416 -> 0
    //   419: invokestatic 322	com/facebook/orca/debug/Tracer:b	()V
    //   422: goto -422 -> 0
    //   425: invokestatic 322	com/facebook/orca/debug/Tracer:b	()V
    //   428: goto -28 -> 400
    //
    // Exception table:
    //   from	to	target	type
    //   9	61	58	finally
    //   63	76	58	finally
    //   81	136	58	finally
    //   174	191	191	java/lang/Throwable
    //   245	271	191	java/lang/Throwable
    //   310	338	191	java/lang/Throwable
    //   368	378	191	java/lang/Throwable
    //   403	410	191	java/lang/Throwable
    //   271	305	361	finally
    //   174	191	378	finally
    //   193	222	378	finally
    //   245	271	378	finally
    //   310	338	378	finally
    //   368	378	378	finally
    //   403	410	378	finally
  }

  private void e()
  {
    monitorenter;
    try
    {
      long l1 = System.currentTimeMillis();
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        Operation localOperation = (Operation)localIterator.next();
        OrcaServiceQueue.OperationHolder localOperationHolder = (OrcaServiceQueue.OperationHolder)this.i.get(localOperation.b());
        if (localOperationHolder == null)
        {
          BLog.d(a, "No holder for recently completed operation!");
          localIterator.remove();
        }
        if (l1 - OrcaServiceQueue.OperationHolder.c(localOperationHolder) <= 30000L)
          break;
        this.i.remove(localOperation.b());
        localIterator.remove();
      }
    }
    finally
    {
      monitorexit;
    }
    if (this.j.size() > 0)
      a(15000L);
    monitorexit;
  }

  Class<? extends Annotation> a()
  {
    return this.b;
  }

  void a(Operation paramOperation)
  {
    boolean bool;
    if (!this.k)
      bool = true;
    while (true)
    {
      Preconditions.checkState(bool, "Cannot add an operation after queue was stopped");
      monitorenter;
      try
      {
        OrcaServiceQueue.OperationHolder localOperationHolder = new OrcaServiceQueue.OperationHolder(paramOperation);
        OrcaServiceQueue.OperationHolder.a(localOperationHolder, new OrcaServiceQueue.2(this, localOperationHolder));
        this.h.add(paramOperation);
        this.i.put(paramOperation.b(), localOperationHolder);
        monitorexit;
        Iterator localIterator = this.d.iterator();
        while (true)
          if (localIterator.hasNext())
          {
            ((OrcaServiceQueueHook)localIterator.next()).a(paramOperation);
            continue;
            bool = false;
            break;
          }
      }
      finally
      {
        monitorexit;
      }
    }
    this.f.a(this.b);
    a(0L);
  }

  boolean a(String paramString)
  {
    monitorenter;
    try
    {
      boolean bool = this.i.containsKey(paramString);
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  boolean a(String paramString, ICompletionHandler paramICompletionHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/facebook/orca/server/OrcaServiceQueue:i	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 215 2 0
    //   12: checkcast 100	com/facebook/orca/server/OrcaServiceQueue$OperationHolder
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +11 -> 30
    //   22: aload_0
    //   23: monitorexit
    //   24: iconst_0
    //   25: istore 7
    //   27: goto +67 -> 94
    //   30: aload 4
    //   32: invokestatic 145	com/facebook/orca/server/OrcaServiceQueue$OperationHolder:f	(Lcom/facebook/orca/server/OrcaServiceQueue$OperationHolder;)Lcom/facebook/orca/server/OperationResult;
    //   35: ifnull +31 -> 66
    //   38: aload 4
    //   40: invokestatic 145	com/facebook/orca/server/OrcaServiceQueue$OperationHolder:f	(Lcom/facebook/orca/server/OrcaServiceQueue$OperationHolder;)Lcom/facebook/orca/server/OperationResult;
    //   43: astore 6
    //   45: aload_0
    //   46: monitorexit
    //   47: aload 6
    //   49: ifnull +11 -> 60
    //   52: aload_2
    //   53: aload 6
    //   55: invokeinterface 148 2 0
    //   60: iconst_1
    //   61: istore 7
    //   63: goto +31 -> 94
    //   66: aload 4
    //   68: invokestatic 124	com/facebook/orca/server/OrcaServiceQueue$OperationHolder:e	(Lcom/facebook/orca/server/OrcaServiceQueue$OperationHolder;)Ljava/util/List;
    //   71: aload_2
    //   72: invokeinterface 374 2 0
    //   77: pop
    //   78: aconst_null
    //   79: astore 6
    //   81: goto -36 -> 45
    //   84: astore_3
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_3
    //   88: athrow
    //   89: astore 8
    //   91: goto -31 -> 60
    //   94: iload 7
    //   96: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   2	47	84	finally
    //   66	87	84	finally
    //   52	60	89	android/os/RemoteException
  }

  void b()
  {
    if (!this.k);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "Queue cannot be started after stopped");
      this.l = new HandlerThread("OrcaServiceQueue - " + this.b);
      this.l.start();
      this.m = new Handler(this.l.getLooper());
      this.n = new HandlerExecutorService(this.m);
      this.e.a(this);
      return;
    }
  }

  void c()
  {
    Handler localHandler = this.m;
    if (localHandler != null)
    {
      this.k = true;
      localHandler.post(new OrcaServiceQueue.1(this));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OrcaServiceQueue
 * JD-Core Version:    0.6.0
 */