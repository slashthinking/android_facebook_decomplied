package com.facebook.feed.ui.permalink;

import android.os.Handler;
import com.facebook.feed.ui.ScrollerRunnable;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.CommentClickedEvent;
import com.facebook.feed.util.event.UfiEvents.CommentClickedEventSubscriber;
import com.facebook.feed.util.event.UfiEvents.CommentFocusEvent;

class PermalinkFragment$CommentClickSubscriber extends UfiEvents.CommentClickedEventSubscriber
{
  private PermalinkFragment$CommentClickSubscriber(PermalinkFragment paramPermalinkFragment)
  {
  }

  public void a(UfiEvents.CommentClickedEvent paramCommentClickedEvent)
  {
    if (PermalinkFragment.n(this.a).getLastVisiblePosition() != -1 + PermalinkFragment.n(this.a).getCount())
    {
      PermalinkFragment.n(this.a).a();
      PermalinkFragment.o(this.a).a(-1 + PermalinkFragment.n(this.a).getCount());
      PermalinkFragment.p(this.a).postDelayed(new PermalinkFragment.CommentClickSubscriber.1(this), 400L);
    }
    while (true)
    {
      return;
      PermalinkFragment.q(this.a).a(new UfiEvents.CommentFocusEvent());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.CommentClickSubscriber
 * JD-Core Version:    0.6.0
 */