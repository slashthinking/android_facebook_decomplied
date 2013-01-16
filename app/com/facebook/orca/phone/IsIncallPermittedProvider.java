package com.facebook.orca.phone;

import com.facebook.orca.annotations.IsIncallPossible;
import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.app.IntendedAudience;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.InternalPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.users.User;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsIncallPermittedProvider
  implements Provider<Boolean>
{
  private static final PrefKey a = GkPrefKeys.a("messenger_incall_android");
  private final OrcaSharedPreferences b;
  private final OrcaAppType c;
  private final Provider<User> d;
  private final Provider<Boolean> e;

  @Inject
  public IsIncallPermittedProvider(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaAppType paramOrcaAppType, @MeUser Provider<User> paramProvider, @IsIncallPossible Provider<Boolean> paramProvider1)
  {
    this.b = paramOrcaSharedPreferences;
    this.c = paramOrcaAppType;
    this.d = paramProvider;
    this.e = paramProvider1;
  }

  public Boolean a()
  {
    if ((((Boolean)this.e.b()).booleanValue()) && (this.d.b() != null) && (this.c.h() != IntendedAudience.PUBLIC) && (this.b.a(a, false)) && (this.b.a(InternalPrefKeys.f, true)));
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.IsIncallPermittedProvider
 * JD-Core Version:    0.6.0
 */