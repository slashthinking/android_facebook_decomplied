package com.facebook.debug;

import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

class UiThreadWatchdog$2
  implements OrcaSharedPreferences.OnSharedPreferenceChangeListener
{
  UiThreadWatchdog$2(UiThreadWatchdog paramUiThreadWatchdog)
  {
  }

  public void a(OrcaSharedPreferences paramOrcaSharedPreferences, PrefKey paramPrefKey)
  {
    if (SharedPrefKeys.q.equals(paramPrefKey))
      UiThreadWatchdog.a(this.a, UiThreadWatchdog.b(this.a).a(SharedPrefKeys.q, false));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.debug.UiThreadWatchdog.2
 * JD-Core Version:    0.6.2
 */