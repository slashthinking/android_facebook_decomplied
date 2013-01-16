package com.facebook.feed.ui.permalink;

import com.facebook.feed.data.PagedCommentCollection;
import com.facebook.feed.protocol.FetchFeedbackResult;
import com.facebook.feed.ui.FeedFragmentOperationsManager;
import com.facebook.graphql.model.FeedStoryComments;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;

class PermalinkFragment$6 extends OperationResultFutureCallback
{
  public void a(ServiceException paramServiceException)
  {
    PermalinkFragment.b(this.c).b(this.a);
    PermalinkFragment.a(this.c, paramServiceException, PermalinkFragment.ErrorBannerType.COMMENT_FETCH_FAILED);
    PermalinkFragment.i(this.c);
    PermalinkFragment.j(this.c).d();
  }

  public void a(OperationResult paramOperationResult)
  {
    PermalinkFragment.b(this.c).b(this.a);
    PermalinkFragment.c(this.c, false);
    if (PermalinkFragment.k(this.c) != null)
    {
      PermalinkFragment.k(this.c).a(false);
      PermalinkFragment.k(this.c).notifyDataSetChanged();
    }
    FetchFeedbackResult localFetchFeedbackResult = (FetchFeedbackResult)paramOperationResult.h();
    if ((localFetchFeedbackResult == null) || (localFetchFeedbackResult.a == null) || (localFetchFeedbackResult.a.comments == null))
      return;
    FeedStoryComments localFeedStoryComments = localFetchFeedbackResult.a.comments;
    if ((localFeedStoryComments != null) && (localFeedStoryComments.pageInfo != null))
    {
      if (!this.b)
        break label197;
      PermalinkFragment.l(this.c).a(new ArrayList(localFeedStoryComments.comments), localFeedStoryComments.pageInfo);
    }
    while (true)
    {
      PermalinkFragment.k(this.c).a(localFetchFeedbackResult.a);
      if (!this.b)
        PermalinkFragment.a(this.c, localFeedStoryComments.comments.size(), localFeedStoryComments.pageInfo.hasNextPage);
      PermalinkFragment.j(this.c).d();
      break;
      label197: PermalinkFragment.l(this.c).b(new ArrayList(localFeedStoryComments.comments), localFeedStoryComments.pageInfo);
    }
  }

  public void a(CancellationException paramCancellationException)
  {
    PermalinkFragment.i(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.permalink.PermalinkFragment.6
 * JD-Core Version:    0.6.0
 */