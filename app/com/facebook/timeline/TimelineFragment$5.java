package com.facebook.timeline;

import android.content.Intent;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoAnimationEndedEvent;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoAnimationEndedEventSubscriber;

class TimelineFragment$5 extends PhotoEvents.GalleryPhotoAnimationEndedEventSubscriber
{
  public void a(PhotoEvents.GalleryPhotoAnimationEndedEvent paramGalleryPhotoAnimationEndedEvent)
  {
    Intent localIntent = TimelineFragment.c(this.a).a(paramGalleryPhotoAnimationEndedEvent.a, paramGalleryPhotoAnimationEndedEvent.b, paramGalleryPhotoAnimationEndedEvent.c, paramGalleryPhotoAnimationEndedEvent.d, paramGalleryPhotoAnimationEndedEvent.e, TimelineFragment.b(this.a));
    TimelineFragment.a(this.a, localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFragment.5
 * JD-Core Version:    0.6.0
 */