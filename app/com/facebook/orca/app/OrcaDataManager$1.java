package com.facebook.orca.app;

import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

class OrcaDataManager$1
  implements OrcaSharedPreferences.OnSharedPreferenceChangeListener
{
  public void a(OrcaSharedPreferences paramOrcaSharedPreferences, PrefKey paramPrefKey)
  {
    if ((SharedPrefKeys.i.equals(paramPrefKey)) || (SharedPrefKeys.j.equals(paramPrefKey)))
      OrcaDataManager.a(this.a);
    while (true)
    {
      return;
      if (MessagesPrefKeys.g.equals(paramPrefKey))
      {
        OrcaDataManager.b(this.a);
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.OrcaDataManager.1
 * JD-Core Version:    0.6.0
 */