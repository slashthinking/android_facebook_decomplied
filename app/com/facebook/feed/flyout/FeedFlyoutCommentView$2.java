package com.facebook.feed.flyout;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.Feedback;

class FeedFlyoutCommentView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (FeedFlyoutCommentView.b(this.a).S().canViewerLike)
    {
      paramView.setClickable(false);
      FeedFlyoutCommentView.c(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutCommentView.2
 * JD-Core Version:    0.6.0
 */