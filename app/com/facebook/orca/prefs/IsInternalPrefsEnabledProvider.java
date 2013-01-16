package com.facebook.orca.prefs;

import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.app.IntendedAudience;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.User;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsInternalPrefsEnabledProvider extends AbstractProvider<Boolean>
{
  private static final PrefKey a = GkPrefKeys.a("messenger_internal_prefs_android");
  private final OrcaSharedPreferences b;
  private final OrcaAppType c;
  private final Provider<User> d;

  @Inject
  public IsInternalPrefsEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaAppType paramOrcaAppType, @MeUser Provider<User> paramProvider)
  {
    this.b = paramOrcaSharedPreferences;
    this.c = paramOrcaAppType;
    this.d = paramProvider;
  }

  public Boolean a()
  {
    User localUser = (User)this.d.b();
    Boolean localBoolean;
    if (localUser == null)
      localBoolean = Boolean.valueOf(false);
    while (true)
    {
      return localBoolean;
      if (this.c.h() == IntendedAudience.PUBLIC)
      {
        localBoolean = Boolean.valueOf(localUser.x());
        continue;
      }
      localBoolean = Boolean.valueOf(this.b.a(a, false));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.IsInternalPrefsEnabledProvider
 * JD-Core Version:    0.6.0
 */