package com.facebook.orca.prefs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;

class OrcaContactsPreferenceActivity$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    OrcaContactsPreferenceActivity.b(this.b).a(new HoneyClientEvent("click").d(this.b.a()).e("button").h(this.a).f("orca_preferences_delete_synced_contacts_preference_cancel"));
    paramDialogInterface.dismiss();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaContactsPreferenceActivity.2
 * JD-Core Version:    0.6.0
 */