package com.facebook.feed.module;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.photos.NewsFeedPhotoAnimation;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$NewsFeedPhotoAnimationProvider extends AbstractProvider<NewsFeedPhotoAnimation>
{
  private NewsFeedModule$NewsFeedPhotoAnimationProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedPhotoAnimation a()
  {
    return new NewsFeedPhotoAnimation((AnalyticsLogger)b(AnalyticsLogger.class), (NewsFeedAnalyticsEventBuilder)b(NewsFeedAnalyticsEventBuilder.class), (ImageCache)b(ImageCache.class), (FeedEventBus)b(FeedEventBus.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedPhotoAnimationProvider
 * JD-Core Version:    0.6.0
 */