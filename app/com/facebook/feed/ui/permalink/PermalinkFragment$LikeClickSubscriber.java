package com.facebook.feed.ui.permalink;

import com.facebook.feed.util.event.UfiEvents.LikeClickedEvent;
import com.facebook.feed.util.event.UfiEvents.LikeClickedEventSubscriber;
import com.facebook.graphql.model.FeedStory;
import com.google.common.base.Objects;

class PermalinkFragment$LikeClickSubscriber extends UfiEvents.LikeClickedEventSubscriber
{
  private PermalinkFragment$LikeClickSubscriber(PermalinkFragment paramPermalinkFragment)
  {
  }

  public void a(UfiEvents.LikeClickedEvent paramLikeClickedEvent)
  {
    if ((Objects.equal(PermalinkFragment.e(this.a).getCacheId(), paramLikeClickedEvent.a)) && (PermalinkFragment.e(this.a).b()))
      PermalinkFragment.b(this.a, PermalinkFragment.e(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.LikeClickSubscriber
 * JD-Core Version:    0.6.0
 */