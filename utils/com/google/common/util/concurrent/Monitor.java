package com.google.common.util.concurrent;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class Monitor
{
  private final ReentrantLock a;
  private final ArrayList<Monitor.Guard> b = Lists.b(1);

  public Monitor()
  {
    this(false);
  }

  public Monitor(boolean paramBoolean)
  {
    this.a = new ReentrantLock(paramBoolean);
  }

  private void a(Monitor.Guard paramGuard)
  {
    ArrayList localArrayList = this.b;
    int i = localArrayList.size();
    int j = 0;
    while (true)
    {
      if (j < i);
      try
      {
        Monitor.Guard localGuard = (Monitor.Guard)localArrayList.get(j);
        if (((localGuard != paramGuard) || (localGuard.d != 1)) && (localGuard.a()))
        {
          localGuard.c.signal();
          return;
          while (k < i)
          {
            ((Monitor.Guard)localArrayList.get(k)).c.signalAll();
            k++;
          }
          Throwable localThrowable1;
          throw Throwables.propagate(localThrowable1);
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
          int k = 0;
        j++;
      }
    }
  }

  // ERROR //
  private boolean a(Monitor.Guard paramGuard, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 51	com/google/common/util/concurrent/Monitor$Guard:a	()Z
    //   4: ifne +70 -> 74
    //   7: iload 4
    //   9: ifeq +8 -> 17
    //   12: aload_0
    //   13: aconst_null
    //   14: invokespecial 74	com/google/common/util/concurrent/Monitor:a	(Lcom/google/common/util/concurrent/Monitor$Guard;)V
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial 76	com/google/common/util/concurrent/Monitor:b	(Lcom/google/common/util/concurrent/Monitor$Guard;)V
    //   22: aload_1
    //   23: getfield 55	com/google/common/util/concurrent/Monitor$Guard:c	Ljava/util/concurrent/locks/Condition;
    //   26: astore 7
    //   28: lload_2
    //   29: lconst_0
    //   30: lcmp
    //   31: ifgt +14 -> 45
    //   34: iconst_0
    //   35: istore 5
    //   37: aload_0
    //   38: aload_1
    //   39: invokespecial 78	com/google/common/util/concurrent/Monitor:c	(Lcom/google/common/util/concurrent/Monitor$Guard;)V
    //   42: iload 5
    //   44: ireturn
    //   45: aload 7
    //   47: lload_2
    //   48: invokeinterface 82 3 0
    //   53: lstore 10
    //   55: lload 10
    //   57: lstore_2
    //   58: aload_1
    //   59: invokevirtual 51	com/google/common/util/concurrent/Monitor$Guard:a	()Z
    //   62: istore 12
    //   64: iload 12
    //   66: ifeq -38 -> 28
    //   69: aload_0
    //   70: aload_1
    //   71: invokespecial 78	com/google/common/util/concurrent/Monitor:c	(Lcom/google/common/util/concurrent/Monitor$Guard;)V
    //   74: iconst_1
    //   75: istore 5
    //   77: goto -35 -> 42
    //   80: astore 8
    //   82: aload_0
    //   83: aload_1
    //   84: invokespecial 74	com/google/common/util/concurrent/Monitor:a	(Lcom/google/common/util/concurrent/Monitor$Guard;)V
    //   87: aload 8
    //   89: athrow
    //   90: astore 6
    //   92: aload_0
    //   93: aload_1
    //   94: invokespecial 78	com/google/common/util/concurrent/Monitor:c	(Lcom/google/common/util/concurrent/Monitor$Guard;)V
    //   97: aload 6
    //   99: athrow
    //   100: astore 9
    //   102: invokestatic 88	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   105: invokevirtual 91	java/lang/Thread:interrupt	()V
    //   108: aload 9
    //   110: invokestatic 69	com/google/common/base/Throwables:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   113: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   45	55	80	java/lang/InterruptedException
    //   22	28	90	finally
    //   45	55	90	finally
    //   58	64	90	finally
    //   82	87	90	finally
    //   87	90	90	finally
    //   102	114	90	finally
    //   82	87	100	java/lang/Throwable
  }

  private void b(Monitor.Guard paramGuard)
  {
    int i = paramGuard.d;
    paramGuard.d = (i + 1);
    if (i == 0)
      this.b.add(paramGuard);
  }

  private void c(Monitor.Guard paramGuard)
  {
    int i = -1 + paramGuard.d;
    paramGuard.d = i;
    if (i == 0)
      this.b.remove(paramGuard);
  }

  public void a()
  {
    this.a.lock();
  }

  public boolean a(Monitor.Guard paramGuard, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramGuard.b != this)
      throw new IllegalMonitorStateException();
    if (!this.a.isHeldByCurrentThread())
      throw new IllegalMonitorStateException();
    return a(paramGuard, paramTimeUnit.toNanos(paramLong), true);
  }

  public void b()
  {
    ReentrantLock localReentrantLock = this.a;
    if (!localReentrantLock.isHeldByCurrentThread())
      throw new IllegalMonitorStateException();
    try
    {
      a(null);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.Monitor
 * JD-Core Version:    0.6.2
 */