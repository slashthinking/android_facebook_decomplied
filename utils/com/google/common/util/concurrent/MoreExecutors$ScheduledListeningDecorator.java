package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class MoreExecutors$ScheduledListeningDecorator extends MoreExecutors.ListeningDecorator
  implements ListeningScheduledExecutorService
{
  final ScheduledExecutorService b;

  MoreExecutors$ScheduledListeningDecorator(ScheduledExecutorService paramScheduledExecutorService)
  {
    super(paramScheduledExecutorService);
    this.b = ((ScheduledExecutorService)Preconditions.checkNotNull(paramScheduledExecutorService));
  }

  public ScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.b.schedule(paramRunnable, paramLong, paramTimeUnit);
  }

  public <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.b.schedule(paramCallable, paramLong, paramTimeUnit);
  }

  public ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return this.b.scheduleAtFixedRate(paramRunnable, paramLong1, paramLong2, paramTimeUnit);
  }

  public ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return this.b.scheduleWithFixedDelay(paramRunnable, paramLong1, paramLong2, paramTimeUnit);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.MoreExecutors.ScheduledListeningDecorator
 * JD-Core Version:    0.6.2
 */