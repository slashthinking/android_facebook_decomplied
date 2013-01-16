package com.facebook.orca.prefs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class OrcaSharedPreferencesImpl$2 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    OrcaSharedPreferencesImpl.a(this.a, paramIntent.getStringArrayListExtra("prefs"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesImpl.2
 * JD-Core Version:    0.6.0
 */