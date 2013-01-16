package com.facebook.feed.ui.permalink;

import android.widget.EditText;
import com.facebook.feed.util.FeedUtils;
import com.facebook.feed.util.event.UfiEvents.CommentFocusEvent;
import com.facebook.feed.util.event.UfiEvents.CommentFocusEventSubscriber;

class PermalinkAddReplyView$CommentFocusSubscriber extends UfiEvents.CommentFocusEventSubscriber
{
  private PermalinkAddReplyView$CommentFocusSubscriber(PermalinkAddReplyView paramPermalinkAddReplyView)
  {
  }

  public void a(UfiEvents.CommentFocusEvent paramCommentFocusEvent)
  {
    PermalinkAddReplyView.b(this.a).requestFocus();
    FeedUtils.a(PermalinkAddReplyView.c(this.a), PermalinkAddReplyView.b(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkAddReplyView.CommentFocusSubscriber
 * JD-Core Version:    0.6.0
 */