package com.google.common.util.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

abstract class AbstractListeningExecutorService
  implements ListeningExecutorService
{
  // ERROR //
  private <T> T a(Collection<? extends Callable<T>> paramCollection, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 22 1 0
    //   6: istore 5
    //   8: iload 5
    //   10: ifle +207 -> 217
    //   13: iconst_1
    //   14: istore 6
    //   16: iload 6
    //   18: invokestatic 28	com/google/common/base/Preconditions:checkArgument	(Z)V
    //   21: new 30	java/util/ArrayList
    //   24: dup
    //   25: iload 5
    //   27: invokespecial 33	java/util/ArrayList:<init>	(I)V
    //   30: astore 7
    //   32: new 35	java/util/concurrent/ExecutorCompletionService
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 38	java/util/concurrent/ExecutorCompletionService:<init>	(Ljava/util/concurrent/Executor;)V
    //   40: astore 8
    //   42: aconst_null
    //   43: astore 9
    //   45: iload_2
    //   46: ifeq +177 -> 223
    //   49: invokestatic 44	java/lang/System:nanoTime	()J
    //   52: lstore 10
    //   54: aload_1
    //   55: invokeinterface 48 1 0
    //   60: astore 15
    //   62: aload 7
    //   64: aload 8
    //   66: aload 15
    //   68: invokeinterface 54 1 0
    //   73: checkcast 56	java/util/concurrent/Callable
    //   76: invokevirtual 60	java/util/concurrent/ExecutorCompletionService:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   79: invokeinterface 66 2 0
    //   84: pop
    //   85: iload 5
    //   87: iconst_1
    //   88: isub
    //   89: istore 17
    //   91: iconst_1
    //   92: istore 18
    //   94: lload_3
    //   95: lstore 19
    //   97: aload 8
    //   99: invokevirtual 70	java/util/concurrent/ExecutorCompletionService:poll	()Ljava/util/concurrent/Future;
    //   102: astore 21
    //   104: aload 21
    //   106: ifnonnull +323 -> 429
    //   109: iload 17
    //   111: ifle +118 -> 229
    //   114: iload 17
    //   116: iconst_1
    //   117: isub
    //   118: istore 37
    //   120: aload 7
    //   122: aload 8
    //   124: aload 15
    //   126: invokeinterface 54 1 0
    //   131: checkcast 56	java/util/concurrent/Callable
    //   134: invokevirtual 60	java/util/concurrent/ExecutorCompletionService:submit	(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
    //   137: invokeinterface 66 2 0
    //   142: pop
    //   143: iload 18
    //   145: iconst_1
    //   146: iadd
    //   147: istore 22
    //   149: lload 10
    //   151: lstore 25
    //   153: iload 37
    //   155: istore 27
    //   157: lload 19
    //   159: lstore 23
    //   161: aload 21
    //   163: ifnull +236 -> 399
    //   166: iinc 22 255
    //   169: aload 21
    //   171: invokeinterface 75 1 0
    //   176: astore 29
    //   178: aload 7
    //   180: invokeinterface 76 1 0
    //   185: astore 30
    //   187: aload 30
    //   189: invokeinterface 80 1 0
    //   194: ifeq +232 -> 426
    //   197: aload 30
    //   199: invokeinterface 54 1 0
    //   204: checkcast 72	java/util/concurrent/Future
    //   207: iconst_1
    //   208: invokeinterface 84 2 0
    //   213: pop
    //   214: goto -27 -> 187
    //   217: iconst_0
    //   218: istore 6
    //   220: goto -204 -> 16
    //   223: lconst_0
    //   224: lstore 10
    //   226: goto -172 -> 54
    //   229: iload 18
    //   231: ifne +62 -> 293
    //   234: aload 9
    //   236: ifnonnull +13 -> 249
    //   239: new 14	java/util/concurrent/ExecutionException
    //   242: dup
    //   243: aconst_null
    //   244: invokespecial 87	java/util/concurrent/ExecutionException:<init>	(Ljava/lang/Throwable;)V
    //   247: astore 9
    //   249: aload 9
    //   251: athrow
    //   252: astore 12
    //   254: aload 7
    //   256: invokeinterface 76 1 0
    //   261: astore 13
    //   263: aload 13
    //   265: invokeinterface 80 1 0
    //   270: ifeq +148 -> 418
    //   273: aload 13
    //   275: invokeinterface 54 1 0
    //   280: checkcast 72	java/util/concurrent/Future
    //   283: iconst_1
    //   284: invokeinterface 84 2 0
    //   289: pop
    //   290: goto -27 -> 263
    //   293: iload_2
    //   294: ifeq +66 -> 360
    //   297: aload 8
    //   299: lload 19
    //   301: getstatic 93	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
    //   304: invokevirtual 96	java/util/concurrent/ExecutorCompletionService:poll	(JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/Future;
    //   307: astore 32
    //   309: aload 32
    //   311: ifnonnull +11 -> 322
    //   314: new 98	java/util/concurrent/TimeoutException
    //   317: dup
    //   318: invokespecial 99	java/util/concurrent/TimeoutException:<init>	()V
    //   321: athrow
    //   322: invokestatic 44	java/lang/System:nanoTime	()J
    //   325: lstore 33
    //   327: lload 19
    //   329: lload 33
    //   331: lload 10
    //   333: lsub
    //   334: lsub
    //   335: lstore 35
    //   337: aload 32
    //   339: astore 21
    //   341: iload 18
    //   343: istore 22
    //   345: lload 35
    //   347: lstore 23
    //   349: iload 17
    //   351: istore 27
    //   353: lload 33
    //   355: lstore 25
    //   357: goto -196 -> 161
    //   360: aload 8
    //   362: invokevirtual 102	java/util/concurrent/ExecutorCompletionService:take	()Ljava/util/concurrent/Future;
    //   365: astore 21
    //   367: lload 19
    //   369: lstore 23
    //   371: iload 18
    //   373: istore 22
    //   375: lload 10
    //   377: lstore 25
    //   379: iload 17
    //   381: istore 27
    //   383: goto -222 -> 161
    //   386: astore 28
    //   388: new 14	java/util/concurrent/ExecutionException
    //   391: dup
    //   392: aload 28
    //   394: invokespecial 87	java/util/concurrent/ExecutionException:<init>	(Ljava/lang/Throwable;)V
    //   397: astore 9
    //   399: iload 27
    //   401: istore 17
    //   403: lload 23
    //   405: lstore 19
    //   407: lload 25
    //   409: lstore 10
    //   411: iload 22
    //   413: istore 18
    //   415: goto -318 -> 97
    //   418: aload 12
    //   420: athrow
    //   421: astore 9
    //   423: goto -24 -> 399
    //   426: aload 29
    //   428: areturn
    //   429: iload 18
    //   431: istore 22
    //   433: lload 19
    //   435: lstore 23
    //   437: lload 10
    //   439: lstore 25
    //   441: iload 17
    //   443: istore 27
    //   445: goto -284 -> 161
    //
    // Exception table:
    //   from	to	target	type
    //   49	143	252	finally
    //   169	178	252	finally
    //   239	252	252	finally
    //   297	399	252	finally
    //   169	178	386	java/lang/RuntimeException
    //   169	178	421	java/util/concurrent/ExecutionException
  }

  public ListenableFuture<?> a(Runnable paramRunnable)
  {
    ListenableFutureTask localListenableFutureTask = ListenableFutureTask.a(paramRunnable, null);
    execute(localListenableFutureTask);
    return localListenableFutureTask;
  }

  public <T> ListenableFuture<T> a(Runnable paramRunnable, T paramT)
  {
    ListenableFutureTask localListenableFutureTask = ListenableFutureTask.a(paramRunnable, paramT);
    execute(localListenableFutureTask);
    return localListenableFutureTask;
  }

  public <T> ListenableFuture<T> a(Callable<T> paramCallable)
  {
    ListenableFutureTask localListenableFutureTask = ListenableFutureTask.a(paramCallable);
    execute(localListenableFutureTask);
    return localListenableFutureTask;
  }

  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection)
  {
    if (paramCollection == null)
      throw new NullPointerException();
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    try
    {
      Iterator localIterator2 = paramCollection.iterator();
      while (localIterator2.hasNext())
      {
        ListenableFutureTask localListenableFutureTask = ListenableFutureTask.a((Callable)localIterator2.next());
        localArrayList.add(localListenableFutureTask);
        execute(localListenableFutureTask);
      }
    }
    finally
    {
      Iterator localIterator1 = localArrayList.iterator();
      Iterator localIterator3;
      while (localIterator1.hasNext())
      {
        ((Future)localIterator1.next()).cancel(true);
        continue;
        localIterator3 = localArrayList.iterator();
      }
      while (localIterator3.hasNext())
      {
        Future localFuture = (Future)localIterator3.next();
        boolean bool = localFuture.isDone();
        if (!bool)
          try
          {
            localFuture.get();
          }
          catch (CancellationException localCancellationException)
          {
            continue;
            throw localObject;
          }
          catch (ExecutionException localExecutionException)
          {
          }
      }
    }
    return localArrayList;
  }

  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    if ((paramCollection == null) || (paramTimeUnit == null))
      throw new NullPointerException();
    long l1 = paramTimeUnit.toNanos(paramLong);
    ArrayList localArrayList1 = new ArrayList(paramCollection.size());
    while (true)
    {
      Iterator localIterator1;
      try
      {
        Iterator localIterator2 = paramCollection.iterator();
        if (!localIterator2.hasNext())
          break;
        localArrayList1.add(ListenableFutureTask.a((Callable)localIterator2.next()));
        continue;
      }
      finally
      {
        localIterator1 = localArrayList1.iterator();
        if (!localIterator1.hasNext())
          break label435;
      }
      ((Future)localIterator1.next()).cancel(true);
    }
    long l2 = System.nanoTime();
    Iterator localIterator3 = localArrayList1.iterator();
    long l6;
    if (localIterator3.hasNext())
    {
      execute((Runnable)localIterator3.next());
      l6 = System.nanoTime();
      l1 -= l6 - l2;
      if (l1 <= 0L)
      {
        Iterator localIterator7 = localArrayList1.iterator();
        while (localIterator7.hasNext())
          ((Future)localIterator7.next()).cancel(true);
      }
    }
    Future localFuture;
    for (ArrayList localArrayList2 = localArrayList1; ; localArrayList2 = localArrayList1)
    {
      return localArrayList2;
      l2 = l6;
      break;
      Iterator localIterator4 = localArrayList1.iterator();
      if (!localIterator4.hasNext())
        break label428;
      localFuture = (Future)localIterator4.next();
      boolean bool = localFuture.isDone();
      if (bool)
        break label448;
      if (l1 > 0L)
        break label337;
      Iterator localIterator6 = localArrayList1.iterator();
      while (localIterator6.hasNext())
        ((Future)localIterator6.next()).cancel(true);
    }
    while (true)
    {
      try
      {
        label337: localFuture.get(l1, TimeUnit.NANOSECONDS);
        long l5 = System.nanoTime();
        l3 = l5;
        l4 = l1 - (l3 - l2);
        l1 = l4;
        l2 = l3;
      }
      catch (TimeoutException localTimeoutException)
      {
        Iterator localIterator5 = localArrayList1.iterator();
        if (localIterator5.hasNext())
        {
          ((Future)localIterator5.next()).cancel(true);
          continue;
        }
        localArrayList2 = localArrayList1;
        break;
        localArrayList2 = localArrayList1;
        break;
        throw localObject;
      }
      catch (ExecutionException localExecutionException)
      {
        continue;
      }
      catch (CancellationException localCancellationException)
      {
        label428: label435: continue;
      }
      label448: long l3 = l2;
      long l4 = l1;
    }
  }

  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection)
  {
    try
    {
      Object localObject = a(paramCollection, false, 0L);
      return localObject;
    }
    catch (TimeoutException localTimeoutException)
    {
    }
    throw new AssertionError();
  }

  public <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramCollection, true, paramTimeUnit.toNanos(paramLong));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractListeningExecutorService
 * JD-Core Version:    0.6.2
 */