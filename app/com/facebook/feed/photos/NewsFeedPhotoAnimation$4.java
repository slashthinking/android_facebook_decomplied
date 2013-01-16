package com.facebook.feed.photos;

import com.facebook.widget.ExpandablePhoto;
import com.facebook.widget.ExpandablePhoto.OnPhotoAnimationEndListener;
import com.facebook.widget.UrlImage;

class NewsFeedPhotoAnimation$4
  implements ExpandablePhoto.OnPhotoAnimationEndListener
{
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      NewsFeedPhotoAnimation.a(this.d, this.a);
    NewsFeedPhotoAnimation.a(this.d, this.b, this.c, NewsFeedPhotoAnimation.VisibilityStates.ON_ANIMATION_FAILED);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.photos.NewsFeedPhotoAnimation.4
 * JD-Core Version:    0.6.0
 */