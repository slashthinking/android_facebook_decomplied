package com.facebook.camera.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.camera.device.CameraHolder;
import com.facebook.camera.utils.Storage;

class CameraActivity$2
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (CameraActivity.a(this.a) != 1);
    while (true)
    {
      return false;
      if ((!CameraActivity.b(this.a).d()) || (!CameraActivity.c(this.a).a()) || (paramMotionEvent.getAction() != 0))
        continue;
      CameraActivity.b(this.a).r();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.activity.CameraActivity.2
 * JD-Core Version:    0.6.0
 */