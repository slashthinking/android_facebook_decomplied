package com.facebook.orca.prefs;

import android.content.IntentFilter;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.contacts.upload.ContactsUploadRunner;

class OrcaContactsPreferenceActivity$4
  implements Preference.OnPreferenceClickListener
{
  public boolean onPreferenceClick(Preference paramPreference)
  {
    OrcaContactsPreferenceActivity.b(this.a).a(new HoneyClientEvent("click").d(this.a.a()).e("button").f("orca_preferences_manual_contacts_sync_preference"));
    OrcaContactsPreferenceActivity.4.1 local1 = new OrcaContactsPreferenceActivity.4.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED");
    OrcaContactsPreferenceActivity.g(this.a).a(local1, localIntentFilter);
    OrcaContactsPreferenceActivity.a(this.a, OrcaContactsPreferenceActivity.h(this.a).c());
    OrcaContactsPreferenceActivity.h(this.a).a();
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaContactsPreferenceActivity.4
 * JD-Core Version:    0.6.0
 */