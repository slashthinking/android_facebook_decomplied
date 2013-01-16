package com.facebook.orca.common.async;

import com.facebook.orca.debug.BLog;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class KeyedExecutor
{
  private static final Class<?> a = KeyedExecutor.class;
  private static final ThreadLocal<AtomicInteger> b = new KeyedExecutor.1();
  private final ListeningExecutorService c;
  private final Map<Object, KeyedExecutor.TaskQueue> d = Maps.a();
  private final ConcurrentMap<Object, KeyedExecutor.Task> e = new MapMaker().h().n();

  public KeyedExecutor(ExecutorService paramExecutorService)
  {
    this.c = MoreExecutors.a(paramExecutorService);
  }

  private void a(KeyedExecutor.Task paramTask, KeyedExecutor.TaskQueue paramTaskQueue)
  {
    monitorenter;
    try
    {
      paramTaskQueue.c = null;
      this.e.remove(paramTask.b, paramTask);
      a(paramTaskQueue);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  private void a(KeyedExecutor.TaskQueue paramTaskQueue)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 65	com/facebook/orca/common/async/KeyedExecutor$TaskQueue:c	Lcom/google/common/util/concurrent/ListenableFuture;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 29	com/facebook/orca/common/async/KeyedExecutor:b	Ljava/lang/ThreadLocal;
    //   17: invokevirtual 85	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   20: checkcast 87	java/util/concurrent/atomic/AtomicInteger
    //   23: astore 4
    //   25: aload 4
    //   27: invokevirtual 91	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   30: pop
    //   31: aload_1
    //   32: getfield 94	com/facebook/orca/common/async/KeyedExecutor$TaskQueue:b	Ljava/util/Queue;
    //   35: invokeinterface 100 1 0
    //   40: ifeq +31 -> 71
    //   43: aload_0
    //   44: getfield 38	com/facebook/orca/common/async/KeyedExecutor:d	Ljava/util/Map;
    //   47: aload_1
    //   48: getfield 102	com/facebook/orca/common/async/KeyedExecutor$TaskQueue:a	Ljava/lang/Object;
    //   51: invokeinterface 107 2 0
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 110	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   62: pop
    //   63: goto -52 -> 11
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    //   71: aload 4
    //   73: invokevirtual 112	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   76: iconst_2
    //   77: if_icmple +74 -> 151
    //   80: aload_0
    //   81: getfield 58	com/facebook/orca/common/async/KeyedExecutor:c	Lcom/google/common/util/concurrent/ListeningExecutorService;
    //   84: astore 9
    //   86: aload_1
    //   87: getfield 94	com/facebook/orca/common/async/KeyedExecutor$TaskQueue:b	Ljava/util/Queue;
    //   90: invokeinterface 114 1 0
    //   95: checkcast 67	com/facebook/orca/common/async/KeyedExecutor$Task
    //   98: astore 10
    //   100: aload_1
    //   101: aload_0
    //   102: getfield 58	com/facebook/orca/common/async/KeyedExecutor:c	Lcom/google/common/util/concurrent/ListeningExecutorService;
    //   105: aload 10
    //   107: invokeinterface 119 2 0
    //   112: putfield 65	com/facebook/orca/common/async/KeyedExecutor$TaskQueue:c	Lcom/google/common/util/concurrent/ListenableFuture;
    //   115: aload_1
    //   116: getfield 65	com/facebook/orca/common/async/KeyedExecutor$TaskQueue:c	Lcom/google/common/util/concurrent/ListenableFuture;
    //   119: new 121	com/facebook/orca/common/async/KeyedExecutor$2
    //   122: dup
    //   123: aload_0
    //   124: aload 10
    //   126: aload_1
    //   127: invokespecial 124	com/facebook/orca/common/async/KeyedExecutor$2:<init>	(Lcom/facebook/orca/common/async/KeyedExecutor;Lcom/facebook/orca/common/async/KeyedExecutor$Task;Lcom/facebook/orca/common/async/KeyedExecutor$TaskQueue;)V
    //   130: aload 9
    //   132: invokeinterface 129 3 0
    //   137: goto -80 -> 57
    //   140: astore 6
    //   142: aload 4
    //   144: invokevirtual 110	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   147: pop
    //   148: aload 6
    //   150: athrow
    //   151: invokestatic 132	com/google/common/util/concurrent/MoreExecutors:a	()Lcom/google/common/util/concurrent/ListeningExecutorService;
    //   154: astore 8
    //   156: aload 8
    //   158: astore 9
    //   160: goto -74 -> 86
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	66	finally
    //   14	31	66	finally
    //   57	63	66	finally
    //   142	151	66	finally
    //   31	57	140	finally
    //   71	137	140	finally
    //   151	156	140	finally
  }

  public <T> ListenableFuture<T> a(Object paramObject)
  {
    KeyedExecutor.Task localTask = (KeyedExecutor.Task)this.e.get(paramObject);
    if (localTask != null);
    for (ListenableFutureTask localListenableFutureTask = KeyedExecutor.Task.a(localTask); ; localListenableFutureTask = null)
      return localListenableFutureTask;
  }

  public <T> ListenableFuture<T> a(Object paramObject1, Object paramObject2, Callable<T> paramCallable, String paramString)
  {
    monitorenter;
    while (true)
    {
      KeyedExecutor.TaskQueue localTaskQueue1;
      try
      {
        localTaskQueue1 = (KeyedExecutor.TaskQueue)this.d.get(paramObject1);
        if (localTaskQueue1 == null)
        {
          KeyedExecutor.TaskQueue localTaskQueue2 = new KeyedExecutor.TaskQueue(paramObject1);
          this.d.put(paramObject1, localTaskQueue2);
          localTaskQueue3 = localTaskQueue2;
          if (!this.e.containsKey(paramObject2))
            continue;
          BLog.d(a, "Already contains a callable for key " + paramObject2);
          KeyedExecutor.Task localTask = new KeyedExecutor.Task(paramObject1, paramObject2, paramCallable, paramString, null);
          this.e.put(paramObject2, localTask);
          localTaskQueue3.b.add(localTask);
          a(localTaskQueue3);
          ListenableFutureTask localListenableFutureTask = KeyedExecutor.Task.a(localTask);
          monitorexit;
          return localListenableFutureTask;
        }
      }
      finally
      {
        localObject = finally;
        monitorexit;
        throw localObject;
      }
      KeyedExecutor.TaskQueue localTaskQueue3 = localTaskQueue1;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.async.KeyedExecutor
 * JD-Core Version:    0.6.0
 */