package com.facebook.orca.sms;

import com.facebook.orca.annotations.IsClientSmsPermitted;
import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsClientSmsEnabledProvider
  implements Provider<Boolean>
{
  private final OrcaSharedPreferences a;
  private final Provider<Boolean> b;

  @Inject
  public IsClientSmsEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences, @IsClientSmsPermitted Provider<Boolean> paramProvider)
  {
    this.a = paramOrcaSharedPreferences;
    this.b = paramProvider;
  }

  public Boolean a()
  {
    if ((((Boolean)this.b.b()).booleanValue()) && (this.a.a(MessagesPrefKeys.g, false)) && (this.a.a(MessagesPrefKeys.f, true)));
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.IsClientSmsEnabledProvider
 * JD-Core Version:    0.6.0
 */