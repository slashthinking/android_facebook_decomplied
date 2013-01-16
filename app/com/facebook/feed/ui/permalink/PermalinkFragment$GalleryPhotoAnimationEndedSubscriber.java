package com.facebook.feed.ui.permalink;

import android.content.Intent;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoAnimationEndedEvent;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoAnimationEndedEventSubscriber;

class PermalinkFragment$GalleryPhotoAnimationEndedSubscriber extends PhotoEvents.GalleryPhotoAnimationEndedEventSubscriber
{
  private PermalinkFragment$GalleryPhotoAnimationEndedSubscriber(PermalinkFragment paramPermalinkFragment)
  {
  }

  public void a(PhotoEvents.GalleryPhotoAnimationEndedEvent paramGalleryPhotoAnimationEndedEvent)
  {
    Intent localIntent = PermalinkFragment.t(this.a).a(paramGalleryPhotoAnimationEndedEvent.a, paramGalleryPhotoAnimationEndedEvent.b, paramGalleryPhotoAnimationEndedEvent.c, paramGalleryPhotoAnimationEndedEvent.d, paramGalleryPhotoAnimationEndedEvent.e, PermalinkFragment.s(this.a));
    PermalinkFragment.a(this.a, localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.GalleryPhotoAnimationEndedSubscriber
 * JD-Core Version:    0.6.0
 */