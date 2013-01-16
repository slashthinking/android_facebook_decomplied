package com.facebook.orca.common.async;

public class CancellableRunnable
  implements Runnable
{
  private volatile Runnable a;

  public CancellableRunnable(Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }

  public void a()
  {
    this.a = null;
  }

  public void run()
  {
    Runnable localRunnable = this.a;
    if (localRunnable != null)
      localRunnable.run();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.async.CancellableRunnable
 * JD-Core Version:    0.6.0
 */