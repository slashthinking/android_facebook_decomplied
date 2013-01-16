package com.facebook.feed.flyout;

import android.view.View;
import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;

class FeedFlyoutFragment$5
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    FeedFlyoutFragment.c(this.b).b(this.a);
    FeedFlyoutFragment.b(this.b, false);
    FetchFeedbackResult localFetchFeedbackResult = (FetchFeedbackResult)paramOperationResult.h();
    if ((localFetchFeedbackResult == null) || (localFetchFeedbackResult.a == null));
    while (true)
    {
      return;
      Feedback localFeedback = localFetchFeedbackResult.a;
      FeedFlyoutFragment.d(this.b, localFeedback);
      this.b.a(localFeedback, FeedFlyoutFragment.f(this.b).f);
      FeedFlyoutFragment.j(this.b).setVisibility(8);
      FeedFlyoutFragment.e(this.b, localFeedback);
    }
  }

  public void a(Throwable paramThrowable)
  {
    FeedFlyoutFragment.c(this.b).b(this.a);
    FeedFlyoutFragment.a(this.b, "FeedFlyoutFetchNewCommentsFailed", paramThrowable);
    FeedFlyoutFragment.b(this.b, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.5
 * JD-Core Version:    0.6.0
 */