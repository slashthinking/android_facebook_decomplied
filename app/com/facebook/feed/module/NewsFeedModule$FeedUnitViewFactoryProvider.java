package com.facebook.feed.module;

import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.feed.ui.FeedUnitViewFactory;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$FeedUnitViewFactoryProvider extends AbstractProvider<FeedUnitViewFactory>
{
  private NewsFeedModule$FeedUnitViewFactoryProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FeedUnitViewFactory a()
  {
    return new FeedUnitViewFactory((PerformanceLogger)b(PerformanceLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedUnitViewFactoryProvider
 * JD-Core Version:    0.6.0
 */