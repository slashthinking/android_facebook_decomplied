package com.facebook.android.os;

class DeferredHandler$IdleRunnable
  implements Runnable
{
  Runnable a;

  DeferredHandler$IdleRunnable(DeferredHandler paramDeferredHandler, Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }

  public void run()
  {
    this.a.run();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.android.os.DeferredHandler.IdleRunnable
 * JD-Core Version:    0.6.0
 */