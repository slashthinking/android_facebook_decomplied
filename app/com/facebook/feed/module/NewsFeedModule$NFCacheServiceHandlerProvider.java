package com.facebook.feed.module;

import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.cache.NFCacheServiceHandler;
import com.facebook.feed.cache.NewsFeedCache;
import com.facebook.feed.cache.PendingStoryCache;
import com.facebook.feed.cache.PendingStoryCentralCache;
import com.facebook.feed.db.DbFeedHomeStoriesHandler;
import com.facebook.feed.db.NewsFeedUserDataCleaner;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class NewsFeedModule$NFCacheServiceHandlerProvider extends AbstractProvider<NFCacheServiceHandler>
{
  private NewsFeedModule$NFCacheServiceHandlerProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NFCacheServiceHandler a()
  {
    return new NFCacheServiceHandler((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (NewsFeedCache)b(NewsFeedCache.class), (PendingStoryCache)b(PendingStoryCache.class, PendingStoryCentralCache.class), (NewsFeedUserDataCleaner)b(NewsFeedUserDataCleaner.class), (FbErrorReporter)b(FbErrorReporter.class), (PerformanceLogger)b(PerformanceLogger.class), (DbFeedHomeStoriesHandler)b(DbFeedHomeStoriesHandler.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NFCacheServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */