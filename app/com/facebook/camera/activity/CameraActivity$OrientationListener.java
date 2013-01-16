package com.facebook.camera.activity;

import android.content.Context;
import android.view.OrientationEventListener;
import com.facebook.camera.support.CameraFlowLogger;
import com.facebook.camera.utils.MediaUtil.Orientation;
import com.facebook.camera.utils.RotationMonitor;

class CameraActivity$OrientationListener extends OrientationEventListener
{
  private RotationMonitor b;

  public CameraActivity$OrientationListener(CameraActivity paramCameraActivity, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b = new RotationMonitor(paramContext);
  }

  public void disable()
  {
    super.disable();
    this.b.b();
  }

  public void enable()
  {
    super.enable();
    this.b.a();
  }

  public void onOrientationChanged(int paramInt)
  {
    int i = -45 + (45 + (paramInt + 360)) % 360;
    MediaUtil.Orientation localOrientation;
    if (i <= 45)
    {
      localOrientation = MediaUtil.Orientation.PORTRAIT;
      if (localOrientation != CameraActivity.m(this.a))
      {
        if (CameraActivity.m(this.a) != MediaUtil.Orientation.UNINITIALIZED)
          break label141;
        CameraActivity.a(this.a, localOrientation, localOrientation);
        CameraActivity.a(this.a, localOrientation);
      }
    }
    while (true)
    {
      CameraActivity.n(this.a).b(CameraActivity.m(this.a).toString());
      return;
      if (i <= 135)
      {
        localOrientation = MediaUtil.Orientation.REVERSE_LANDSCAPE;
        i -= 90;
        break;
      }
      if (i <= 225)
      {
        localOrientation = MediaUtil.Orientation.REVERSE_PORTRAIT;
        i -= 180;
        break;
      }
      localOrientation = MediaUtil.Orientation.LANDSCAPE;
      i -= 270;
      break;
      label141: if ((Math.abs(i) > 40) || (this.b.a(45.0F)))
        continue;
      CameraActivity.a(this.a, CameraActivity.m(this.a), localOrientation);
      CameraActivity.a(this.a, localOrientation);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.activity.CameraActivity.OrientationListener
 * JD-Core Version:    0.6.0
 */