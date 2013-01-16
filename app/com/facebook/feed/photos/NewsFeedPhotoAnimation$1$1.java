package com.facebook.feed.photos;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoAnimationEndedEvent;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.widget.ExpandablePhoto.OnPhotoAnimationEndListener;

class NewsFeedPhotoAnimation$1$1
  implements ExpandablePhoto.OnPhotoAnimationEndListener
{
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.a.b.media != null) && (this.a.b.media.image != null) && (this.a.b.media.image.uri != null))
      {
        NewsFeedPhotoAnimation.c(this.a.f).b(this.a.e);
        NewsFeedPhotoAnimation.a(this.a.f).a(new PhotoEvents.SinglePhotoAnimationEndedEvent(Long.parseLong(this.a.b.media.id), this.a.b.media.image.uri, this.a.b.media.S().d(), this.a.b.mediaReferenceToken));
      }
      NewsFeedPhotoAnimation.a(this.a.f, this.a.c, this.a.d, NewsFeedPhotoAnimation.VisibilityStates.PREP_BEFORE_AND_AFTER_ANIMATION);
    }
    while (true)
    {
      return;
      NewsFeedPhotoAnimation.a(this.a.f, this.a.c, this.a.d, NewsFeedPhotoAnimation.VisibilityStates.ON_ANIMATION_FAILED);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.photos.NewsFeedPhotoAnimation.1.1
 * JD-Core Version:    0.6.0
 */