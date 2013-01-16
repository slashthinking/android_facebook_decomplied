package com.facebook.feed.ui;

import com.facebook.feed.photos.FeedPhotoState;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoClickedEvent;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoClickedEventSubscriber;

class NewsFeedFragment$SinglePhotoClickedSubscriber extends PhotoEvents.SinglePhotoClickedEventSubscriber
{
  private NewsFeedFragment$SinglePhotoClickedSubscriber(NewsFeedFragment paramNewsFeedFragment)
  {
  }

  public void a(PhotoEvents.SinglePhotoClickedEvent paramSinglePhotoClickedEvent)
  {
    NewsFeedFragment.c(this.a).b(paramSinglePhotoClickedEvent.a);
    NewsFeedFragment.c(this.a).b(null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedFragment.SinglePhotoClickedSubscriber
 * JD-Core Version:    0.6.0
 */