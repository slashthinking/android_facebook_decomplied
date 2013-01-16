package com.facebook.appcenter.ui;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.net.OrcaNetworkManager;

class AppDetailFragment$2 extends SafeLocalBroadcastReceiver
{
  public void a(Context paramContext, Intent paramIntent)
  {
    if ((AppDetailFragment.c(this.a).b()) && (AppDetailFragment.d(this.a).getVisibility() == 0))
    {
      AppDetailFragment.d(this.a).setVisibility(8);
      AppDetailFragment.e(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppDetailFragment.2
 * JD-Core Version:    0.6.0
 */