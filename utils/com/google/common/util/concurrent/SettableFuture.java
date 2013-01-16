package com.google.common.util.concurrent;

public final class SettableFuture<V> extends AbstractFuture<V>
{
  public static <V> SettableFuture<V> c()
  {
    return new SettableFuture();
  }

  public boolean a_(V paramV)
  {
    return super.a_(paramV);
  }

  public boolean a_(Throwable paramThrowable)
  {
    return super.a_(paramThrowable);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.SettableFuture
 * JD-Core Version:    0.6.2
 */