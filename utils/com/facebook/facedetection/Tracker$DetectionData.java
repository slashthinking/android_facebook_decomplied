package com.facebook.facedetection;

import android.graphics.PointF;
import android.graphics.RectF;

public class Tracker$DetectionData
{
  private PointF b;
  private float c;
  private float d;

  public Tracker$DetectionData(Tracker paramTracker, TagDescriptor paramTagDescriptor)
  {
    this.b = new PointF(100.0F * ((paramTagDescriptor.a().left + paramTagDescriptor.a().right) / 2.0F), 100.0F * ((paramTagDescriptor.a().top + paramTagDescriptor.a().bottom) / 2.0F));
    this.d = (100.0F * Math.abs(paramTagDescriptor.a().top - paramTagDescriptor.a().bottom));
    this.c = (100.0F * Math.abs(paramTagDescriptor.a().left - paramTagDescriptor.a().right));
  }

  public float a()
  {
    return this.c;
  }

  public float b()
  {
    return this.d;
  }

  public float c()
  {
    return this.b.x;
  }

  public float d()
  {
    return this.b.y;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.facedetection.Tracker.DetectionData
 * JD-Core Version:    0.6.2
 */