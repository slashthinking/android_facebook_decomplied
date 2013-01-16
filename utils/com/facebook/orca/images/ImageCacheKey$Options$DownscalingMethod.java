package com.facebook.orca.images;

public enum ImageCacheKey$Options$DownscalingMethod
{
  static
  {
    MaxScaleNonPowerOfTwo = new DownscalingMethod("MaxScaleNonPowerOfTwo", 1);
    MinScaleNonPowerOfTwo = new DownscalingMethod("MinScaleNonPowerOfTwo", 2);
    DownscalingMethod[] arrayOfDownscalingMethod = new DownscalingMethod[3];
    arrayOfDownscalingMethod[0] = MemoryUsagePowerOfTwo;
    arrayOfDownscalingMethod[1] = MaxScaleNonPowerOfTwo;
    arrayOfDownscalingMethod[2] = MinScaleNonPowerOfTwo;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.ImageCacheKey.Options.DownscalingMethod
 * JD-Core Version:    0.6.2
 */