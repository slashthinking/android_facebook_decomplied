package com.facebook.feed.cache;

import com.facebook.graphql.model.FeedUnit;
import com.google.common.base.Objects;

class FeedUnitCache$CacheEntry
{
  public final FeedUnit a;
  public final String b;
  public final String c;
  public final boolean d;

  public FeedUnitCache$CacheEntry(FeedUnitCache paramFeedUnitCache, FeedUnit paramFeedUnit, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = paramFeedUnit;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBoolean;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (this == paramObject)
      bool = true;
    while (true)
    {
      return bool;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        bool = false;
        continue;
      }
      CacheEntry localCacheEntry = (CacheEntry)paramObject;
      bool = Objects.equal(this.a.getCacheId(), localCacheEntry.a.getCacheId());
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.a.getCacheId();
    return Objects.hashCode(arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedUnitCache.CacheEntry
 * JD-Core Version:    0.6.0
 */