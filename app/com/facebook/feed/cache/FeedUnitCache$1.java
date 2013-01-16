package com.facebook.feed.cache;

import android.support.v4.util.LruCache;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.Feedback;
import com.google.common.collect.HashMultimap;
import java.util.Map;

class FeedUnitCache$1 extends LruCache<String, FeedUnitCache.CacheEntry>
{
  protected void a(boolean paramBoolean, String paramString, FeedUnitCache.CacheEntry paramCacheEntry1, FeedUnitCache.CacheEntry paramCacheEntry2)
  {
    if ((paramCacheEntry1.a instanceof FeedStory))
    {
      if (paramCacheEntry1.b != null)
        FeedUnitCache.a(this.a).remove(paramCacheEntry1.b);
      if (((FeedStory)paramCacheEntry1.a).id != null)
        FeedUnitCache.b(this.a).c(((FeedStory)paramCacheEntry1.a).id, ((FeedStory)paramCacheEntry1.a).cacheId);
      if ((((FeedStory)paramCacheEntry1.a).S() != null) && (((FeedStory)paramCacheEntry1.a).S().d() != null))
        FeedUnitCache.c(this.a).c(((FeedStory)paramCacheEntry1.a).S().d(), ((FeedStory)paramCacheEntry1.a).cacheId);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedUnitCache.1
 * JD-Core Version:    0.6.0
 */