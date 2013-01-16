package com.facebook.feed.ui.permalink;

import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.data.FeedStoryMutator.Result;
import com.facebook.feed.data.PagedCommentCollection;
import com.facebook.feed.util.event.UfiEvents.CommentLikeClickedEvent;
import com.facebook.feed.util.event.UfiEvents.CommentLikeClickedEventSubscriber;
import com.facebook.graphql.model.FeedComment;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.Feedback;
import com.google.common.base.Objects;

class PermalinkFragment$CommentLikeClickedEventSubscriber extends UfiEvents.CommentLikeClickedEventSubscriber
{
  private PermalinkFragment$CommentLikeClickedEventSubscriber(PermalinkFragment paramPermalinkFragment)
  {
  }

  public void a(UfiEvents.CommentLikeClickedEvent paramCommentLikeClickedEvent)
  {
    if ((PermalinkFragment.e(this.a) != null) && (PermalinkFragment.e(this.a).S() != null) && (Objects.equal(PermalinkFragment.e(this.a).S().id, paramCommentLikeClickedEvent.a)))
    {
      FeedStory localFeedStory = PermalinkFragment.e(this.a);
      FeedStoryMutator.Result localResult = PermalinkFragment.v(this.a).a(PermalinkFragment.e(this.a), paramCommentLikeClickedEvent.b, PermalinkFragment.u(this.a));
      PermalinkFragment.c(this.a, localResult.b());
      PermalinkFragment.l(this.a).b(localResult.c());
      PermalinkFragment.k(this.a).a(PermalinkFragment.e(this.a));
      Feedback localFeedback = localResult.c().S();
      PermalinkFragment.a(this.a, localFeedStory, localFeedback, "permalink_comment_like", true);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.CommentLikeClickedEventSubscriber
 * JD-Core Version:    0.6.0
 */