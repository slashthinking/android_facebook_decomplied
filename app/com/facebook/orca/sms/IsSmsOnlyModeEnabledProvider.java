package com.facebook.orca.sms;

import com.facebook.orca.prefs.MessagesPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsSmsOnlyModeEnabledProvider
  implements Provider<Boolean>
{
  private final OrcaSharedPreferences a;

  @Inject
  public IsSmsOnlyModeEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramOrcaSharedPreferences;
  }

  public Boolean a()
  {
    if (this.a.a());
    for (Boolean localBoolean = Boolean.valueOf(this.a.a(MessagesPrefKeys.j, false)); ; localBoolean = Boolean.valueOf(false))
      return localBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.IsSmsOnlyModeEnabledProvider
 * JD-Core Version:    0.6.0
 */