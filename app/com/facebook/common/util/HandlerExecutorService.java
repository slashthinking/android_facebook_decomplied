package com.facebook.common.util;

import android.os.Handler;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class HandlerExecutorService extends AbstractExecutorService
  implements ScheduledExecutorService
{
  private final Handler a;

  public HandlerExecutorService(Handler paramHandler)
  {
    this.a = paramHandler;
  }

  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }

  public void execute(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }

  public boolean isShutdown()
  {
    return false;
  }

  public boolean isTerminated()
  {
    return false;
  }

  public ScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    HandlerExecutorService.ScheduledFutureTask localScheduledFutureTask = new HandlerExecutorService.ScheduledFutureTask(this, paramRunnable, null);
    this.a.postDelayed(localScheduledFutureTask, paramTimeUnit.toMillis(paramLong));
    return localScheduledFutureTask;
  }

  public <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    HandlerExecutorService.ScheduledFutureTask localScheduledFutureTask = new HandlerExecutorService.ScheduledFutureTask(this, paramCallable);
    this.a.postDelayed(localScheduledFutureTask, paramTimeUnit.toMillis(paramLong));
    return localScheduledFutureTask;
  }

  public ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }

  public ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }

  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }

  public List<Runnable> shutdownNow()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.HandlerExecutorService
 * JD-Core Version:    0.6.0
 */