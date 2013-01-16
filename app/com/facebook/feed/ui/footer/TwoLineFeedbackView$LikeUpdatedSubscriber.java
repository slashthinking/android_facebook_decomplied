package com.facebook.feed.ui.footer;

import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.data.FeedStoryMutator.Result;
import com.facebook.feed.util.event.UfiEvents.LikeUpdatedUIEvent;
import com.facebook.feed.util.event.UfiEvents.LikeUpdatedUIEventSubscriber;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Objects;

class TwoLineFeedbackView$LikeUpdatedSubscriber extends UfiEvents.LikeUpdatedUIEventSubscriber
{
  private TwoLineFeedbackView$LikeUpdatedSubscriber(TwoLineFeedbackView paramTwoLineFeedbackView)
  {
  }

  public void a(UfiEvents.LikeUpdatedUIEvent paramLikeUpdatedUIEvent)
  {
    boolean bool1;
    if ((TwoLineFeedbackView.j(this.a) != null) && (Objects.equal(paramLikeUpdatedUIEvent.a, TwoLineFeedbackView.j(this.a).S().legacyApiPostId)))
    {
      bool1 = TwoLineFeedbackView.j(this.a).D();
      if (paramLikeUpdatedUIEvent.b)
        break label119;
    }
    label119: for (boolean bool2 = true; ; bool2 = false)
    {
      if (bool1 == bool2)
      {
        GraphQLProfile localGraphQLProfile = ((GraphQLProfileCache)TwoLineFeedbackView.k(this.a).a(GraphQLProfileCache.class)).a();
        TwoLineFeedbackView.a(this.a, TwoLineFeedbackView.l(this.a).a(TwoLineFeedbackView.j(this.a), localGraphQLProfile).b());
        this.a.a(true);
      }
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.TwoLineFeedbackView.LikeUpdatedSubscriber
 * JD-Core Version:    0.6.0
 */