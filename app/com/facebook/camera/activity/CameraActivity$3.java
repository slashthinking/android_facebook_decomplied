package com.facebook.camera.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.camera.device.CameraHolder;
import com.facebook.camera.utils.Storage;

class CameraActivity$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (CameraActivity.a(this.a) != 1);
    while (true)
    {
      return;
      if (CameraActivity.b(this.a).d())
      {
        if (!CameraActivity.c(this.a).a())
        {
          CameraActivity.d(this.a);
          continue;
        }
        CameraActivity.b(this.a).f();
        CameraActivity.e(this.a).disable();
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.activity.CameraActivity.3
 * JD-Core Version:    0.6.0
 */