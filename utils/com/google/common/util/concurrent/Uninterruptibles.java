package com.google.common.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class Uninterruptibles
{
  // ERROR //
  public static <E> E a(java.util.concurrent.BlockingQueue<E> paramBlockingQueue)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokeinterface 18 1 0
    //   8: astore 4
    //   10: iload_1
    //   11: ifeq +9 -> 20
    //   14: invokestatic 24	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   17: invokevirtual 27	java/lang/Thread:interrupt	()V
    //   20: aload 4
    //   22: areturn
    //   23: astore_3
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -24 -> 2
    //   29: astore_2
    //   30: iload_1
    //   31: ifeq +9 -> 40
    //   34: invokestatic 24	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   37: invokevirtual 27	java/lang/Thread:interrupt	()V
    //   40: aload_2
    //   41: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	10	23	java/lang/InterruptedException
    //   2	10	29	finally
  }

  // ERROR //
  public static <V> V a(Future<V> paramFuture)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokeinterface 33 1 0
    //   8: astore 4
    //   10: iload_1
    //   11: ifeq +9 -> 20
    //   14: invokestatic 24	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   17: invokevirtual 27	java/lang/Thread:interrupt	()V
    //   20: aload 4
    //   22: areturn
    //   23: astore_3
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -24 -> 2
    //   29: astore_2
    //   30: iload_1
    //   31: ifeq +9 -> 40
    //   34: invokestatic 24	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   37: invokevirtual 27	java/lang/Thread:interrupt	()V
    //   40: aload_2
    //   41: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	10	23	java/lang/InterruptedException
    //   2	10	29	finally
  }

  public static <V> V a(Future<V> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    int i = 0;
    try
    {
      long l1 = paramTimeUnit.toNanos(paramLong);
      long l2 = System.nanoTime();
      long l3 = l2 + l1;
      while (true)
        try
        {
          Object localObject2 = paramFuture.get(l1, TimeUnit.NANOSECONDS);
          return localObject2;
        }
        catch (InterruptedException localInterruptedException)
        {
          i = 1;
          long l4 = System.nanoTime();
          l1 = l3 - l4;
        }
    }
    finally
    {
      if (i != 0)
        Thread.currentThread().interrupt();
    }
  }

  // ERROR //
  public static <E> void a(java.util.concurrent.BlockingQueue<E> paramBlockingQueue, E paramE)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokeinterface 58 2 0
    //   9: iload_2
    //   10: ifeq +9 -> 19
    //   13: invokestatic 24	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   16: invokevirtual 27	java/lang/Thread:interrupt	()V
    //   19: return
    //   20: astore 4
    //   22: iconst_1
    //   23: istore_2
    //   24: goto -22 -> 2
    //   27: astore_3
    //   28: iload_2
    //   29: ifeq +9 -> 38
    //   32: invokestatic 24	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   35: invokevirtual 27	java/lang/Thread:interrupt	()V
    //   38: aload_3
    //   39: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	9	20	java/lang/InterruptedException
    //   2	9	27	finally
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.Uninterruptibles
 * JD-Core Version:    0.6.2
 */