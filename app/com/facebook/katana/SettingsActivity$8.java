package com.facebook.katana;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.katana.binding.ManagedDataStore.Expirer;
import java.util.Map;

class SettingsActivity$8
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    ((ManagedDataStore.Expirer)this.a.get(paramObject)).a(this.b);
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.8
 * JD-Core Version:    0.6.0
 */