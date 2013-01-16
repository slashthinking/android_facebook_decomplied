package com.facebook.orca.photos.sizing;

public class GraphicOpConstraintsBuilder
{
  private int a = 60;
  private int b = 40;
  private int c = 120;
  private int d = 80;
  private CropRegionConstraints e;
  private CropRegionRectConstraints f;
  private boolean g;
  private boolean h;

  public int a()
  {
    return this.a;
  }

  public GraphicOpConstraintsBuilder a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }

  public GraphicOpConstraintsBuilder a(CropRegionConstraints paramCropRegionConstraints)
  {
    this.e = paramCropRegionConstraints;
    return this;
  }

  public GraphicOpConstraintsBuilder a(CropRegionRectConstraints paramCropRegionRectConstraints)
  {
    this.f = paramCropRegionRectConstraints;
    return this;
  }

  public GraphicOpConstraintsBuilder a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }

  public int b()
  {
    return this.b;
  }

  public GraphicOpConstraintsBuilder b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }

  public int c()
  {
    return this.c;
  }

  public GraphicOpConstraintsBuilder c(int paramInt)
  {
    this.c = paramInt;
    return this;
  }

  public int d()
  {
    return this.d;
  }

  public GraphicOpConstraintsBuilder d(int paramInt)
  {
    this.d = paramInt;
    return this;
  }

  public CropRegionConstraints e()
  {
    return this.e;
  }

  public CropRegionRectConstraints f()
  {
    return this.f;
  }

  public boolean g()
  {
    return this.g;
  }

  public boolean h()
  {
    return this.h;
  }

  public GraphicOpConstraints i()
  {
    return new GraphicOpConstraints(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.sizing.GraphicOpConstraintsBuilder
 * JD-Core Version:    0.6.2
 */