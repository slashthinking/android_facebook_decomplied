package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class VelocityTrackerCompat
{
  static final VelocityTrackerCompat.VelocityTrackerVersionImpl a;

  static
  {
    if (Build.VERSION.SDK_INT >= 11)
      a = new VelocityTrackerCompat.HoneycombVelocityTrackerVersionImpl();
    while (true)
    {
      return;
      a = new VelocityTrackerCompat.BaseVelocityTrackerVersionImpl();
    }
  }

  public static float a(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return a.a(paramVelocityTracker, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.view.VelocityTrackerCompat
 * JD-Core Version:    0.6.0
 */