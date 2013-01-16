package com.facebook.feed.ui.permalink;

import com.facebook.feed.util.event.UfiEvents.CommentPostEvent;
import com.facebook.feed.util.event.UfiEvents.CommentPostEventSubscriber;

class PermalinkFragment$CommentPostSubscriber extends UfiEvents.CommentPostEventSubscriber
{
  private PermalinkFragment$CommentPostSubscriber(PermalinkFragment paramPermalinkFragment)
  {
  }

  public void a(UfiEvents.CommentPostEvent paramCommentPostEvent)
  {
    PermalinkFragment.a(this.a, paramCommentPostEvent.a, paramCommentPostEvent.b, paramCommentPostEvent.c, paramCommentPostEvent.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.CommentPostSubscriber
 * JD-Core Version:    0.6.0
 */