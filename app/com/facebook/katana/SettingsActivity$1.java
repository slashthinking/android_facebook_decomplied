package com.facebook.katana;

import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;

class SettingsActivity$1
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    ((ListPreference)paramPreference).setSummary(SettingsActivity.a(this.c, this.a, this.b, (String)paramObject));
    this.c.d = true;
    SettingsActivity.a(this.c, paramPreference, paramObject);
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.1
 * JD-Core Version:    0.6.0
 */