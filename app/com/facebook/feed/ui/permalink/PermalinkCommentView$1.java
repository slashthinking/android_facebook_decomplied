package com.facebook.feed.ui.permalink;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.CommentLikeClickedEvent;
import com.facebook.graphql.model.FeedComment;

class PermalinkCommentView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (PermalinkCommentView.a(this.a).b())
      PermalinkCommentView.c(this.a).a(new UfiEvents.CommentLikeClickedEvent(PermalinkCommentView.b(this.a), PermalinkCommentView.a(this.a)));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkCommentView.1
 * JD-Core Version:    0.6.0
 */