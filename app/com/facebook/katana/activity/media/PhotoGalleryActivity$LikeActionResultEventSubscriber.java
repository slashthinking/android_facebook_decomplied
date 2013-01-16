package com.facebook.katana.activity.media;

import com.facebook.feed.util.event.FlyoutEvents.LikeActionResultEvent;
import com.facebook.feed.util.event.FlyoutEvents.LikeActionResultEventSubscriber;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.Feedback;
import com.facebook.widget.PhotoToggleButton;

class PhotoGalleryActivity$LikeActionResultEventSubscriber extends FlyoutEvents.LikeActionResultEventSubscriber
{
  private PhotoGalleryActivity$LikeActionResultEventSubscriber(PhotoGalleryActivity paramPhotoGalleryActivity)
  {
  }

  public void a(FlyoutEvents.LikeActionResultEvent paramLikeActionResultEvent)
  {
    if ((paramLikeActionResultEvent == null) || (paramLikeActionResultEvent.a == null));
    while (true)
    {
      return;
      PhotoGalleryActivity.M(this.a).setChecked(paramLikeActionResultEvent.a.doesViewerLike);
      if (paramLikeActionResultEvent.a.likers == null)
        continue;
      PhotoGalleryActivity.a(this.a, paramLikeActionResultEvent.a.likers.count);
      PhotoGalleryActivity.N(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity.LikeActionResultEventSubscriber
 * JD-Core Version:    0.6.0
 */