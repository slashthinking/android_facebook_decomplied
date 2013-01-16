package com.facebook.orca.common.util;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

public abstract interface AndroidThreadUtil
{
  public abstract <T> ListenableFuture<T> a(Callable<T> paramCallable);

  public abstract void a();

  public abstract <T> void a(ListenableFuture<T> paramListenableFuture, FutureCallback<? super T> paramFutureCallback);

  public abstract void a(Runnable paramRunnable);

  public abstract void a(Runnable paramRunnable, long paramLong);

  public abstract void a(String paramString, Runnable paramRunnable);

  public abstract void b();

  public abstract void b(Runnable paramRunnable);

  public abstract void b(Runnable paramRunnable, long paramLong);

  public abstract void c(Runnable paramRunnable);

  public abstract void d(Runnable paramRunnable);

  public abstract void e(Runnable paramRunnable);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.AndroidThreadUtil
 * JD-Core Version:    0.6.0
 */