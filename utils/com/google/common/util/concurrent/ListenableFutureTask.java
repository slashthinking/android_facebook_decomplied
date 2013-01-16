package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public final class ListenableFutureTask<V> extends FutureTask<V>
  implements ListenableFuture<V>
{
  private final ExecutionList a = new ExecutionList();

  @Deprecated
  public ListenableFutureTask(Runnable paramRunnable, V paramV)
  {
    super(paramRunnable, paramV);
  }

  @Deprecated
  public ListenableFutureTask(Callable<V> paramCallable)
  {
    super(paramCallable);
  }

  public static <V> ListenableFutureTask<V> a(Runnable paramRunnable, V paramV)
  {
    return new ListenableFutureTask(paramRunnable, paramV);
  }

  public static <V> ListenableFutureTask<V> a(Callable<V> paramCallable)
  {
    return new ListenableFutureTask(paramCallable);
  }

  public void a(Runnable paramRunnable, Executor paramExecutor)
  {
    this.a.a(paramRunnable, paramExecutor);
  }

  protected void done()
  {
    this.a.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.ListenableFutureTask
 * JD-Core Version:    0.6.2
 */