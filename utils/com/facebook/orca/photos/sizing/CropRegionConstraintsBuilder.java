package com.facebook.orca.photos.sizing;

public class CropRegionConstraintsBuilder
{
  private float a = 1.0F;
  private float b = 0.15F;
  private float c = 0.15F;
  private CropRegionGraphicOp.CropType d;

  public float a()
  {
    return this.a;
  }

  public CropRegionConstraintsBuilder a(float paramFloat)
  {
    this.a = paramFloat;
    return this;
  }

  public CropRegionConstraintsBuilder a(CropRegionGraphicOp.CropType paramCropType)
  {
    this.d = paramCropType;
    return this;
  }

  public float b()
  {
    return this.b;
  }

  public CropRegionConstraintsBuilder b(float paramFloat)
  {
    this.b = paramFloat;
    return this;
  }

  public float c()
  {
    return this.c;
  }

  public CropRegionConstraintsBuilder c(float paramFloat)
  {
    this.c = paramFloat;
    return this;
  }

  public CropRegionGraphicOp.CropType d()
  {
    return this.d;
  }

  public CropRegionConstraints e()
  {
    return new CropRegionConstraints(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.sizing.CropRegionConstraintsBuilder
 * JD-Core Version:    0.6.2
 */