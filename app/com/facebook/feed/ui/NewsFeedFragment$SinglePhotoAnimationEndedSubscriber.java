package com.facebook.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoAnimationEndedEvent;
import com.facebook.feed.util.event.PhotoEvents.SinglePhotoAnimationEndedEventSubscriber;

class NewsFeedFragment$SinglePhotoAnimationEndedSubscriber extends PhotoEvents.SinglePhotoAnimationEndedEventSubscriber
{
  private NewsFeedFragment$SinglePhotoAnimationEndedSubscriber(NewsFeedFragment paramNewsFeedFragment)
  {
  }

  public void a(PhotoEvents.SinglePhotoAnimationEndedEvent paramSinglePhotoAnimationEndedEvent)
  {
    Intent localIntent = NewsFeedFragment.e(this.a).a(paramSinglePhotoAnimationEndedEvent.a, paramSinglePhotoAnimationEndedEvent.b, paramSinglePhotoAnimationEndedEvent.c, paramSinglePhotoAnimationEndedEvent.d, NewsFeedFragment.d(this.a));
    if (localIntent != null)
    {
      localIntent.setFlags(65536);
      FragmentActivity localFragmentActivity = this.a.n();
      if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
        localFragmentActivity.startActivity(localIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedFragment.SinglePhotoAnimationEndedSubscriber
 * JD-Core Version:    0.6.0
 */