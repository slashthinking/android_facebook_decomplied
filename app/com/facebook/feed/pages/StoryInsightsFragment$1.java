package com.facebook.feed.pages;

import android.content.res.Resources;
import android.view.View;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLStoryInsights;
import com.facebook.orca.server.OperationResult;
import com.facebook.pages.data.model.StoryInsightsDetailItem;
import com.facebook.pages.data.server.FetchStoryInsightsResult;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;

class StoryInsightsFragment$1
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    StoryInsightsFragment.a(this.a).setVisibility(8);
    Feedback localFeedback = ((FetchStoryInsightsResult)paramOperationResult.h()).feedback;
    GraphQLStoryInsights localGraphQLStoryInsights = ((FetchStoryInsightsResult)paramOperationResult.h()).insights;
    long l1 = Math.max(Math.max(localFeedback.a(), localFeedback.b()), localFeedback.c());
    long l2 = Math.max(Math.max(localGraphQLStoryInsights.organicReach, localGraphQLStoryInsights.paidReach), localGraphQLStoryInsights.viralReach);
    Resources localResources = this.a.q();
    StoryInsightsDetailItem localStoryInsightsDetailItem1 = new StoryInsightsDetailItem(localResources.getString(2131362147));
    StoryInsightsDetailItem localStoryInsightsDetailItem2 = new StoryInsightsDetailItem(l1, localFeedback.b(), localResources.getColor(2131165297), localResources.getString(2131362153));
    StoryInsightsDetailItem localStoryInsightsDetailItem3 = new StoryInsightsDetailItem(l1, localFeedback.a(), localResources.getColor(2131165298), localResources.getString(2131362154));
    StoryInsightsDetailItem localStoryInsightsDetailItem4 = new StoryInsightsDetailItem(l1, localFeedback.c(), localResources.getColor(2131165299), localResources.getString(2131362152));
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(localGraphQLStoryInsights.totalReach);
    ImmutableList localImmutableList = ImmutableList.a(localStoryInsightsDetailItem1, localStoryInsightsDetailItem2, localStoryInsightsDetailItem3, localStoryInsightsDetailItem4, new StoryInsightsDetailItem(localResources.getString(2131362148, arrayOfObject)), new StoryInsightsDetailItem(l2, localGraphQLStoryInsights.organicReach, localResources.getColor(2131165300), localResources.getString(2131362149)), new StoryInsightsDetailItem(l2, localGraphQLStoryInsights.paidReach, localResources.getColor(2131165301), localResources.getString(2131362150)), new StoryInsightsDetailItem(l2, localGraphQLStoryInsights.viralReach, localResources.getColor(2131165302), localResources.getString(2131362151)));
    StoryInsightsFragment.b(this.a).a(localImmutableList);
    StoryInsightsFragment.b(this.a).notifyDataSetChanged();
  }

  public void a(Throwable paramThrowable)
  {
    StoryInsightsFragment.a(this.a).setVisibility(8);
    StoryInsightsFragment.a(this.a, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.pages.StoryInsightsFragment.1
 * JD-Core Version:    0.6.0
 */