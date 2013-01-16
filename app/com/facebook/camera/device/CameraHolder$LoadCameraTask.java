package com.facebook.camera.device;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Handler;
import com.facebook.camera.facetracking.FaceDetectionManager;
import com.facebook.camera.support.CameraFlowLogger;
import com.facebook.common.util.Log;

public class CameraHolder$LoadCameraTask extends AsyncTask<Void, Void, Camera>
{
  private int b = 1000;
  private int c;

  public CameraHolder$LoadCameraTask(CameraHolder paramCameraHolder)
  {
    this.c = 0;
  }

  public CameraHolder$LoadCameraTask(CameraHolder paramCameraHolder, int paramInt)
  {
    this.c = paramInt;
  }

  protected Camera a(Void[] paramArrayOfVoid)
  {
    return CameraHolder.a(this.a, CameraHolder.h(this.a));
  }

  protected void a(Camera paramCamera)
  {
    if (paramCamera != null)
      paramCamera.release();
  }

  protected void b(Camera paramCamera)
  {
    if ((paramCamera == null) || (!CameraHolder.a(paramCamera)))
    {
      if (paramCamera != null)
        paramCamera.release();
      if (this.c > 3)
        this.a.a.c(false);
      while (true)
      {
        return;
        Log.e(CameraHolder.w(), "failed at: " + this.c);
        CameraHolder.a(this.a, new LoadCameraTask(this.a, 1 + this.c));
        new Handler().postDelayed(new CameraHolder.LoadCameraTask.1(this), this.b);
      }
    }
    CameraHolder.a(this.a, paramCamera);
    this.a.n();
    CameraHolder.j(this.a);
    CameraHolder.k(this.a);
    if (CameraHolder.l(this.a) != null)
    {
      if (CameraHolder.l(this.a).a())
        break label206;
      Log.e(CameraHolder.w(), "Face detection is not active");
    }
    while (true)
    {
      CameraHolder.a(this.a, null);
      CameraHolder.d(this.a).e();
      break;
      label206: CameraHolder.l(this.a).a(CameraHolder.m(this.a));
    }
  }

  protected void onPreExecute()
  {
    this.a.a.m();
    Log.d(CameraHolder.w(), "Starting to load camera");
    CameraHolder.d(this.a).d();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.CameraHolder.LoadCameraTask
 * JD-Core Version:    0.6.0
 */