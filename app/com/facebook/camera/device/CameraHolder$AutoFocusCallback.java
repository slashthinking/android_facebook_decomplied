package com.facebook.camera.device;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

final class CameraHolder$AutoFocusCallback
  implements Camera.AutoFocusCallback
{
  private CameraHolder$AutoFocusCallback(CameraHolder paramCameraHolder)
  {
  }

  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (CameraHolder.o(this.a) != null)
      CameraHolder.o(this.a).a(paramBoolean);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.CameraHolder.AutoFocusCallback
 * JD-Core Version:    0.6.0
 */