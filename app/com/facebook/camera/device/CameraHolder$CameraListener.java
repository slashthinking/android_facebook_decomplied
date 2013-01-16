package com.facebook.camera.device;

import android.net.Uri;
import com.facebook.camera.facetracking.FaceDetectionIndicatorView;
import com.facebook.camera.utils.MediaUtil.Orientation;
import com.facebook.camera.utils.RotateLayout;

public abstract interface CameraHolder$CameraListener
{
  public abstract void a(Uri paramUri);

  public abstract void a(CameraPreview paramCameraPreview);

  public abstract void b(byte[] paramArrayOfByte, int paramInt);

  public abstract boolean b(Uri paramUri);

  public abstract void c(int paramInt);

  public abstract void c(boolean paramBoolean);

  public abstract void d(boolean paramBoolean);

  public abstract void l();

  public abstract void m();

  public abstract void n();

  public abstract RotateLayout o();

  public abstract FaceDetectionIndicatorView p();

  public abstract int q();

  public abstract MediaUtil.Orientation r();

  public abstract MediaUtil.Orientation s();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.CameraHolder.CameraListener
 * JD-Core Version:    0.6.0
 */