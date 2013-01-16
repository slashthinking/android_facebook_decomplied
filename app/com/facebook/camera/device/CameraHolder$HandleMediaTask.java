package com.facebook.camera.device;

import android.net.Uri;
import android.os.AsyncTask;
import com.facebook.camera.utils.Storage;

class CameraHolder$HandleMediaTask extends AsyncTask<Void, Void, Void>
{
  byte[] a;

  public CameraHolder$HandleMediaTask(CameraHolder paramCameraHolder, byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }

  protected Void a(Void[] paramArrayOfVoid)
  {
    Uri localUri = CameraHolder.n(this.b).a(this.a);
    this.b.a.b(localUri);
    return null;
  }

  protected void onPreExecute()
  {
    this.b.a.n();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.CameraHolder.HandleMediaTask
 * JD-Core Version:    0.6.0
 */