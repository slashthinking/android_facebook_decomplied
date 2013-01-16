package com.facebook.orca.prefs;

import javax.inject.Inject;
import javax.inject.Provider;

public class IsPartialUpgradeEnabledProvider
  implements Provider<Boolean>
{
  public static final PrefKey a = GkPrefKeys.a("messenger_partial_upgrade_android");
  private final OrcaSharedPreferences b;

  @Inject
  public IsPartialUpgradeEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.b = paramOrcaSharedPreferences;
  }

  public Boolean a()
  {
    return Boolean.valueOf(this.b.a(a, false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.IsPartialUpgradeEnabledProvider
 * JD-Core Version:    0.6.0
 */