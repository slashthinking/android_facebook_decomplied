package com.facebook.orca.common.diagnostics;

import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

class FbSdcardLogger$1
  implements OrcaSharedPreferences.OnSharedPreferenceChangeListener
{
  public void a(OrcaSharedPreferences paramOrcaSharedPreferences, PrefKey paramPrefKey)
  {
    if (SharedPrefKeys.j.equals(paramPrefKey))
      FbSdcardLogger.a(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.diagnostics.FbSdcardLogger.1
 * JD-Core Version:    0.6.0
 */