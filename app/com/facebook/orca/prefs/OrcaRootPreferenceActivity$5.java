package com.facebook.orca.prefs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.auth.LogoutHandler;
import com.facebook.orca.inject.FbInjector;

class OrcaRootPreferenceActivity$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    OrcaRootPreferenceActivity.b(this.b).a(new HoneyClientEvent("click").d(this.b.a()).e("button").h(this.a).f("orca_preferences_delete_account_dialog_confirm"));
    ((LogoutHandler)this.b.b().a(LogoutHandler.class)).b();
    paramDialogInterface.dismiss();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaRootPreferenceActivity.5
 * JD-Core Version:    0.6.0
 */