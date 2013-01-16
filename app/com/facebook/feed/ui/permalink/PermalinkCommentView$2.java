package com.facebook.feed.ui.permalink;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.util.FeedUtils;
import com.facebook.graphql.model.FeedStoryLikers;
import com.facebook.graphql.model.Feedback;

class PermalinkCommentView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Intent localIntent = PermalinkCommentView.e(this.b).a(FeedUtils.a(this.a.doesViewerLike, PermalinkCommentView.d(this.b), this.a.likers.likers));
    PermalinkCommentView.f(this.b).startActivity(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkCommentView.2
 * JD-Core Version:    0.6.0
 */