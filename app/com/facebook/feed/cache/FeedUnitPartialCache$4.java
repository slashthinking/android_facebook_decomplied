package com.facebook.feed.cache;

import android.support.v4.util.LruCache;
import com.facebook.feed.db.DbFeedUnitPartialHandler;

class FeedUnitPartialCache$4 extends LruCache<String, FeedUnitPartial>
{
  protected void a(boolean paramBoolean, String paramString, FeedUnitPartial paramFeedUnitPartial1, FeedUnitPartial paramFeedUnitPartial2)
  {
    if ((paramFeedUnitPartial2 == null) || (!paramFeedUnitPartial2.c.equals(paramFeedUnitPartial1.c)))
      FeedUnitPartialCache.b(this.a).a(paramFeedUnitPartial1.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedUnitPartialCache.4
 * JD-Core Version:    0.6.0
 */