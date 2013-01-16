package com.facebook.feed.ui.permalink;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;

class PermalinkFragment$8 extends OperationResultFutureCallback
{
  protected void a(ServiceException paramServiceException)
  {
    PermalinkFragment.b(this.e).b(this.a);
    PermalinkFragment.c(this.e, this.b);
    PermalinkFragment.k(this.e).a(PermalinkFragment.e(this.e));
    PermalinkFragment.g(this.e).a(PermalinkFragment.f(this.e).a(this.c + "_failed", this.d.legacyApiPostId, String.valueOf(this.d.doesViewerLike)));
  }

  public void a(OperationResult paramOperationResult)
  {
    PermalinkFragment.b(this.e).b(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.8
 * JD-Core Version:    0.6.0
 */