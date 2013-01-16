package com.facebook.orca.images;

public class ImageCacheKey$OptionsBuilder
{
  private int a = -1;
  private int b = -1;
  private ImageCacheKey.Options.DownscalingMethod c = ImageCacheKey.Options.a;

  public int a()
  {
    return this.a;
  }

  public OptionsBuilder a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    return this;
  }

  public OptionsBuilder a(ImageCacheKey.Options.DownscalingMethod paramDownscalingMethod)
  {
    this.c = paramDownscalingMethod;
    return this;
  }

  public OptionsBuilder a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (OptionsBuilder localOptionsBuilder = a(-2, -2); ; localOptionsBuilder = a(-1, -1))
      return localOptionsBuilder;
  }

  public int b()
  {
    return this.b;
  }

  public ImageCacheKey.Options.DownscalingMethod c()
  {
    return this.c;
  }

  public ImageCacheKey.Options d()
  {
    return new ImageCacheKey.Options(this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageCacheKey.OptionsBuilder
 * JD-Core Version:    0.6.2
 */