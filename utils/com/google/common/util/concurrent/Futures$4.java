package com.google.common.util.concurrent;

import com.google.common.base.Function;

final class Futures$4
  implements Function<I, ListenableFuture<O>>
{
  Futures$4(Function paramFunction)
  {
  }

  public ListenableFuture<O> a(I paramI)
  {
    return Futures.a(this.a.apply(paramI));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures.4
 * JD-Core Version:    0.6.2
 */