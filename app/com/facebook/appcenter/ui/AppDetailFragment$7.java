package com.facebook.appcenter.ui;

import android.widget.Button;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.protocol.FetchAppDetailResult;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class AppDetailFragment$7
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    try
    {
      Thread.sleep(250L);
      label6: AppDetailFragment.b(this.a, null);
      AppDetail localAppDetail = AppDetailFragment.f(this.a).a();
      AppDetailFragment.b(this.a, localAppDetail.mobileCanvasUrl);
      AppDetailFragment.j(this.a);
      return;
    }
    catch (Exception localException)
    {
      break label6;
    }
  }

  public void a(Throwable paramThrowable)
  {
    AppDetailFragment.b(this.a, null);
    AppDetailFragment.i(this.a).setText(AppDetailFragment.h(this.a));
    AppDetailFragment.i(this.a).setEnabled(true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppDetailFragment.7
 * JD-Core Version:    0.6.0
 */