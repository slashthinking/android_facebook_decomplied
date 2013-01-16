package com.facebook.timeline;

import com.facebook.feed.photos.FeedPhotoState;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoClickedEvent;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoClickedEventSubscriber;

class TimelineFragment$4 extends PhotoEvents.GalleryPhotoClickedEventSubscriber
{
  public void a(PhotoEvents.GalleryPhotoClickedEvent paramGalleryPhotoClickedEvent)
  {
    TimelineFragment.a(this.a).b(null);
    TimelineFragment.a(this.a).a(paramGalleryPhotoClickedEvent.a);
    TimelineFragment.a(this.a).a(paramGalleryPhotoClickedEvent.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFragment.4
 * JD-Core Version:    0.6.0
 */