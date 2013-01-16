package com.facebook.feed.photos;

import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoAnimationEndedEvent;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.widget.ExpandablePhoto.OnPhotoAnimationEndListener;
import com.facebook.widget.UrlImage;

class NewsFeedPhotoAnimation$2$1
  implements ExpandablePhoto.OnPhotoAnimationEndListener
{
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.a != null) && (this.a.image != null) && (this.a.image.uri != null))
        NewsFeedPhotoAnimation.a(this.c.i).a(new PhotoEvents.GalleryPhotoAnimationEndedEvent(Long.parseLong(this.a.id), this.c.c, this.c.d, this.c.e, this.c.f));
      NewsFeedPhotoAnimation.a(this.c.i, this.b, this.c.b, NewsFeedPhotoAnimation.VisibilityStates.PREP_BEFORE_AND_AFTER_ANIMATION);
    }
    while (true)
    {
      return;
      NewsFeedPhotoAnimation.a(this.c.i, this.b, this.c.b, NewsFeedPhotoAnimation.VisibilityStates.ON_ANIMATION_FAILED);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.photos.NewsFeedPhotoAnimation.2.1
 * JD-Core Version:    0.6.0
 */