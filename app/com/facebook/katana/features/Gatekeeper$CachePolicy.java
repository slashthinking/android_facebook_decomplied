package com.facebook.katana.features;

public enum Gatekeeper$CachePolicy
{
  public final boolean mCacheIfFalse;
  public final boolean mCacheIfTrue;
  public final int mFallbackTtl;

  static
  {
    CACHE_NEGATIVE = new CachePolicy("CACHE_NEGATIVE", 2, false, true);
    CACHE_NONE = new CachePolicy("CACHE_NONE", 3, false, false);
    CACHE_1HOUR = new CachePolicy("CACHE_1HOUR", 4, 3600);
    CACHE_24HOURS = new CachePolicy("CACHE_24HOURS", 5, 86400);
    CACHE_1SECOND = new CachePolicy("CACHE_1SECOND", 6, 1);
    CachePolicy[] arrayOfCachePolicy = new CachePolicy[7];
    arrayOfCachePolicy[0] = CACHE_ALL;
    arrayOfCachePolicy[1] = CACHE_POSITIVE;
    arrayOfCachePolicy[2] = CACHE_NEGATIVE;
    arrayOfCachePolicy[3] = CACHE_NONE;
    arrayOfCachePolicy[4] = CACHE_1HOUR;
    arrayOfCachePolicy[5] = CACHE_24HOURS;
    arrayOfCachePolicy[6] = CACHE_1SECOND;
    $VALUES = arrayOfCachePolicy;
  }

  private Gatekeeper$CachePolicy(int paramInt)
  {
    this.mCacheIfTrue = false;
    this.mCacheIfFalse = false;
    this.mFallbackTtl = paramInt;
  }

  private Gatekeeper$CachePolicy(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mCacheIfTrue = paramBoolean1;
    this.mCacheIfFalse = paramBoolean2;
    this.mFallbackTtl = 0;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.Gatekeeper.CachePolicy
 * JD-Core Version:    0.6.0
 */