package com.facebook.feed.flyout;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.data.FeedbackMutator;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FlyoutEvents.LikeClickedEvent;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileCache;
import com.facebook.orca.inject.FbInjector;

class FeedFlyoutHeaderView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    GraphQLProfile localGraphQLProfile = ((GraphQLProfileCache)FeedFlyoutHeaderView.a(this.a).a(GraphQLProfileCache.class)).a();
    FeedFlyoutHeaderView.a(this.a, FeedFlyoutHeaderView.c(this.a).a(FeedFlyoutHeaderView.b(this.a), localGraphQLProfile));
    FeedFlyoutHeaderView.d(this.a);
    FeedFlyoutHeaderView.e(this.a).a(new FlyoutEvents.LikeClickedEvent(FeedFlyoutHeaderView.b(this.a)));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutHeaderView.1
 * JD-Core Version:    0.6.0
 */