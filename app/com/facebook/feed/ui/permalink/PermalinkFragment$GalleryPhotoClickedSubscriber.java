package com.facebook.feed.ui.permalink;

import com.facebook.feed.photos.FeedPhotoState;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoClickedEvent;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoClickedEventSubscriber;

class PermalinkFragment$GalleryPhotoClickedSubscriber extends PhotoEvents.GalleryPhotoClickedEventSubscriber
{
  private PermalinkFragment$GalleryPhotoClickedSubscriber(PermalinkFragment paramPermalinkFragment)
  {
  }

  public void a(PhotoEvents.GalleryPhotoClickedEvent paramGalleryPhotoClickedEvent)
  {
    PermalinkFragment.r(this.a).b(null);
    PermalinkFragment.r(this.a).a(paramGalleryPhotoClickedEvent.a);
    PermalinkFragment.r(this.a).a(paramGalleryPhotoClickedEvent.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.GalleryPhotoClickedSubscriber
 * JD-Core Version:    0.6.0
 */