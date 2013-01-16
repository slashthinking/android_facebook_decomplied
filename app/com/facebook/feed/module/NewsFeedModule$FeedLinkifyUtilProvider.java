package com.facebook.feed.module;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.flyout.FlyoutAnimationHandler;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$FeedLinkifyUtilProvider extends AbstractProvider<FeedLinkifyUtil>
{
  private NewsFeedModule$FeedLinkifyUtilProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FeedLinkifyUtil a()
  {
    return new FeedLinkifyUtil(NewsFeedModule.a(this.a), (NewsFeedAnalyticsEventBuilder)b(NewsFeedAnalyticsEventBuilder.class), (AnalyticsLogger)b(AnalyticsLogger.class), (FlyoutAnimationHandler)b(FlyoutAnimationHandler.class), (SecureContextHelper)b(SecureContextHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedLinkifyUtilProvider
 * JD-Core Version:    0.6.0
 */