package com.facebook.orca.presence;

import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsThreadlistOnlineAndMobilePresenceEnabledProvider
  implements Provider<Boolean>
{
  private static final PrefKey a = GkPrefKeys.a("messenger_threadlist_show_mobile_presence_android");
  private final OrcaSharedPreferences b;

  @Inject
  public IsThreadlistOnlineAndMobilePresenceEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.b = paramOrcaSharedPreferences;
  }

  public Boolean a()
  {
    return Boolean.valueOf(this.b.a(a, false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.presence.IsThreadlistOnlineAndMobilePresenceEnabledProvider
 * JD-Core Version:    0.6.0
 */