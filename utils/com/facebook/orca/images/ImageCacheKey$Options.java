package com.facebook.orca.images;

import com.google.common.base.Preconditions;

public class ImageCacheKey$Options
{
  public static final ImageCacheKey.Options.DownscalingMethod a = ImageCacheKey.Options.DownscalingMethod.MemoryUsagePowerOfTwo;
  public final int b;
  public final int c;
  public final ImageCacheKey.Options.DownscalingMethod d;

  public ImageCacheKey$Options(ImageCacheKey.OptionsBuilder paramOptionsBuilder)
  {
    Preconditions.checkNotNull(paramOptionsBuilder.c());
    this.b = paramOptionsBuilder.a();
    this.c = paramOptionsBuilder.b();
    this.d = paramOptionsBuilder.c();
  }

  public static ImageCacheKey.OptionsBuilder newBuilder()
  {
    return new ImageCacheKey.OptionsBuilder();
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject);
    while (true)
    {
      return bool;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        bool = false;
      }
      else
      {
        Options localOptions = (Options)paramObject;
        if (this.c != localOptions.c)
          bool = false;
        else if (this.b != localOptions.b)
          bool = false;
        else if (this.d != localOptions.d)
          bool = false;
      }
    }
  }

  public int hashCode()
  {
    return 17 * (31 * this.b + this.c) + this.d.ordinal();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageCacheKey.Options
 * JD-Core Version:    0.6.2
 */