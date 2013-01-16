package com.facebook.feed.module;

import android.app.Activity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.flyout.FlyoutAnimationHandler;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$FeedUnitRendererProvider extends AbstractProvider<IFeedUnitRenderer>
{
  private NewsFeedModule$FeedUnitRendererProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public IFeedUnitRenderer a()
  {
    return new DefaultFeedUnitRenderer((Activity)b(Activity.class), (IFeedIntentBuilder)b(IFeedIntentBuilder.class), (AnalyticsLogger)b(AnalyticsLogger.class), (FeedLinkifyUtil)b(FeedLinkifyUtil.class), (FlyoutAnimationHandler)b(FlyoutAnimationHandler.class), (SecureContextHelper)b(SecureContextHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedUnitRendererProvider
 * JD-Core Version:    0.6.0
 */