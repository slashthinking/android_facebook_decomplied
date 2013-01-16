package com.facebook.katana;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.common.util.NetAccessLogger;

class SettingsActivity$16
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    boolean bool = ((Boolean)paramObject).booleanValue();
    this.a.a(bool);
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.16
 * JD-Core Version:    0.6.0
 */