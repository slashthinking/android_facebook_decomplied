package com.facebook.appcenter.ui;

import com.facebook.appcenter.cache.AppServerStateCache;
import com.facebook.appcenter.data.LoadingStatus;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.model.AppInfo.AppServerState;
import com.facebook.appcenter.protocol.FetchAppDetailResult;
import com.facebook.appcenter.workflow.AppWorkflowManager;
import com.facebook.common.util.Log;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;

class AppDetailFragment$4
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    AppDetailFragment.a(this.a, null);
    AppDetailFragment.a(this.a, (FetchAppDetailResult)paramOperationResult.h());
    Preconditions.checkNotNull(AppDetailFragment.f(this.a));
    AppDetail localAppDetail = AppDetailFragment.f(this.a).a();
    Preconditions.checkNotNull(localAppDetail);
    AppDetailFragment.a(this.a, localAppDetail);
    ((AppServerStateCache)this.a.R().a(AppServerStateCache.class)).a(AppDetailFragment.b(), new AppInfo.AppServerState(true, true, false));
    if (AppWorkflowManager.a)
      AppDetailFragment.g(this.a).a(AppDetailFragment.b(), false);
    AppDetailFragment.a(this.a, LoadingStatus.SUCCESS, -1);
  }

  public void a(Throwable paramThrowable)
  {
    Log.a(AppDetailFragment.a(), "Fetch app detail failed: " + paramThrowable);
    AppDetailFragment.a(this.a, null);
    AppDetailFragment.a(this.a, null);
    AppDetailFragment.a(this.a, LoadingStatus.FAIL, 2131362196);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppDetailFragment.4
 * JD-Core Version:    0.6.0
 */