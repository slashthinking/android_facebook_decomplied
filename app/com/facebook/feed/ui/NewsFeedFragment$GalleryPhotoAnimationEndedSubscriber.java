package com.facebook.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoAnimationEndedEvent;
import com.facebook.feed.util.event.PhotoEvents.GalleryPhotoAnimationEndedEventSubscriber;

class NewsFeedFragment$GalleryPhotoAnimationEndedSubscriber extends PhotoEvents.GalleryPhotoAnimationEndedEventSubscriber
{
  private NewsFeedFragment$GalleryPhotoAnimationEndedSubscriber(NewsFeedFragment paramNewsFeedFragment)
  {
  }

  public void a(PhotoEvents.GalleryPhotoAnimationEndedEvent paramGalleryPhotoAnimationEndedEvent)
  {
    Intent localIntent = NewsFeedFragment.e(this.a).a(paramGalleryPhotoAnimationEndedEvent.a, paramGalleryPhotoAnimationEndedEvent.b, paramGalleryPhotoAnimationEndedEvent.c, paramGalleryPhotoAnimationEndedEvent.d, paramGalleryPhotoAnimationEndedEvent.e, NewsFeedFragment.d(this.a));
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
 * Qualified Name:     com.facebook.feed.ui.NewsFeedFragment.GalleryPhotoAnimationEndedSubscriber
 * JD-Core Version:    0.6.0
 */