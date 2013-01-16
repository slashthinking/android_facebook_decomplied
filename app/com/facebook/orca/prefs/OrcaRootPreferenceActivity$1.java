package com.facebook.orca.prefs;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.orca.inject.FbInjector;

class OrcaRootPreferenceActivity$1
  implements Preference.OnPreferenceClickListener
{
  public boolean onPreferenceClick(Preference paramPreference)
  {
    ((AboutHandler)this.a.b().a(AboutHandler.class)).a();
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaRootPreferenceActivity.1
 * JD-Core Version:    0.6.0
 */