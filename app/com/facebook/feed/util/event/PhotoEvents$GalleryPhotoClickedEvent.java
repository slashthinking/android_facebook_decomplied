package com.facebook.feed.util.event;

import com.facebook.feed.ui.NewsFeedImageAdapter;
import com.facebook.widget.UrlImage;

public class PhotoEvents$GalleryPhotoClickedEvent extends FeedEvent
{
  public final UrlImage a;
  public final NewsFeedImageAdapter b;

  public PhotoEvents$GalleryPhotoClickedEvent(UrlImage paramUrlImage, NewsFeedImageAdapter paramNewsFeedImageAdapter)
  {
    this.a = paramUrlImage;
    this.b = paramNewsFeedImageAdapter;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.event.PhotoEvents.GalleryPhotoClickedEvent
 * JD-Core Version:    0.6.0
 */