package com.facebook.katana.features;

public class Gatekeeper$Settings
{
  public final Gatekeeper.CachePolicy a;
  public final Gatekeeper.CachePolicy b;

  public Gatekeeper$Settings(Gatekeeper.CachePolicy paramCachePolicy1, Gatekeeper.CachePolicy paramCachePolicy2)
  {
    if (paramCachePolicy1 == Gatekeeper.CachePolicy.CACHE_NONE)
      throw new RuntimeException("memoryCachePolicy of CACHE_NONE will suppress all results");
    this.a = paramCachePolicy1;
    this.b = paramCachePolicy2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.Gatekeeper.Settings
 * JD-Core Version:    0.6.0
 */