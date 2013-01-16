package com.facebook.orca.notify;

import android.app.Activity;
import com.facebook.orca.activity.AbstractFbActivityListener;

public class OrcaForegroundActivityListener extends AbstractFbActivityListener
{
  private Activity a;

  public Activity a()
  {
    return this.a;
  }

  public void b(Activity paramActivity)
  {
    this.a = paramActivity;
  }

  public void c(Activity paramActivity)
  {
    this.a = null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.OrcaForegroundActivityListener
 * JD-Core Version:    0.6.0
 */