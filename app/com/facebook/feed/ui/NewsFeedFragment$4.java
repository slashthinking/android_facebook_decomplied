package com.facebook.feed.ui;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.data.PagedFeedUnitCollection;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;

class NewsFeedFragment$4 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    NewsFeedFragment.a(this.d).b(this.a);
    this.d.ad.a(this.b);
    this.d.i.a(this.d.h.a("newsfeed_page_like_fail", this.c.b(), String.valueOf(this.c.doesViewerLike)));
  }

  public void a(OperationResult paramOperationResult)
  {
    NewsFeedFragment.a(this.d).b(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedFragment.4
 * JD-Core Version:    0.6.0
 */