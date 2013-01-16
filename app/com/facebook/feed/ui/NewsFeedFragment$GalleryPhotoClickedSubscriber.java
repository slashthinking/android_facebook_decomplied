package com.facebook.feed.ui;

import com.facebook.feed.photos.FeedPhotoState;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoClickedEvent;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoClickedEventSubscriber;

class NewsFeedFragment$GalleryPhotoClickedSubscriber extends PhotoEvents.GalleryPhotoClickedEventSubscriber
{
  private NewsFeedFragment$GalleryPhotoClickedSubscriber(NewsFeedFragment paramNewsFeedFragment)
  {
  }

  public void a(PhotoEvents.GalleryPhotoClickedEvent paramGalleryPhotoClickedEvent)
  {
    NewsFeedFragment.c(this.a).b(null);
    NewsFeedFragment.c(this.a).a(paramGalleryPhotoClickedEvent.a);
    NewsFeedFragment.c(this.a).a(paramGalleryPhotoClickedEvent.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedFragment.GalleryPhotoClickedSubscriber
 * JD-Core Version:    0.6.0
 */