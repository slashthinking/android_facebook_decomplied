package com.facebook.orca.sms;

import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.orca.prefs.PrefKey;

class MmsSmsLogger$1
  implements OrcaSharedPreferences.OnSharedPreferenceChangeListener
{
  public void a(OrcaSharedPreferences paramOrcaSharedPreferences, PrefKey paramPrefKey)
  {
    if ((MessagesPrefKeys.i.equals(paramPrefKey)) || (MessagesPrefKeys.g.equals(paramPrefKey)))
    {
      boolean bool1 = paramOrcaSharedPreferences.a(MessagesPrefKeys.g, false);
      boolean bool2 = paramOrcaSharedPreferences.a(MessagesPrefKeys.g);
      boolean bool3 = paramOrcaSharedPreferences.a(MessagesPrefKeys.i, true);
      boolean bool4 = paramOrcaSharedPreferences.a(MessagesPrefKeys.i);
      this.a.a(bool1, bool2, bool3, bool4);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSmsLogger.1
 * JD-Core Version:    0.6.0
 */