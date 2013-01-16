package com.facebook.appcenter.ui;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.net.OrcaNetworkManager;

class AppBrowseFragment$1 extends SafeLocalBroadcastReceiver
{
  public void a(Context paramContext, Intent paramIntent)
  {
    if ((AppBrowseFragment.a(this.a).b()) && (AppBrowseFragment.b(this.a).getVisibility() == 0))
    {
      AppBrowseFragment.b(this.a).setVisibility(8);
      AppBrowseFragment.c(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppBrowseFragment.1
 * JD-Core Version:    0.6.0
 */