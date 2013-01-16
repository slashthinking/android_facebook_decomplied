package com.facebook.orca.contacts.providers;

import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsDisplayGroupsInDivebarEnabledProvider
  implements Provider<Boolean>
{
  private static final PrefKey b = GkPrefKeys.a("messenger_divebar_show_groups_android");
  private final OrcaSharedPreferences a;

  @Inject
  public IsDisplayGroupsInDivebarEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramOrcaSharedPreferences;
  }

  public Boolean a()
  {
    return Boolean.valueOf(this.a.a(b, false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.providers.IsDisplayGroupsInDivebarEnabledProvider
 * JD-Core Version:    0.6.0
 */