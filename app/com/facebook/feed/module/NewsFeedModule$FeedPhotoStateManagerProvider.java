package com.facebook.feed.module;

import com.facebook.feed.photos.FeedPhotoStateManager;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$FeedPhotoStateManagerProvider extends AbstractProvider<FeedPhotoStateManager>
{
  private NewsFeedModule$FeedPhotoStateManagerProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public FeedPhotoStateManager a()
  {
    return new FeedPhotoStateManager();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.FeedPhotoStateManagerProvider
 * JD-Core Version:    0.6.0
 */