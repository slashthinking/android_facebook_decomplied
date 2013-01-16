package com.facebook.feed.flyout;

import android.view.View;
import com.facebook.common.util.TriState;
import com.facebook.feed.util.event.FlyoutEvents.CommentLikeActionResultEvent;
import com.facebook.feed.util.event.FlyoutEvents.CommentLikeActionResultEventSubscriber;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.Feedback;

class FeedFlyoutCommentView$CommentLikeActionResultEventSubscriber extends FlyoutEvents.CommentLikeActionResultEventSubscriber
{
  private FeedFlyoutCommentView$CommentLikeActionResultEventSubscriber(FeedFlyoutCommentView paramFeedFlyoutCommentView)
  {
  }

  public void a(FlyoutEvents.CommentLikeActionResultEvent paramCommentLikeActionResultEvent)
  {
    if ((paramCommentLikeActionResultEvent == null) || (paramCommentLikeActionResultEvent.a == null) || (paramCommentLikeActionResultEvent.a.S() == null) || (FeedFlyoutCommentView.b(this.a) == null) || (FeedFlyoutCommentView.b(this.a).S() == null) || (!FeedFlyoutCommentView.b(this.a).S().legacyApiPostId.equals(paramCommentLikeActionResultEvent.a.S().legacyApiPostId)));
    while (true)
    {
      return;
      if (!TriState.UNSET.equals(paramCommentLikeActionResultEvent.b))
        FeedFlyoutCommentView.d(this.a).setClickable(true);
      FeedFlyoutCommentView.a(this.a, paramCommentLikeActionResultEvent.a);
      FeedFlyoutCommentView.e(this.a);
      FeedFlyoutCommentView.f(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutCommentView.CommentLikeActionResultEventSubscriber
 * JD-Core Version:    0.6.0
 */