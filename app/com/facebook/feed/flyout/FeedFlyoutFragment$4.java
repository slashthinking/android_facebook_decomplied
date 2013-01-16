package com.facebook.feed.flyout;

import com.facebook.feed.data.AppendOnlyGraphQLObjectCollection;
import com.facebook.feed.data.PagedCommentCollection;
import com.facebook.feed.protocol.FetchSingleMediaResult;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;

class FeedFlyoutFragment$4
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    FeedFlyoutFragment.c(this.b).b(this.a);
    FeedFlyoutFragment.a(this.b, FeedFlyoutFragment.e(this.b).a());
    FeedFlyoutFragment.a(this.b, false);
    FeedFlyoutFragment.b(this.b, false);
    FetchSingleMediaResult localFetchSingleMediaResult = (FetchSingleMediaResult)paramOperationResult.h();
    FeedFlyoutFragment.a(this.b, localFetchSingleMediaResult.a.S());
    FeedFlyoutFragment.g(this.b).d();
    FeedFlyoutFragment.h(this.b).f();
    FeedFlyoutFragment.b(this.b, FeedFlyoutFragment.i(this.b));
    FeedFlyoutFragment.c(this.b, FeedFlyoutFragment.i(this.b));
  }

  public void a(Throwable paramThrowable)
  {
    FeedFlyoutFragment.c(this.b).b(this.a);
    FeedFlyoutFragment.a(this.b, "FeedFlyoutFetchFeedbackWithPhotoIdFailed", paramThrowable);
    FeedFlyoutFragment.a(this.b, false);
    FeedFlyoutFragment.b(this.b, false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.flyout.FeedFlyoutFragment.4
 * JD-Core Version:    0.6.0
 */