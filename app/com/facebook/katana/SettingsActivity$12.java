package com.facebook.katana;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.analytics.performance.PerformanceLogger;

class SettingsActivity$12
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    this.a.a(((Boolean)paramObject).booleanValue());
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.12
 * JD-Core Version:    0.6.0
 */