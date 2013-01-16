package com.facebook.feed.flyout;

import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;

class FeedFlyoutFragment$3
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    FeedFlyoutFragment.c(this.b).b(this.a);
    FeedFlyoutFragment.a(this.b, FeedFlyoutFragment.e(this.b).a());
    FeedFlyoutFragment.a(this.b, false);
    FetchFeedbackResult localFetchFeedbackResult = (FetchFeedbackResult)paramOperationResult.h();
    FeedFlyoutFragment.b(this.b, localFetchFeedbackResult.a);
  }

  public void a(Throwable paramThrowable)
  {
    FeedFlyoutFragment.c(this.b).b(this.a);
    FeedFlyoutFragment.a(this.b, "FeedFlyoutFetchLikersFailed", paramThrowable);
    FeedFlyoutFragment.a(this.b, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.3
 * JD-Core Version:    0.6.0
 */