package com.facebook.feed.module;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.util.DefaultFeedStoryImpressionLogger;
import com.facebook.feed.util.IFeedStoryImpressionLogger;
import com.facebook.orca.common.http.OrcaHttpClient;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class NewsFeedModule$SponsoredStoryImpressionLoggerProvider extends AbstractProvider<IFeedStoryImpressionLogger>
{
  private NewsFeedModule$SponsoredStoryImpressionLoggerProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public IFeedStoryImpressionLogger a()
  {
    return new DefaultFeedStoryImpressionLogger(NewsFeedModule.a(this.a), (OrcaHttpClient)b(OrcaHttpClient.class), (AnalyticsLogger)b(AnalyticsLogger.class), (NewsFeedAnalyticsEventBuilder)b(NewsFeedAnalyticsEventBuilder.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.SponsoredStoryImpressionLoggerProvider
 * JD-Core Version:    0.6.0
 */