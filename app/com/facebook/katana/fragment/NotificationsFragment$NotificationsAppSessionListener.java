package com.facebook.katana.fragment;

import com.facebook.common.util.Toaster;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.util.StringUtils;
import com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewContainer;

class NotificationsFragment$NotificationsAppSessionListener extends AppSessionListener
{
  private NotificationsFragment$NotificationsAppSessionListener(NotificationsFragment paramNotificationsFragment)
  {
  }

  public void i(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    NotificationsFragment.f(this.a).d();
    NotificationsFragment.g(this.a);
    NotificationsFragment.h(this.a);
    if (paramInt != 200)
    {
      String str = StringUtils.a(this.a.n(), this.a.e(2131363017), paramInt, paramString2, paramException);
      Toaster.a(this.a.n(), str);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.fragment.NotificationsFragment.NotificationsAppSessionListener
 * JD-Core Version:    0.6.0
 */