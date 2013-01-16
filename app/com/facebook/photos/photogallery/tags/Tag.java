package com.facebook.photos.photogallery.tags;

import android.graphics.PointF;

public class Tag
{
  private PointF a;
  private String b;
  private long c;

  public Tag(PointF paramPointF, String paramString, long paramLong)
  {
    this.a = paramPointF;
    this.b = paramString;
    this.c = paramLong;
  }

  public PointF a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public long c()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.photos.photogallery.tags.Tag
 * JD-Core Version:    0.6.0
 */