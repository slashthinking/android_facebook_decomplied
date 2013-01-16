package com.facebook.camera.facetracking;

import android.graphics.Rect;
import android.hardware.Camera.Face;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.util.Log;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class FaceTracker$TrackingHandler extends Handler
{
  FaceTracker$TrackingHandler(FaceTracker paramFaceTracker, Looper paramLooper)
  {
    super(paramLooper);
  }

  private void a()
  {
    FaceTracker.a(this.a, true);
    if (FaceTracker.c(this.a).length == 0)
    {
      a(true);
      FaceTracker.a(this.a, false);
    }
    while (true)
    {
      return;
      ArrayList localArrayList = new ArrayList(FaceTracker.c(this.a).length);
      for (Camera.Face localFace : FaceTracker.c(this.a))
      {
        if (localFace.score < 40)
          continue;
        localArrayList.add(localFace);
      }
      if (FaceTracker.a(this.a).size() == 0)
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          Rect localRect = ((Camera.Face)localIterator.next()).rect;
          FaceTracker.a(this.a).add(new TrackedFace(localRect));
        }
        a(false);
        FaceTracker.a(this.a, false);
        continue;
      }
      a(localArrayList);
      b();
      a(false);
      FaceTracker.a(this.a, false);
    }
  }

  private void a(ArrayList<Camera.Face> paramArrayList)
  {
    ArrayList localArrayList = (ArrayList)FaceTracker.a(this.a).clone();
    HashMap localHashMap1 = Maps.a();
    int i = 0;
    Rect localRect4;
    double d1;
    Object localObject1;
    label78: Object localObject2;
    double d3;
    if (i < paramArrayList.size())
    {
      localRect4 = ((Camera.Face)paramArrayList.get(i)).rect;
      float f1 = localRect4.exactCenterX();
      float f2 = localRect4.exactCenterY();
      d1 = 1.7976931348623157E+308D;
      localObject1 = null;
      Iterator localIterator5 = FaceTracker.a(this.a).iterator();
      if (localIterator5.hasNext())
      {
        localObject2 = (TrackedFace)localIterator5.next();
        Rect localRect5 = ((TrackedFace)localObject2).f;
        double d2 = FaceTracker.a(f1, f2, localRect5.exactCenterX(), localRect5.exactCenterY());
        if (d2 >= d1)
          break label528;
        d3 = d2;
      }
    }
    while (true)
    {
      d1 = d3;
      localObject1 = localObject2;
      break label78;
      localHashMap1.put(localRect4, localObject1);
      localArrayList.remove(localObject1);
      i++;
      break;
      if (localArrayList.size() > 0)
      {
        Iterator localIterator4 = localArrayList.iterator();
        while (localIterator4.hasNext())
        {
          TrackedFace localTrackedFace3 = (TrackedFace)localIterator4.next();
          FaceTracker.a(this.a).remove(localTrackedFace3);
        }
      }
      if (FaceTracker.a(this.a).size() < paramArrayList.size())
      {
        HashMap localHashMap2 = Maps.a();
        Iterator localIterator2 = localHashMap1.keySet().iterator();
        while (localIterator2.hasNext())
        {
          Rect localRect3 = (Rect)localIterator2.next();
          TrackedFace localTrackedFace2 = (TrackedFace)localHashMap1.get(localRect3);
          localHashMap2.put(Double.valueOf(FaceTracker.a(localRect3.exactCenterX(), localRect3.exactCenterY(), localTrackedFace2.d, localTrackedFace2.e)), localRect3);
        }
        Set localSet = localHashMap2.keySet();
        Double[] arrayOfDouble = new Double[localSet.size()];
        Iterator localIterator3 = localSet.iterator();
        for (int j = 0; localIterator3.hasNext(); j++)
          arrayOfDouble[j] = ((Double)localIterator3.next());
        Arrays.sort(arrayOfDouble);
        int k = paramArrayList.size() - FaceTracker.a(this.a).size();
        for (int m = 0; m < k; m++)
        {
          Rect localRect2 = (Rect)localHashMap2.get(arrayOfDouble[(-1 + arrayOfDouble.length - m)]);
          TrackedFace localTrackedFace1 = new TrackedFace(localRect2);
          FaceTracker.a(this.a).add(localTrackedFace1);
          localHashMap1.remove(localRect2);
        }
      }
      Iterator localIterator1 = localHashMap1.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Rect localRect1 = (Rect)localIterator1.next();
        ((TrackedFace)localHashMap1.get(localRect1)).a(localRect1);
      }
      return;
      label528: localObject2 = localObject1;
      d3 = d1;
    }
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
      FaceTracker.b(this.a).sendEmptyMessage(10);
    while (true)
    {
      return;
      FaceTracker.b(this.a).sendEmptyMessage(11);
    }
  }

  private void b()
  {
    Iterator localIterator = FaceTracker.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      TrackedFace localTrackedFace = (TrackedFace)localIterator.next();
      if (localTrackedFace.h)
      {
        if (FaceTracker.a(localTrackedFace.d, localTrackedFace.e, localTrackedFace.i, localTrackedFace.j) > 120.0D)
        {
          localTrackedFace.h = false;
          localTrackedFace.k = 0;
          continue;
        }
        localTrackedFace.k = (1 + localTrackedFace.k);
        continue;
      }
      if (localTrackedFace.g >= 60.0D)
        continue;
      localTrackedFace.h = true;
      localTrackedFace.i = localTrackedFace.d;
      localTrackedFace.j = localTrackedFace.e;
    }
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      Log.a(FaceTracker.a, "Unknown TrackingHandler message: " + paramMessage);
    case 1:
    }
    while (true)
    {
      return;
      a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.facetracking.FaceTracker.TrackingHandler
 * JD-Core Version:    0.6.0
 */