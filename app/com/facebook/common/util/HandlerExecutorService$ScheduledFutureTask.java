package com.facebook.common.util;

import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class HandlerExecutorService$ScheduledFutureTask<V> extends FutureTask<V>
  implements ScheduledFuture<V>
{
  public HandlerExecutorService$ScheduledFutureTask(Runnable paramRunnable, V paramV)
  {
    super(paramV, localObject);
  }

  public HandlerExecutorService$ScheduledFutureTask(Callable<V> paramCallable)
  {
    super(localCallable);
  }

  public int a(Delayed paramDelayed)
  {
    throw new UnsupportedOperationException();
  }

  public long getDelay(TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.HandlerExecutorService.ScheduledFutureTask
 * JD-Core Version:    0.6.0
 */