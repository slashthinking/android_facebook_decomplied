package com.facebook.timeline;

import android.content.Intent;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoAnimationEndedEvent;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoAnimationEndedEventSubscriber;

class TimelineFragment$3 extends PhotoEvents.SinglePhotoAnimationEndedEventSubscriber
{
  public void a(PhotoEvents.SinglePhotoAnimationEndedEvent paramSinglePhotoAnimationEndedEvent)
  {
    Intent localIntent = TimelineFragment.c(this.a).a(paramSinglePhotoAnimationEndedEvent.a, paramSinglePhotoAnimationEndedEvent.b, paramSinglePhotoAnimationEndedEvent.c, paramSinglePhotoAnimationEndedEvent.d, TimelineFragment.b(this.a));
    TimelineFragment.a(this.a, localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFragment.3
 * JD-Core Version:    0.6.0
 */