package com.facebook.camera.device;

import android.os.AsyncTask.Status;

class CameraHolder$LoadCameraTask$1
  implements Runnable
{
  public void run()
  {
    if ((CameraHolder.i(this.a.a) != null) && (!CameraHolder.i(this.a.a).isCancelled()) && (CameraHolder.i(this.a.a).getStatus() == AsyncTask.Status.PENDING))
      CameraHolder.i(this.a.a).execute(new Void[0]);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.CameraHolder.LoadCameraTask.1
 * JD-Core Version:    0.6.0
 */