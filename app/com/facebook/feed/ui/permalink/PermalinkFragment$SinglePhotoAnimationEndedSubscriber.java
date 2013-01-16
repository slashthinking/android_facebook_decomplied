package com.facebook.feed.ui.permalink;

import android.content.Intent;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoAnimationEndedEvent;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoAnimationEndedEventSubscriber;

class PermalinkFragment$SinglePhotoAnimationEndedSubscriber extends PhotoEvents.SinglePhotoAnimationEndedEventSubscriber
{
  private PermalinkFragment$SinglePhotoAnimationEndedSubscriber(PermalinkFragment paramPermalinkFragment)
  {
  }

  public void a(PhotoEvents.SinglePhotoAnimationEndedEvent paramSinglePhotoAnimationEndedEvent)
  {
    Intent localIntent = PermalinkFragment.t(this.a).a(paramSinglePhotoAnimationEndedEvent.a, paramSinglePhotoAnimationEndedEvent.b, paramSinglePhotoAnimationEndedEvent.c, paramSinglePhotoAnimationEndedEvent.d, PermalinkFragment.s(this.a));
    PermalinkFragment.a(this.a, localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.SinglePhotoAnimationEndedSubscriber
 * JD-Core Version:    0.6.0
 */