package com.facebook.feed.db;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.annotations.IsNativeNewsFeedPrefetchEnabled;
import com.facebook.feed.cache.FeedUnitPartialCache;
import com.facebook.feed.cache.PrefetchedFeedCache;
import com.facebook.feed.data.FeedbackMutator;
import com.facebook.feed.prefs.NewsFeedServerSuppliedParameters;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class NewsFeedDbModule$NFDbServiceHandlerProvider extends AbstractProvider<NFDbServiceHandler>
{
  private NewsFeedDbModule$NFDbServiceHandlerProvider(NewsFeedDbModule paramNewsFeedDbModule)
  {
  }

  public NFDbServiceHandler a()
  {
    return new NFDbServiceHandler((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (NewsFeedServerSuppliedParameters)b(NewsFeedServerSuppliedParameters.class), (DbFeedHomeStoriesHandler)b(DbFeedHomeStoriesHandler.class), (PrefetchedFeedCache)b(PrefetchedFeedCache.class), (FeedUnitPartialCache)b(FeedUnitPartialCache.class), (NewsFeedUserDataCleaner)b(NewsFeedUserDataCleaner.class), a(Boolean.class, IsNativeNewsFeedPrefetchEnabled.class), (NewsFeedAnalyticsEventBuilder)b(NewsFeedAnalyticsEventBuilder.class), (AnalyticsLogger)b(AnalyticsLogger.class), (FbErrorReporter)b(FbErrorReporter.class), (PerformanceLogger)b(PerformanceLogger.class), (Clock)b(Clock.class), (FeedbackMutator)b(FeedbackMutator.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbModule.NFDbServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */