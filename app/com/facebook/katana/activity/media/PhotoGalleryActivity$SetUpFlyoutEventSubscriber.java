package com.facebook.katana.activity.media;

import com.facebook.feed.util.event.FlyoutEvents.SetUpHeaderViewEventSubscriber;
import com.facebook.feed.util.event.FlyoutEvents.SetupHeaderViewEvent;
import com.facebook.graphql.model.FeedStoryComments;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.Feedback;
import com.facebook.widget.PhotoToggleButton;

class PhotoGalleryActivity$SetUpFlyoutEventSubscriber extends FlyoutEvents.SetUpHeaderViewEventSubscriber
{
  private PhotoGalleryActivity$SetUpFlyoutEventSubscriber(PhotoGalleryActivity paramPhotoGalleryActivity)
  {
  }

  public void a(FlyoutEvents.SetupHeaderViewEvent paramSetupHeaderViewEvent)
  {
    int i = 1;
    if ((paramSetupHeaderViewEvent == null) || (paramSetupHeaderViewEvent.a == null) || (paramSetupHeaderViewEvent.a.likers == null) || (paramSetupHeaderViewEvent.a.likers.count == -1) || (paramSetupHeaderViewEvent.a.comments == null) || (paramSetupHeaderViewEvent.a.comments.count == -1))
      return;
    int j = paramSetupHeaderViewEvent.a.likers.count;
    int k = PhotoGalleryActivity.K(this.a);
    int m = 0;
    if (j != k)
      m = i;
    if (paramSetupHeaderViewEvent.a.comments.count != PhotoGalleryActivity.L(this.a));
    while (true)
    {
      if (i != 0)
        PhotoGalleryActivity.a(this.a, paramSetupHeaderViewEvent.a);
      PhotoGalleryActivity.M(this.a).setChecked(paramSetupHeaderViewEvent.a.doesViewerLike);
      break;
      i = m;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotoGalleryActivity.SetUpFlyoutEventSubscriber
 * JD-Core Version:    0.6.0
 */