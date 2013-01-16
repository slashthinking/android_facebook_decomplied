package com.facebook.katana;

import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;

class SettingsActivity$3
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    boolean bool = ((Boolean)paramObject).booleanValue();
    this.a.setEnabled(bool);
    this.b.setEnabled(bool);
    SettingsActivity.a(this.c, paramPreference, paramObject);
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.3
 * JD-Core Version:    0.6.0
 */