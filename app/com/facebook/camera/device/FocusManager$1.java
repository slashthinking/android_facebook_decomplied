package com.facebook.camera.device;

import com.facebook.camera.facetracking.TrackedFace;
import java.util.Comparator;

class FocusManager$1
  implements Comparator<TrackedFace>
{
  public int a(TrackedFace paramTrackedFace1, TrackedFace paramTrackedFace2)
  {
    return paramTrackedFace1.a() - paramTrackedFace2.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.camera.device.FocusManager.1
 * JD-Core Version:    0.6.0
 */