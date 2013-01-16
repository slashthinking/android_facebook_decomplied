package com.facebook.feed.ui.footer;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.feed.data.FeedStoryMutator;
import com.facebook.feed.data.FeedStoryMutator.Result;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.UfiEvents.PageLikeClickedEvent;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLActionLink;
import com.facebook.graphql.model.GraphQLProfile;

class PageFeedbackView$1
  implements View.OnTouchListener
{
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 0:
    case 1:
    case 3:
    }
    while (true)
    {
      return true;
      this.a.setBackgroundDrawable(PageFeedbackView.a(this.a).getResources().getDrawable(2130838189));
      continue;
      this.a.setBackgroundDrawable(PageFeedbackView.a(this.a).getResources().getDrawable(2130838188));
      GraphQLActionLink localGraphQLActionLink = PageFeedbackView.b(this.a).f();
      PageFeedbackView.a(this.a, PageFeedbackView.c(this.a).a(PageFeedbackView.b(this.a), localGraphQLActionLink).b());
      PageFeedbackView.d(this.a).a(new UfiEvents.PageLikeClickedEvent(PageFeedbackView.b(this.a).getCacheId(), localGraphQLActionLink.page.id));
      GraphQLProfile localGraphQLProfile = PageFeedbackView.b(this.a).f().page;
      PageFeedbackView.a(this.a, localGraphQLProfile, localGraphQLProfile.doesViewerLike);
      continue;
      this.a.setBackgroundDrawable(PageFeedbackView.a(this.a).getResources().getDrawable(2130838188));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.PageFeedbackView.1
 * JD-Core Version:    0.6.0
 */