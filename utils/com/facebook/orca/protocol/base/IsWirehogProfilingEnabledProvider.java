package com.facebook.orca.protocol.base;

import com.facebook.orca.prefs.InternalHttpPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsWirehogProfilingEnabledProvider
  implements Provider<Boolean>
{
  private final OrcaSharedPreferences a;

  @Inject
  public IsWirehogProfilingEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramOrcaSharedPreferences;
  }

  public Boolean a()
  {
    return Boolean.valueOf(this.a.a(InternalHttpPrefKeys.c, false));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.IsWirehogProfilingEnabledProvider
 * JD-Core Version:    0.6.2
 */