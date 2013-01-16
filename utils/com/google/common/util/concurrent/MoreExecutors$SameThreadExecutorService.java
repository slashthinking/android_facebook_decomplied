package com.google.common.util.concurrent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MoreExecutors$SameThreadExecutorService extends AbstractListeningExecutorService
{
  private final Lock a = new ReentrantLock();
  private final Condition b = this.a.newCondition();
  private int c = 0;
  private boolean d = false;

  private void a()
  {
    this.a.lock();
    try
    {
      if (isShutdown())
        throw new RejectedExecutionException("Executor already shutdown");
    }
    finally
    {
      this.a.unlock();
    }
    this.c = (1 + this.c);
    this.a.unlock();
  }

  private void b()
  {
    this.a.lock();
    try
    {
      this.c = (-1 + this.c);
      if (isTerminated())
        this.b.signalAll();
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }

  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    long l1 = paramTimeUnit.toNanos(paramLong);
    this.a.lock();
    try
    {
      while (true)
      {
        boolean bool1 = isTerminated();
        if (bool1);
        for (boolean bool2 = true; ; bool2 = false)
        {
          return bool2;
          if (l1 > 0L)
            break;
          this.a.unlock();
        }
        long l2 = this.b.awaitNanos(l1);
        l1 = l2;
      }
    }
    finally
    {
      this.a.unlock();
    }
  }

  public void execute(Runnable paramRunnable)
  {
    a();
    try
    {
      paramRunnable.run();
      return;
    }
    finally
    {
      b();
    }
  }

  public boolean isShutdown()
  {
    this.a.lock();
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      this.a.unlock();
    }
  }

  public boolean isTerminated()
  {
    this.a.lock();
    try
    {
      if (this.d)
      {
        int i = this.c;
        if (i == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
    finally
    {
      this.a.unlock();
    }
  }

  public void shutdown()
  {
    this.a.lock();
    try
    {
      this.d = true;
      return;
    }
    finally
    {
      this.a.unlock();
    }
  }

  public List<Runnable> shutdownNow()
  {
    shutdown();
    return Collections.emptyList();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.MoreExecutors.SameThreadExecutorService
 * JD-Core Version:    0.6.2
 */