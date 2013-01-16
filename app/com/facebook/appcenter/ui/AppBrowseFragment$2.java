package com.facebook.appcenter.ui;

import com.facebook.appcenter.data.AppCenterCategoryCollection;
import com.facebook.appcenter.data.LoadingStatus;
import com.facebook.appcenter.protocol.FetchAppCategoryResult;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;

class AppBrowseFragment$2
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    AppBrowseFragment.a(this.a, null);
    AppBrowseFragment.a(this.a, (FetchAppCategoryResult)paramOperationResult.h());
    Preconditions.checkNotNull(AppBrowseFragment.e(this.a));
    List localList = AppBrowseFragment.e(this.a).a();
    AppCenterCategoryCollection localAppCenterCategoryCollection = new AppCenterCategoryCollection();
    Preconditions.checkNotNull(localList);
    localAppCenterCategoryCollection.a(localList);
    AppBrowseFragment.d(this.a).a(localAppCenterCategoryCollection);
    AppBrowseFragment.d(this.a).setVisibility(0);
    AppBrowseFragment.a(this.a, LoadingStatus.SUCCESS, "list_categories");
  }

  public void a(Throwable paramThrowable)
  {
    AppBrowseFragment.a(this.a, null);
    AppBrowseFragment.a(this.a, null);
    AppBrowseFragment.d(this.a).setVisibility(8);
    AppBrowseFragment.a(this.a, LoadingStatus.FAIL, "list_categories");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppBrowseFragment.2
 * JD-Core Version:    0.6.0
 */