package com.facebook.orca.config;

import com.facebook.orca.prefs.InternalHttpPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;

class DefaultNetworkConfig$1
  implements OrcaSharedPreferences.OnSharedPreferenceChangeListener
{
  DefaultNetworkConfig$1(DefaultNetworkConfig paramDefaultNetworkConfig)
  {
  }

  public void a(OrcaSharedPreferences paramOrcaSharedPreferences, PrefKey paramPrefKey)
  {
    if ((InternalHttpPrefKeys.f.equals(paramPrefKey)) || (InternalHttpPrefKeys.g.equals(paramPrefKey)))
      DefaultNetworkConfig.a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.config.DefaultNetworkConfig.1
 * JD-Core Version:    0.6.2
 */