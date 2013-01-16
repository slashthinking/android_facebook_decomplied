package com.facebook.feed.ui.permalink;

import com.facebook.feed.photos.FeedPhotoState;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoClickedEvent;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoClickedEventSubscriber;

class PermalinkFragment$SinglePhotoClickedSubscriber extends PhotoEvents.SinglePhotoClickedEventSubscriber
{
  private PermalinkFragment$SinglePhotoClickedSubscriber(PermalinkFragment paramPermalinkFragment)
  {
  }

  public void a(PhotoEvents.SinglePhotoClickedEvent paramSinglePhotoClickedEvent)
  {
    PermalinkFragment.r(this.a).b(paramSinglePhotoClickedEvent.a);
    PermalinkFragment.r(this.a).b(null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.SinglePhotoClickedSubscriber
 * JD-Core Version:    0.6.0
 */