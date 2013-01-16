package com.facebook.camera.facetracking;

import android.hardware.Camera;
import android.hardware.Camera.Face;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.common.util.Log;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FaceTracker
  implements FaceDetectionManager.FaceDetectionListener
{
  public static final Class<?> a = FaceTracker.class;
  private ArrayList<FaceTracker.TrackedFacesListener> b = new ArrayList();
  private FaceDetectionManager c;
  private volatile ArrayList<TrackedFace> d = Lists.a();
  private Camera.Face[] e;
  private boolean f = false;
  private HandlerThread g = null;
  private Handler h;
  private Handler i;

  public FaceTracker(FaceDetectionManager paramFaceDetectionManager)
  {
    this.g.start();
    Looper localLooper = this.g.getLooper();
    if (localLooper == null)
      Log.a(a, "Error creating FaceTracker -- no looper could be retrieved frombackground thread");
    while (true)
    {
      return;
      this.h = new FaceTracker.TrackingHandler(this, localLooper);
      this.i = new FaceTracker.PublishingHandler(this, null);
      this.c = paramFaceDetectionManager;
      this.c.a(this);
    }
  }

  public static double a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    return Math.sqrt(f1 * f1 + f2 * f2);
  }

  private void a(List<TrackedFace> paramList)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((FaceTracker.TrackedFacesListener)localIterator.next()).a(paramList);
  }

  public void a()
  {
    this.c.b(this);
    this.g.interrupt();
  }

  public void a(FaceTracker.TrackedFacesListener paramTrackedFacesListener)
  {
    if (paramTrackedFacesListener != null)
      this.b.add(paramTrackedFacesListener);
  }

  public void a(Camera.Face[] paramArrayOfFace, Camera paramCamera)
  {
    if (!this.f)
    {
      this.e = paramArrayOfFace;
      this.h.sendEmptyMessage(1);
    }
  }

  public void b(FaceTracker.TrackedFacesListener paramTrackedFacesListener)
  {
    if (paramTrackedFacesListener != null)
      this.b.remove(paramTrackedFacesListener);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.facetracking.FaceTracker
 * JD-Core Version:    0.6.0
 */