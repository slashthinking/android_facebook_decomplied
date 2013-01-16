package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class AbstractFuture<V>
  implements ListenableFuture<V>
{
  private final AbstractFuture.Sync<V> a = new AbstractFuture.Sync();
  private final ExecutionList b = new ExecutionList();

  protected void a()
  {
  }

  public void a(Runnable paramRunnable, Executor paramExecutor)
  {
    this.b.a(paramRunnable, paramExecutor);
  }

  protected boolean a_(V paramV)
  {
    boolean bool = this.a.a(paramV);
    if (bool)
      b();
    return bool;
  }

  protected boolean a_(Throwable paramThrowable)
  {
    boolean bool = this.a.a((Throwable)Preconditions.checkNotNull(paramThrowable));
    if (bool)
      b();
    if ((paramThrowable instanceof Error))
      throw ((Error)paramThrowable);
    return bool;
  }

  @Deprecated
  protected void b()
  {
    this.b.a();
  }

  public boolean cancel(boolean paramBoolean)
  {
    if (!this.a.d());
    for (boolean bool = false; ; bool = true)
    {
      return bool;
      b();
      if (paramBoolean)
        a();
    }
  }

  public V get()
  {
    return this.a.a();
  }

  public V get(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.a(paramTimeUnit.toNanos(paramLong));
  }

  public boolean isCancelled()
  {
    return this.a.c();
  }

  public boolean isDone()
  {
    return this.a.b();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractFuture
 * JD-Core Version:    0.6.2
 */