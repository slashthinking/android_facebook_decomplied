package com.facebook.feed.module;

import android.app.Activity;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.orca.images.FetchImageExecutor;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$FeedImageLoaderProvider extends AbstractProvider<FeedImageLoader>
{
  private NewsFeedModule$FeedImageLoaderProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FeedImageLoader a()
  {
    return new FeedImageLoader((Activity)b(Activity.class), (FeedRendererOptions)b(FeedRendererOptions.class), (ImageCache)b(ImageCache.class), (FetchImageExecutor)b(FetchImageExecutor.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedImageLoaderProvider
 * JD-Core Version:    0.6.0
 */