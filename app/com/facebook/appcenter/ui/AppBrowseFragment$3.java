package com.facebook.appcenter.ui;

import com.facebook.appcenter.data.LoadingStatus;
import com.facebook.appcenter.protocol.FetchAppListResult;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;

class AppBrowseFragment$3
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    AppBrowseFragment.b(this.a, null);
    AppBrowseFragment.a(this.a, (FetchAppListResult)paramOperationResult.h());
    Preconditions.checkNotNull(AppBrowseFragment.f(this.a));
    List localList = AppBrowseFragment.f(this.a).b();
    AppBrowseFragment.a(this.a, localList);
    AppBrowseFragment.a(this.a, LoadingStatus.SUCCESS, "list_featured_apps");
  }

  public void a(Throwable paramThrowable)
  {
    AppBrowseFragment.b(this.a, null);
    AppBrowseFragment.a(this.a, null);
    AppBrowseFragment.a(this.a, LoadingStatus.FAIL, "list_featured_apps");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppBrowseFragment.3
 * JD-Core Version:    0.6.0
 */