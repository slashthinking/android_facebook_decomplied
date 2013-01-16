package com.facebook.feed.ui.ego;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.protocol.FeedbackLoggingParams;
import com.facebook.feed.protocol.ToggleLikeParams;
import com.facebook.feed.protocol.ToggleLikeParams.Builder;
import com.facebook.feed.protocol.UFIService;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnitItem;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.util.concurrent.ListenableFuture;

class PagesYouMayLikeFeedUnitItemView$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    String str = this.a.page.id;
    UFIService localUFIService = PagesYouMayLikeFeedUnitItemView.a(this.b);
    ToggleLikeParams.Builder localBuilder = ToggleLikeParams.a().a(str);
    if (!this.a.page.doesViewerLike);
    for (boolean bool1 = true; ; bool1 = false)
    {
      ListenableFuture localListenableFuture = localUFIService.a(localBuilder.a(bool1).a(new FeedbackLoggingParams(this.a.a(), null)).a());
      GraphQLProfile localGraphQLProfile = this.a.page;
      boolean bool2 = this.a.page.doesViewerLike;
      boolean bool3 = false;
      if (!bool2)
        bool3 = true;
      localGraphQLProfile.doesViewerLike = bool3;
      PagesYouMayLikeFeedUnitItemView.a(this.b, this.a.page.doesViewerLike, true);
      PagesYouMayLikeFeedUnitItemView.b(this.b).a(localListenableFuture, new PagesYouMayLikeFeedUnitItemView.1.1(this));
      HoneyClientEvent localHoneyClientEvent = PagesYouMayLikeFeedUnitItemView.c(this.b).a(this.a.a(), this.a.page.doesViewerLike);
      PagesYouMayLikeFeedUnitItemView.d(this.b).b(localHoneyClientEvent);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.ego.PagesYouMayLikeFeedUnitItemView.1
 * JD-Core Version:    0.6.0
 */