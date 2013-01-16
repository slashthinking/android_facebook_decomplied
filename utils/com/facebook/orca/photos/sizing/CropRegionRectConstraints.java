package com.facebook.orca.photos.sizing;

import android.graphics.RectF;
import com.google.common.base.Joiner;

public class CropRegionRectConstraints
{
  private final RectF a;
  private final float b;

  public CropRegionRectConstraints(RectF paramRectF, float paramFloat)
  {
    this.a = paramRectF;
    this.b = paramFloat;
  }

  public RectF a()
  {
    return this.a;
  }

  public float b()
  {
    return this.b;
  }

  public String c()
  {
    return Joiner.on(":").join(this.a, Float.valueOf(this.b), new Object[0]);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.sizing.CropRegionRectConstraints
 * JD-Core Version:    0.6.2
 */