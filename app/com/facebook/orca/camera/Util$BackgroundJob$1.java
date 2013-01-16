package com.facebook.orca.camera;

import android.app.ProgressDialog;

class Util$BackgroundJob$1
  implements Runnable
{
  public void run()
  {
    Util.BackgroundJob.a(this.a).b(this.a);
    if (Util.BackgroundJob.b(this.a).getWindow() != null)
      Util.BackgroundJob.b(this.a).dismiss();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.Util.BackgroundJob.1
 * JD-Core Version:    0.6.0
 */