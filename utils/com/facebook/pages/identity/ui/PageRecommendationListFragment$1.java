package com.facebook.pages.identity.ui;

import android.widget.Toast;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.facebook.pages.identity.data.PageRecommendationData;
import com.google.common.base.Preconditions;

class PageRecommendationListFragment$1 extends OperationResultFutureCallback
{
  PageRecommendationListFragment$1(PageRecommendationListFragment paramPageRecommendationListFragment, boolean paramBoolean)
  {
  }

  protected void a(ServiceException paramServiceException)
  {
    if (this.a);
    for (String str = "page_identity_friend_recommendations_fetch_fail"; ; str = "page_identity_recommendations_fetch_fail")
    {
      Toast.makeText(this.b.p(), 2131361884, 1).show();
      PageRecommendationListFragment.a(this.b).a(str, paramServiceException.getMessage(), paramServiceException, false);
      return;
    }
  }

  public void a(OperationResult paramOperationResult)
  {
    Preconditions.checkNotNull(paramOperationResult);
    GraphQueryResultEntry localGraphQueryResultEntry = (GraphQueryResultEntry)paramOperationResult.h();
    PageRecommendationListFragment.a(this.b, PageRecommendationData.a(localGraphQueryResultEntry), this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageRecommendationListFragment.1
 * JD-Core Version:    0.6.2
 */