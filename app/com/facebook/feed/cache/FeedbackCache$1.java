package com.facebook.feed.cache;

import android.support.v4.util.LruCache;
import com.facebook.graphql.model.Feedback;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import java.util.Map;

class FeedbackCache$1 extends LruCache<String, FeedbackCache.CacheEntry>
{
  protected void a(boolean paramBoolean, String paramString, FeedbackCache.CacheEntry paramCacheEntry1, FeedbackCache.CacheEntry paramCacheEntry2)
  {
    if ((paramCacheEntry2 == null) || (!Objects.equal(paramCacheEntry1.a.legacyApiPostId, paramCacheEntry2.a.legacyApiPostId)))
    {
      FeedbackCache.a(this.a).remove(paramCacheEntry1.a.legacyApiPostId);
      if (!Strings.isNullOrEmpty(paramCacheEntry1.b))
        FeedbackCache.b(this.a).remove(paramCacheEntry1.b);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedbackCache.1
 * JD-Core Version:    0.6.0
 */