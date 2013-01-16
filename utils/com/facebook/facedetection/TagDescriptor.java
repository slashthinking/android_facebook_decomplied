package com.facebook.facedetection;

import android.graphics.PointF;
import android.graphics.RectF;

public class TagDescriptor
{
  private final float a;
  private final PointF b;
  private final RectF c;
  private final int d;
  private final int e;
  private final byte[] f;

  public TagDescriptor(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.a = paramFloat1;
    this.b = new PointF(paramFloat2, paramFloat3);
    this.c = new RectF(paramFloat4, paramFloat5, paramFloat6, paramFloat7);
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramArrayOfByte;
  }

  public RectF a()
  {
    return this.c;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.facedetection.TagDescriptor
 * JD-Core Version:    0.6.2
 */