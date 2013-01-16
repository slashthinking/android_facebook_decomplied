package com.facebook.orca.users;

import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsMoreLastActiveEnabledProvider
  implements Provider<Boolean>
{
  public static final PrefKey a = GkPrefKeys.a("messenger_divebar_more_last_active_android");
  private final OrcaSharedPreferences b;
  private final OrcaAppType c;

  @Inject
  public IsMoreLastActiveEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaAppType paramOrcaAppType)
  {
    this.b = paramOrcaSharedPreferences;
    this.c = paramOrcaAppType;
  }

  public Boolean a()
  {
    return Boolean.valueOf(this.b.a(a, false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.IsMoreLastActiveEnabledProvider
 * JD-Core Version:    0.6.0
 */