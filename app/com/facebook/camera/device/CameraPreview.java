package com.facebook.camera.device;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.facebook.camera.facetracking.FaceDetectionManager;
import com.facebook.camera.support.CameraFlowLogger;
import com.facebook.common.util.Log;

public class CameraPreview extends SurfaceView
  implements Camera.PreviewCallback, SurfaceHolder.Callback
{
  private static final Class<?> a = CameraPreview.class;
  private static final String b = a.getSimpleName();
  private SurfaceHolder c;
  private Camera d;
  private CameraPreview.CreateSurfaceListener e;
  private CameraPreview.PreviewListener f;
  private FocusManager g;
  private FaceDetectionManager h;
  private final CameraFlowLogger i;

  public CameraPreview(Context paramContext, Camera paramCamera, FocusManager paramFocusManager, FaceDetectionManager paramFaceDetectionManager, CameraFlowLogger paramCameraFlowLogger)
  {
    super(paramContext);
    this.d = paramCamera;
    this.g = paramFocusManager;
    this.i = paramCameraFlowLogger;
    this.c = getHolder();
    this.c.addCallback(this);
    this.c.setType(3);
    this.h = paramFaceDetectionManager;
  }

  private boolean a(SurfaceHolder paramSurfaceHolder)
  {
    Surface localSurface = paramSurfaceHolder.getSurface();
    int j = 0;
    if (localSurface == null);
    while (true)
    {
      return j;
      this.c = paramSurfaceHolder;
      if (this.d == null)
      {
        Log.e(a, "camera was null when the surface was created");
        j = 0;
        continue;
      }
      if (this.h != null)
        this.h.c();
      this.d.stopPreview();
      this.g.d();
      try
      {
        this.g.h();
        this.d.setPreviewDisplay(this.c);
      }
      catch (Exception localException1)
      {
        try
        {
          while (true)
          {
            this.d.startPreview();
            this.g.c();
            if (this.h != null)
              this.h.b();
            j = 1;
            break;
            localException1 = localException1;
            this.i.a("CameraPreview/setPreviewDisplay failed", localException1);
          }
        }
        catch (Exception localException2)
        {
          this.i.a("CameraPreview/startPreview failed", localException2);
          j = 0;
        }
      }
    }
  }

  public void a()
  {
    this.d.setPreviewCallback(null);
    this.d = null;
    this.e = null;
    this.f = null;
  }

  public Surface getSurface()
  {
    return this.c.getSurface();
  }

  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.f != null)
      this.f.a(paramArrayOfByte, paramCamera.getParameters());
  }

  public void setPreviewListener(CameraPreview.PreviewListener paramPreviewListener)
  {
    this.f = paramPreviewListener;
    this.d.setPreviewCallback(this);
  }

  public void setSurfaceListener(CameraPreview.CreateSurfaceListener paramCreateSurfaceListener)
  {
    this.e = paramCreateSurfaceListener;
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.e != null)
      this.e.a();
    boolean bool = a(paramSurfaceHolder);
    if (this.e != null)
      this.e.a(bool);
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.CameraPreview
 * JD-Core Version:    0.6.0
 */