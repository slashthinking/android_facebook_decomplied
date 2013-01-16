package com.karmascience.gifts;

import android.os.Handler;

public class ThreadingService
{
  private final Handler a = new Handler();
  private Handler b;

  public ThreadingService()
  {
    new Thread(new ThreadingService.1(this)).start();
  }

  public void a(Runnable paramRunnable, long paramLong)
  {
    monitorenter;
    try
    {
      this.a.postDelayed(paramRunnable, paramLong);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean a(Runnable paramRunnable)
  {
    monitorenter;
    try
    {
      boolean bool = this.a.post(paramRunnable);
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void b(Runnable paramRunnable)
  {
    monitorenter;
    try
    {
      this.a.removeCallbacks(paramRunnable);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.ThreadingService
 * JD-Core Version:    0.6.0
 */