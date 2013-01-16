package com.facebook.katana;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.common.util.Log;
import com.facebook.katana.provider.UserValuesManager;

class SettingsActivity$2
  implements Preference.OnPreferenceChangeListener
{
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    String str = paramObject.toString();
    UserValuesManager.e(this.a, str);
    Log.e("vault_settings", "vault enabled pref changed to: " + str);
    paramPreference.setSummary(SettingsActivity.a(this.a, str));
    SettingsActivity.a(this.a, paramPreference, paramObject);
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.SettingsActivity.2
 * JD-Core Version:    0.6.0
 */