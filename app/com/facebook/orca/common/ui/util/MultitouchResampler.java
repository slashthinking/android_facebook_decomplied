package com.facebook.orca.common.ui.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;

@TargetApi(9)
public class MultitouchResampler
{
  private Resampler[] a = new Resampler[6];
  private int[] b = new int[6];
  private MotionEvent.PointerCoords[] c = new MotionEvent.PointerCoords[6];
  private Resampler.SamplePoint d;

  public MultitouchResampler()
  {
    this(false);
  }

  public MultitouchResampler(boolean paramBoolean)
  {
    for (int i = 0; i <= 5; i++)
    {
      this.a[i] = new Resampler(paramBoolean);
      this.c[i] = new MotionEvent.PointerCoords();
    }
    this.d = new Resampler.SamplePoint(0.0F, 0.0F, 0L);
  }

  private final Resampler a(int paramInt)
  {
    if (paramInt < 5);
    for (Resampler localResampler = this.a[paramInt]; ; localResampler = this.a[5])
      return localResampler;
  }

  public final MotionEvent a(MotionEvent paramMotionEvent, int paramInt, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      int i = Math.min(paramMotionEvent.getPointerCount(), 5);
      for (int j = 0; j < i; j++)
      {
        int k = paramMotionEvent.getPointerId(j);
        this.b[j] = k;
        a(k).a(paramLong, this.d);
        this.c[j].x = this.d.b();
        this.c[j].y = this.d.c();
      }
      return MotionEvent.obtain(paramMotionEvent.getDownTime(), paramLong, paramInt, i, this.b, this.c, paramMotionEvent.getMetaState(), paramMotionEvent.getXPrecision(), paramMotionEvent.getYPrecision(), paramMotionEvent.getDeviceId(), paramMotionEvent.getEdgeFlags(), paramMotionEvent.getSource(), paramMotionEvent.getFlags());
    }
    throw new ArrayIndexOutOfBoundsException("Cannot synthesize motion events on pre-GB devices");
  }

  public void a(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int k;
    int m;
    switch (0xFF & paramMotionEvent.getAction())
    {
    default:
      k = paramMotionEvent.getPointerCount();
      m = paramMotionEvent.getHistorySize();
    case 0:
    case 5:
    }
    for (int n = 0; n < k; n++)
    {
      Resampler localResampler2 = a(paramMotionEvent.getPointerId(n));
      int i1 = 0;
      while (i1 < m)
      {
        localResampler2.a(paramMotionEvent.getHistoricalX(n, i1), paramMotionEvent.getHistoricalY(n, i1), paramMotionEvent.getHistoricalEventTime(i1));
        i1++;
        continue;
        int j = paramMotionEvent.getPointerCount();
        while (i < j)
        {
          float f1 = paramMotionEvent.getX(i);
          float f2 = paramMotionEvent.getY(i);
          long l = paramMotionEvent.getEventTime();
          Resampler localResampler1 = a(paramMotionEvent.getPointerId(i));
          if (((paramMotionEvent.getActionMasked() == 5) && (paramMotionEvent.getActionIndex() == i)) || (paramMotionEvent.getActionMasked() == 0))
            localResampler1.a();
          localResampler1.a(f1, f2, l);
          i++;
        }
      }
      localResampler2.a(paramMotionEvent.getX(n), paramMotionEvent.getY(n), paramMotionEvent.getEventTime());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.util.MultitouchResampler
 * JD-Core Version:    0.6.0
 */