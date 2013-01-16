package com.facebook.appcenter.ui;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;

class AppDetailFragment$8 extends SafeLocalBroadcastReceiver
{
  public void a(Context paramContext, Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str1 = localBundle.getString("appId");
    String str2 = localBundle.getString("text");
    Boolean localBoolean = Boolean.valueOf(localBundle.getBoolean("enabled"));
    if (str1.equals(AppDetailFragment.k(this.a)))
      AppDetailFragment.a(this.a, str2, localBoolean.booleanValue());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.AppDetailFragment.8
 * JD-Core Version:    0.6.0
 */