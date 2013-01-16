package com.facebook.orca.presence;

import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.push.prefs.PushPrefKeys;

class PresenceManager$2
  implements OrcaSharedPreferences.OnSharedPreferenceChangeListener
{
  public void a(OrcaSharedPreferences paramOrcaSharedPreferences, PrefKey paramPrefKey)
  {
    if ((PresenceManager.i().equals(paramPrefKey)) || (PushPrefKeys.a.equals(paramPrefKey)))
      PresenceManager.b(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.presence.PresenceManager.2
 * JD-Core Version:    0.6.0
 */