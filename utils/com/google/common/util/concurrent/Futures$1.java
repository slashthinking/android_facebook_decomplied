package com.google.common.util.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class Futures$1
  implements UninterruptibleFuture<V>
{
  public boolean cancel(boolean paramBoolean)
  {
    return this.a.cancel(paramBoolean);
  }

  public V get()
  {
    return Uninterruptibles.a(this.a);
  }

  public V get(long paramLong, TimeUnit paramTimeUnit)
  {
    return Uninterruptibles.a(this.a, paramLong, paramTimeUnit);
  }

  public boolean isCancelled()
  {
    return this.a.isCancelled();
  }

  public boolean isDone()
  {
    return this.a.isDone();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures.1
 * JD-Core Version:    0.6.2
 */