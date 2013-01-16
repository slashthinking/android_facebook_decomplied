package com.facebook.katana;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.SharedPrefKeys;

class SettingsActivity$14
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    this.a.b().a(SharedPrefKeys.m, 1000L * Long.parseLong((String)paramObject)).a();
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.14
 * JD-Core Version:    0.6.0
 */