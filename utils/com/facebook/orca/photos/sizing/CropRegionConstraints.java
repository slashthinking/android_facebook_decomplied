package com.facebook.orca.photos.sizing;

import com.google.common.base.Joiner;

public class CropRegionConstraints
{
  private final float a;
  private final float b;
  private final float c;
  private final CropRegionGraphicOp.CropType d;

  CropRegionConstraints(CropRegionConstraintsBuilder paramCropRegionConstraintsBuilder)
  {
    this.a = paramCropRegionConstraintsBuilder.a();
    this.b = paramCropRegionConstraintsBuilder.b();
    this.c = paramCropRegionConstraintsBuilder.c();
    this.d = paramCropRegionConstraintsBuilder.d();
  }

  public float a()
  {
    return this.a;
  }

  public float b()
  {
    return this.b;
  }

  public float c()
  {
    return this.c;
  }

  public CropRegionGraphicOp.CropType d()
  {
    return this.d;
  }

  public String e()
  {
    Joiner localJoiner = Joiner.on(":");
    Float localFloat1 = Float.valueOf(this.a);
    Float localFloat2 = Float.valueOf(this.b);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Float.valueOf(this.c);
    if (this.d != null);
    for (String str = this.d.name(); ; str = "")
    {
      arrayOfObject[1] = str;
      return localJoiner.join(localFloat1, localFloat2, arrayOfObject);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.sizing.CropRegionConstraints
 * JD-Core Version:    0.6.2
 */