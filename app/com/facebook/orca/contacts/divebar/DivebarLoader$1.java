package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.debug.BLog;

class DivebarLoader$1 extends SafeLocalBroadcastReceiver
{
  public void a(Context paramContext, Intent paramIntent)
  {
    BLog.b("orca:FriendListsLoader", "friendsBroadcastReceiver : " + paramIntent.getAction());
    this.a.w();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarLoader.1
 * JD-Core Version:    0.6.0
 */