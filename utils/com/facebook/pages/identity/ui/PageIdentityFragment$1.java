package com.facebook.pages.identity.ui;

import android.widget.Toast;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.graphql.model.GraphQueryResultEntry;
import com.facebook.orca.ops.OperationResultFutureCallback;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.server.OperationResult;
import com.facebook.pages.identity.analytics.PageIdentityAnalytics;
import com.facebook.pages.identity.data.PageIdentityData;
import com.facebook.pages.identity.ui.about.PageAboutFragment;

class PageIdentityFragment$1 extends OperationResultFutureCallback
{
  PageIdentityFragment$1(PageIdentityFragment paramPageIdentityFragment)
  {
  }

  protected void a(ServiceException paramServiceException)
  {
    PageIdentityFragment.d(this.a).a(false);
    Toast.makeText(this.a.p(), 2131361881, 1).show();
    PageIdentityFragment.c(this.a).b(PageIdentityFragment.a(this.a), PageIdentityFragment.b(this.a));
    PageIdentityFragment.e(this.a).a("page_identity_data_fetch_fail", paramServiceException.getMessage(), paramServiceException, false);
  }

  public void a(OperationResult paramOperationResult)
  {
    PageIdentityFragment.c(this.a).a(PageIdentityFragment.a(this.a), PageIdentityFragment.b(this.a));
    GraphQueryResultEntry localGraphQueryResultEntry = (GraphQueryResultEntry)paramOperationResult.h();
    PageIdentityFragment.a(this.a, new PageIdentityData(PageIdentityFragment.a(this.a), localGraphQueryResultEntry));
    PageIdentityFragment.d(this.a).a(false);
    this.a.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageIdentityFragment.1
 * JD-Core Version:    0.6.2
 */