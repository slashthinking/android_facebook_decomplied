package com.facebook.feed.flyout;

import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.cache.PendingFeedbackCache;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;

class FeedFlyoutFragment$9
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    FeedFlyoutFragment.c(this.d).b(this.a);
    FeedFlyoutFragment.l(this.d).a(this.b, paramOperationResult.f());
    FeedFlyoutFragment.m(this.d).notifyDataSetChanged();
    FeedFlyoutFragment.p(this.d);
    FeedFlyoutFragment.n(this.d);
    FeedFlyoutFragment.q(this.d).setVisibility(8);
    if (FeedFlyoutFragment.o(this.d) != null)
      FeedFlyoutFragment.o(this.d).setSelection(-1 + FeedFlyoutFragment.m(this.d).getCount());
  }

  public void a(Throwable paramThrowable)
  {
    FeedFlyoutFragment.c(this.d).b(this.a);
    FeedFlyoutFragment.a(this.d, "FeedFlyoutPostCommentFailed", paramThrowable);
    FeedFlyoutFragment.l(this.d).b(this.b);
    FeedFlyoutFragment.m(this.d).notifyDataSetChanged();
    HoneyClientEvent localHoneyClientEvent = FeedFlyoutFragment.a(this.d).a("comment_failure_flyout", this.c);
    FeedFlyoutFragment.b(this.d).a(localHoneyClientEvent);
    FeedFlyoutFragment.n(this.d);
    if (FeedFlyoutFragment.o(this.d) != null)
      FeedFlyoutFragment.o(this.d).setSelection(-1 + FeedFlyoutFragment.m(this.d).getCount());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.9
 * JD-Core Version:    0.6.0
 */