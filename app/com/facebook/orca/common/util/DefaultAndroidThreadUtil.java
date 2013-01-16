package com.facebook.orca.common.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.common.util.HandlerExecutorService;
import com.facebook.orca.common.async.AsyncTaskRunner;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class DefaultAndroidThreadUtil
  implements AndroidThreadUtil
{
  private final ListeningExecutorService a;
  private volatile boolean b;

  public DefaultAndroidThreadUtil(ExecutorService paramExecutorService)
  {
    this.a = MoreExecutors.a(paramExecutorService);
  }

  public <T> ListenableFuture<T> a(Callable<T> paramCallable)
  {
    Preconditions.checkNotNull(paramCallable);
    return this.a.a(paramCallable);
  }

  public void a()
  {
    if (!this.b)
      Preconditions.checkState(c());
  }

  public <T> void a(ListenableFuture<T> paramListenableFuture, FutureCallback<? super T> paramFutureCallback)
  {
    Preconditions.checkNotNull(paramListenableFuture);
    Preconditions.checkNotNull(paramFutureCallback);
    Preconditions.checkNotNull(Looper.myLooper(), "Must be called on a handler thread");
    Futures.a(paramListenableFuture, paramFutureCallback, new HandlerExecutorService(new Handler()));
  }

  public void a(Runnable paramRunnable)
  {
    if (c())
      new AsyncTaskRunner(paramRunnable).a();
    while (true)
    {
      return;
      paramRunnable.run();
    }
  }

  public void a(Runnable paramRunnable, long paramLong)
  {
    new Handler(Looper.getMainLooper()).postDelayed(paramRunnable, paramLong);
  }

  public void a(String paramString, Runnable paramRunnable)
  {
    HandlerThread localHandlerThread = new HandlerThread(paramString);
    localHandlerThread.start();
    new Handler(localHandlerThread.getLooper()).post(new DefaultAndroidThreadUtil.1(this, paramRunnable, localHandlerThread));
  }

  public void b()
  {
    if (!this.b)
      if (c())
        break label21;
    label21: for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      return;
    }
  }

  public void b(Runnable paramRunnable)
  {
    if (c())
      paramRunnable.run();
    while (true)
    {
      return;
      new Handler(Looper.getMainLooper()).post(paramRunnable);
    }
  }

  public void b(Runnable paramRunnable, long paramLong)
  {
    new Handler().postDelayed(paramRunnable, paramLong);
  }

  public void c(Runnable paramRunnable)
  {
    new AsyncTaskRunner(paramRunnable).a();
  }

  public boolean c()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread());
    for (int i = 1; ; i = 0)
      return i;
  }

  public void d(Runnable paramRunnable)
  {
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }

  public void e(Runnable paramRunnable)
  {
    new Handler().post(paramRunnable);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.DefaultAndroidThreadUtil
 * JD-Core Version:    0.6.0
 */