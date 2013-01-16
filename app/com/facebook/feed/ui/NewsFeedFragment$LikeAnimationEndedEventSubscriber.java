package com.facebook.feed.ui;

import com.facebook.feed.util.event.UfiEvents.LikeAnimationEndedEvent;
import com.facebook.feed.util.event.UfiEvents.LikeAnimationEndedEventSubscriber;

class NewsFeedFragment$LikeAnimationEndedEventSubscriber extends UfiEvents.LikeAnimationEndedEventSubscriber
{
  private NewsFeedFragment$LikeAnimationEndedEventSubscriber(NewsFeedFragment paramNewsFeedFragment)
  {
  }

  public void a(UfiEvents.LikeAnimationEndedEvent paramLikeAnimationEndedEvent)
  {
    if (this.a.d != null)
      this.a.d.notifyDataSetChanged();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedFragment.LikeAnimationEndedEventSubscriber
 * JD-Core Version:    0.6.0
 */