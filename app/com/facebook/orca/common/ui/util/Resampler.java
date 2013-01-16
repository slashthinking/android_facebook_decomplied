package com.facebook.orca.common.ui.util;

import com.facebook.orca.common.util.RingBuffer;

public class Resampler
{
  private static final float[] a = { 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F };
  private boolean b = false;
  private RingBuffer<Resampler.SamplePoint> c;

  public Resampler()
  {
    this(false);
  }

  public Resampler(boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.c = new RingBuffer(8);
  }

  private void b(long paramLong, Resampler.SamplePoint paramSamplePoint)
  {
    int i = this.c.c();
    if (i == 0)
      throw new IndexOutOfBoundsException("Can't estimate with no samples");
    int j = i - 1;
    float f1 = 0.0F;
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f4 = 0.0F;
    float f5 = 0.0F;
    float f6 = 0.0F;
    float f7 = 0.0F;
    float f8 = 0.0F;
    float f9 = 0.0F;
    float f10 = 0.0F;
    float f11 = 0.0F;
    float f12 = 0.0F;
    int k = 0;
    int m = j;
    Resampler.SamplePoint localSamplePoint2;
    float f15;
    float f16;
    if (m >= 0)
    {
      localSamplePoint2 = (Resampler.SamplePoint)this.c.a(m);
      if ((localSamplePoint2.c >= 0L) && (paramLong - localSamplePoint2.c <= 100L));
    }
    else
    {
      float f13 = f1 * (f4 * f6 - f5 * f5) - f2 * (f6 * f2 - f3 * f5) + f3 * (f2 * f5 - f4 * f3);
      if ((!this.b) || (Math.abs(f13) <= 1.0E-04F) || (k < 3))
        break label494;
      f15 = 1.0F / f13 * (f7 * (f2 * f5 - f4 * f3) + f8 * (f3 * f2 - f1 * f5) + f9 * (f1 * f4 - f2 * f2));
      f16 = 1.0F / f13 * (f10 * (f2 * f5 - f4 * f3) + f11 * (f3 * f2 - f1 * f5) + f12 * (f1 * f4 - f2 * f2));
    }
    while (true)
    {
      paramSamplePoint.a(f15, f16, paramLong);
      return;
      float f17 = (float)(localSamplePoint2.c - paramLong);
      float f18 = f17 * f17;
      float f19 = a[m];
      float f20 = f19 * f19;
      f1 += f18 * (f20 * f18);
      f2 += f17 * (f20 * f18);
      f3 += f20 * f18;
      f4 += f20 * f18;
      f5 += f20 * f17;
      f6 += 1.0F * f20;
      f7 += f20 * f18 * localSamplePoint2.a;
      f8 += f20 * f17 * localSamplePoint2.a;
      f9 += f20 * localSamplePoint2.a;
      f10 += f18 * f20 * localSamplePoint2.b;
      f11 += f17 * f20 * localSamplePoint2.b;
      f12 += f20 * localSamplePoint2.b;
      k++;
      m--;
      break;
      label494: float f14 = f4 * f6 - f5 * f5;
      if ((Math.abs(f14) > 1.0E-04F) && (k >= 2))
      {
        f15 = 1.0F / f14 * (f8 * -f5 + f4 * f9);
        f16 = 1.0F / f14 * (f11 * -f5 + f12 * f4);
        continue;
      }
      Resampler.SamplePoint localSamplePoint1 = (Resampler.SamplePoint)this.c.a(i - 1);
      f15 = localSamplePoint1.a;
      f16 = localSamplePoint1.b;
    }
  }

  public void a()
  {
    int i = this.c.c();
    for (int j = 0; j < i; j++)
      ((Resampler.SamplePoint)this.c.a(j)).a();
  }

  public void a(float paramFloat1, float paramFloat2, long paramLong)
  {
    Resampler.SamplePoint localSamplePoint;
    if (this.c.b())
    {
      localSamplePoint = (Resampler.SamplePoint)this.c.a();
      localSamplePoint.a(paramFloat1, paramFloat2, paramLong);
    }
    while (true)
    {
      this.c.a(localSamplePoint);
      return;
      localSamplePoint = new Resampler.SamplePoint(paramFloat1, paramFloat2, paramLong);
    }
  }

  public final void a(long paramLong, Resampler.SamplePoint paramSamplePoint)
  {
    b(paramLong, paramSamplePoint);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.util.Resampler
 * JD-Core Version:    0.6.0
 */