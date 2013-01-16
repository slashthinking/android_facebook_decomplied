package com.facebook.camera.facetracking;

import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import com.facebook.camera.device.CameraHolder;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.Log;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FaceDetectionManager
  implements Camera.FaceDetectionListener
{
  private static final Class<?> a = FaceDetectionManager.class;
  private static final String b = a.getSimpleName();
  private Camera c;
  private int d = -1;
  private boolean e = true;
  private boolean f = false;
  private List<FaceDetectionManager.FaceDetectionListener> g;

  public FaceDetectionManager(Camera paramCamera)
  {
    this.c = paramCamera;
    this.g = Lists.a();
  }

  private void a(String paramString)
  {
    Log.a(a, paramString);
    ErrorReporting.a(b, paramString);
    this.f = false;
  }

  private void a(Camera.Face[] paramArrayOfFace, Camera paramCamera)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
      ((FaceDetectionManager.FaceDetectionListener)localIterator.next()).a(paramArrayOfFace, paramCamera);
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public void a(FaceDetectionManager.FaceDetectionListener paramFaceDetectionListener)
  {
    this.g.add(paramFaceDetectionListener);
  }

  public boolean a()
  {
    int i = 0;
    if ((!CameraHolder.m()) || (this.c.getParameters().getMaxNumDetectedFaces() <= 0))
      this.e = false;
    while (true)
    {
      return i;
      if (this.e)
      {
        this.c.setFaceDetectionListener(this);
        i = 1;
        continue;
      }
      this.e = false;
      i = 0;
    }
  }

  public void b(FaceDetectionManager.FaceDetectionListener paramFaceDetectionListener)
  {
    ArrayList localArrayList = Lists.a();
    for (int i = 0; i < this.g.size(); i++)
    {
      if (!((FaceDetectionManager.FaceDetectionListener)this.g.get(i)).equals(paramFaceDetectionListener))
        continue;
      localArrayList.add(Integer.valueOf(i));
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.g.remove(localInteger);
    }
  }

  public boolean b()
  {
    int i = 1;
    if ((this.c == null) || (!this.e) || (this.f))
      i = 0;
    while (true)
    {
      return i;
      Log.e(a, "Start face detection");
      try
      {
        this.c.startFaceDetection();
        this.f = true;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        a("Could not start FD -- not supported");
        i = 0;
      }
      catch (RuntimeException localRuntimeException)
      {
        a("Could not start FD -- already running or failure");
        i = 0;
      }
    }
  }

  public boolean c()
  {
    Log.e(a, "Stop face detection");
    Camera localCamera = this.c;
    int i = 0;
    if (localCamera != null)
    {
      boolean bool1 = this.e;
      i = 0;
      if (bool1)
      {
        boolean bool2 = this.f;
        i = 0;
        if (bool2)
          break label45;
      }
    }
    while (true)
    {
      return i;
      label45: this.c.setFaceDetectionListener(null);
      try
      {
        this.c.stopFaceDetection();
        this.f = false;
        i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        a("Could not stop face detection");
        i = 0;
      }
    }
  }

  public void onFaceDetection(Camera.Face[] paramArrayOfFace, Camera paramCamera)
  {
    if (this.d == 1)
    {
      int i = paramArrayOfFace.length;
      for (int j = 0; j < i; j++)
      {
        Rect localRect = paramArrayOfFace[j].rect;
        localRect.set(-1 * localRect.left, localRect.top, -1 * localRect.right, localRect.bottom);
      }
    }
    a(paramArrayOfFace, paramCamera);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.facetracking.FaceDetectionManager
 * JD-Core Version:    0.6.0
 */