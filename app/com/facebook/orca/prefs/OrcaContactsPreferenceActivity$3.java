package com.facebook.orca.prefs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.google.common.util.concurrent.Futures;

class OrcaContactsPreferenceActivity$3
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    OrcaContactsPreferenceActivity.b(this.b).a(new HoneyClientEvent("click").d(this.b.a()).e("button").h(this.a).f("orca_preferences_delete_synced_contacts_preference_confirm"));
    if (OrcaContactsPreferenceActivity.c(this.b) != OrcaContactsPreferenceActivity.DeleteContactsPreferenceState.NOT_STARTED)
      paramDialogInterface.dismiss();
    OrcaContactsPreferenceActivity.a(this.b, OrcaContactsPreferenceActivity.DeleteContactsPreferenceState.IN_PROGRESS);
    OrcaContactsPreferenceActivity.a(this.b, OrcaContactsPreferenceActivity.d(this.b).a("bulk_contacts_delete", new Bundle()).d());
    Futures.a(OrcaContactsPreferenceActivity.e(this.b), new OrcaContactsPreferenceActivity.3.1(this), OrcaContactsPreferenceActivity.f(this.b));
    paramDialogInterface.dismiss();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaContactsPreferenceActivity.3
 * JD-Core Version:    0.6.0
 */