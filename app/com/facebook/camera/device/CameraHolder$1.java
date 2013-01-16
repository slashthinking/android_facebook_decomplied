package com.facebook.camera.device;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import com.facebook.camera.support.CameraFlowLogger;

class CameraHolder$1
  implements Camera.PictureCallback
{
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    CameraHolder.a(this.a).a(true);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      CameraHolder.b(this.a);
      CameraHolder.c(this.a);
    }
    while (true)
    {
      return;
      CameraHolder.d(this.a).a(paramArrayOfByte.length);
      int i = CameraHolder.e(this.a);
      this.a.a.b(paramArrayOfByte, i);
      new CameraHolder.HandleMediaTask(this.a, paramArrayOfByte).execute(new Void[0]);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.CameraHolder.1
 * JD-Core Version:    0.6.0
 */