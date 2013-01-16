package com.facebook.orca.auth;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.AuthPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import javax.inject.Inject;

public class IsPartialAccountProvider extends AbstractProvider<Boolean>
{
  private final AuthDataStore a;
  private final OrcaSharedPreferences b;

  @Inject
  public IsPartialAccountProvider(AuthDataStore paramAuthDataStore, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramAuthDataStore;
    this.b = paramOrcaSharedPreferences;
  }

  public Boolean a()
  {
    boolean bool1 = this.a.e();
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = this.b.a(AuthPrefKeys.f, false);
      bool2 = false;
      if (bool3)
        bool2 = true;
    }
    return Boolean.valueOf(bool2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.auth.IsPartialAccountProvider
 * JD-Core Version:    0.6.0
 */