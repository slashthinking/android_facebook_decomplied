package com.facebook.feed.module;

import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$NewsFeedAnalyticsEventBuilderProvider extends AbstractProvider<NewsFeedAnalyticsEventBuilder>
{
  private NewsFeedModule$NewsFeedAnalyticsEventBuilderProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedAnalyticsEventBuilder a()
  {
    return new NewsFeedAnalyticsEventBuilder();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedAnalyticsEventBuilderProvider
 * JD-Core Version:    0.6.0
 */