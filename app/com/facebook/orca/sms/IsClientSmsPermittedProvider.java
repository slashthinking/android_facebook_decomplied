package com.facebook.orca.sms;

import com.facebook.orca.annotations.IsClientSmsPossible;
import com.facebook.orca.annotations.IsSmsOnlyModeEnabled;
import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.users.User;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsClientSmsPermittedProvider
  implements Provider<Boolean>
{
  private static final PrefKey a = GkPrefKeys.a("messenger_client_sms_android");
  private final OrcaSharedPreferences b;
  private final Provider<Boolean> c;
  private final Provider<Boolean> d;
  private final Provider<User> e;

  @Inject
  public IsClientSmsPermittedProvider(OrcaSharedPreferences paramOrcaSharedPreferences, @MeUser Provider<User> paramProvider, @IsSmsOnlyModeEnabled Provider<Boolean> paramProvider1, @IsClientSmsPossible Provider<Boolean> paramProvider2)
  {
    this.b = paramOrcaSharedPreferences;
    this.d = paramProvider1;
    this.e = paramProvider;
    this.c = paramProvider2;
  }

  public Boolean a()
  {
    boolean bool1 = true;
    boolean bool2;
    if ((this.b.a(a, false)) || (((Boolean)this.d.b()).booleanValue()))
    {
      bool2 = bool1;
      if ((!((Boolean)this.c.b()).booleanValue()) || (this.e.b() == null) || (!bool2))
        break label82;
    }
    while (true)
    {
      return Boolean.valueOf(bool1);
      bool2 = false;
      break;
      label82: bool1 = false;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.IsClientSmsPermittedProvider
 * JD-Core Version:    0.6.0
 */