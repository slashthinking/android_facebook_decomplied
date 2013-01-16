package com.facebook.orca.prefs;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;

class OrcaNotificationPreferenceActivity$1
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    OrcaNotificationPreferenceActivity.a(this.a).a(new HoneyClientEvent("pref_change").f(paramPreference.getKey()).b("value", paramObject.toString()));
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaNotificationPreferenceActivity.1
 * JD-Core Version:    0.6.0
 */