package com.facebook.feed.module;

import com.facebook.feed.photos.NewsFeedPhotoAnimation;
import com.facebook.feed.photos.NewsFeedPhotoAnimator;
import com.facebook.orca.inject.AbstractProvider;

class NewsFeedModule$NewsFeedPhotoAnimatorProvider extends AbstractProvider<NewsFeedPhotoAnimator>
{
  private NewsFeedModule$NewsFeedPhotoAnimatorProvider(NewsFeedModule paramNewsFeedModule)
  {
  }

  public NewsFeedPhotoAnimator a()
  {
    return new NewsFeedPhotoAnimator((NewsFeedPhotoAnimation)b(NewsFeedPhotoAnimation.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.NewsFeedModule.NewsFeedPhotoAnimatorProvider
 * JD-Core Version:    0.6.0
 */