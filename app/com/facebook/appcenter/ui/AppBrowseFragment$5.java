package com.facebook.appcenter.ui;

import android.widget.ListView;
import com.facebook.appcenter.data.LoadingStatus;
import com.facebook.appcenter.protocol.FetchAppListResult;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;

class AppBrowseFragment$5
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    AppBrowseFragment.c(this.a, null);
    AppBrowseFragment.b(this.a, (FetchAppListResult)paramOperationResult.h());
    Preconditions.checkNotNull(AppBrowseFragment.g(this.a));
    List localList = AppBrowseFragment.g(this.a).b();
    AppBrowseListAdapter localAppBrowseListAdapter = ((AppCenterAdapterFactory)this.a.R().a(AppCenterAdapterFactory.class)).a(AppBrowseFragment.g(this.a).b());
    Preconditions.checkNotNull(localList);
    AppBrowseFragment.h(this.a).setAdapter(localAppBrowseListAdapter);
    AppBrowseFragment.a(this.a, LoadingStatus.SUCCESS, "list_all_apps");
  }

  public void a(Throwable paramThrowable)
  {
    AppBrowseFragment.c(this.a, null);
    AppBrowseFragment.b(this.a, null);
    AppBrowseFragment.a(this.a, LoadingStatus.FAIL, "list_all_apps");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppBrowseFragment.5
 * JD-Core Version:    0.6.0
 */