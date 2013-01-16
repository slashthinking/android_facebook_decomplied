package com.facebook.camera.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

class CameraActivity$5
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a.getIntent().getBooleanExtra(CameraActivity.Extras.a, false))
    {
      this.a.b(false);
      CameraActivity.e(this.a).enable();
      CameraActivity.g(this.a).setVisibility(0);
      CameraActivity.a(this.a, CameraActivity.g(this.a), 2130968586);
    }
    while (true)
    {
      return;
      this.a.finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.activity.CameraActivity.5
 * JD-Core Version:    0.6.0
 */