package com.facebook.feed.db;

import com.facebook.feed.cache.FeedUnitPartialCache;
import com.facebook.feed.cache.FeedUnitPartialCache.FeedUnitPartialCacheInitializer;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedDbModule$FeedUnitPartialCacheInitializerProvider extends AbstractProvider<FeedUnitPartialCache.FeedUnitPartialCacheInitializer>
{
  public FeedUnitPartialCache.FeedUnitPartialCacheInitializer a()
  {
    return ((FeedUnitPartialCache)b(FeedUnitPartialCache.class)).b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.FeedUnitPartialCacheInitializerProvider
 * JD-Core Version:    0.6.0
 */