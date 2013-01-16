package com.facebook.feed.module;

import android.app.Activity;
import android.content.Context;
import com.facebook.feed.annotations.IsNativeNewsfeedSpamReportingEnabled;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.feed.ui.FeedStoryMenuHelper;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$FeedStoryMenuHelperProvider extends AbstractProvider<FeedStoryMenuHelper>
{
  private NewsFeedModule$FeedStoryMenuHelperProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FeedStoryMenuHelper a()
  {
    return new FeedStoryMenuHelper((Context)b(Activity.class), (IFeedIntentBuilder)b(IFeedIntentBuilder.class), (IFeedUnitRenderer)b(IFeedUnitRenderer.class), ((Boolean)b(Boolean.class, IsNativeNewsfeedSpamReportingEnabled.class)).booleanValue());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedStoryMenuHelperProvider
 * JD-Core Version:    0.6.0
 */