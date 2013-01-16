package com.facebook.orca.prefs;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

class OrcaSharedPreferencesImpl$1
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    OrcaSharedPreferencesImpl.a(this.a, paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaSharedPreferencesImpl.1
 * JD-Core Version:    0.6.0
 */