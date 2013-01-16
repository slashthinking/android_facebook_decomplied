package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public abstract interface ListeningExecutorService extends ExecutorService
{
  public abstract ListenableFuture<?> a(Runnable paramRunnable);

  public abstract <T> ListenableFuture<T> a(Callable<T> paramCallable);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.ListeningExecutorService
 * JD-Core Version:    0.6.2
 */