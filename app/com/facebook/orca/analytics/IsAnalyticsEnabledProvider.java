package com.facebook.orca.analytics;

import com.facebook.common.util.TriState;
import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.users.User;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsAnalyticsEnabledProvider
  implements Provider<TriState>
{
  private static final PrefKey a = GkPrefKeys.a("messenger_client_analytics_android");
  private final Provider<User> b;
  private final OrcaSharedPreferences c;

  @Inject
  public IsAnalyticsEnabledProvider(@MeUser Provider<User> paramProvider, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.b = paramProvider;
    this.c = paramOrcaSharedPreferences;
  }

  public TriState a()
  {
    TriState localTriState;
    if ((User)this.b.b() == null)
      localTriState = TriState.UNSET;
    while (true)
    {
      return localTriState;
      if (this.c.a(a, false))
      {
        localTriState = TriState.YES;
        continue;
      }
      localTriState = TriState.NO;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.analytics.IsAnalyticsEnabledProvider
 * JD-Core Version:    0.6.0
 */