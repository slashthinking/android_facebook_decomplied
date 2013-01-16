package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class MoreExecutors$ListeningDecorator extends AbstractListeningExecutorService
{
  final ExecutorService a;

  MoreExecutors$ListeningDecorator(ExecutorService paramExecutorService)
  {
    this.a = ((ExecutorService)Preconditions.checkNotNull(paramExecutorService));
  }

  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.awaitTermination(paramLong, paramTimeUnit);
  }

  public void execute(Runnable paramRunnable)
  {
    this.a.execute(paramRunnable);
  }

  public boolean isShutdown()
  {
    return this.a.isShutdown();
  }

  public boolean isTerminated()
  {
    return this.a.isTerminated();
  }

  public void shutdown()
  {
    this.a.shutdown();
  }

  public List<Runnable> shutdownNow()
  {
    return this.a.shutdownNow();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.MoreExecutors.ListeningDecorator
 * JD-Core Version:    0.6.2
 */