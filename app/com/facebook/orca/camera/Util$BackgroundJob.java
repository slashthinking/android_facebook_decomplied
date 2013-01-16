package com.facebook.orca.camera;

import android.app.ProgressDialog;
import android.os.Handler;

class Util$BackgroundJob extends MonitoredActivity.LifeCycleAdapter
  implements Runnable
{
  private final MonitoredActivity a;
  private final ProgressDialog b;
  private final Runnable c;
  private final Handler d;
  private final Runnable e = new Util.BackgroundJob.1(this);

  public Util$BackgroundJob(MonitoredActivity paramMonitoredActivity, Runnable paramRunnable, ProgressDialog paramProgressDialog, Handler paramHandler)
  {
    this.a = paramMonitoredActivity;
    this.b = paramProgressDialog;
    this.c = paramRunnable;
    this.a.a(this);
    this.d = paramHandler;
  }

  public void b(MonitoredActivity paramMonitoredActivity)
  {
    this.e.run();
    this.d.removeCallbacks(this.e);
  }

  public void c(MonitoredActivity paramMonitoredActivity)
  {
    this.b.show();
  }

  public void d(MonitoredActivity paramMonitoredActivity)
  {
    this.b.hide();
  }

  public void run()
  {
    try
    {
      this.c.run();
      return;
    }
    finally
    {
      this.d.post(this.e);
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.Util.BackgroundJob
 * JD-Core Version:    0.6.0
 */