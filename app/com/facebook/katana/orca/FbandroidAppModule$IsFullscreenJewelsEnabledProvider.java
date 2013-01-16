package com.facebook.katana.orca;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class FbandroidAppModule$IsFullscreenJewelsEnabledProvider extends AbstractProvider<Boolean>
{
  public Boolean a()
  {
    return Boolean.valueOf(((OrcaSharedPreferences)b(OrcaSharedPreferences.class)).a(FbandroidPrefKeys.c, true));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.IsFullscreenJewelsEnabledProvider
 * JD-Core Version:    0.6.0
 */