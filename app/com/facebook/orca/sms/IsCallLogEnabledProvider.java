package com.facebook.orca.sms;

import com.facebook.orca.annotations.IsClientSmsPermitted;
import com.facebook.orca.app.OrcaAppType;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsCallLogEnabledProvider
  implements Provider<Boolean>
{
  private final OrcaAppType a;
  private final Provider<Boolean> b;

  @Inject
  public IsCallLogEnabledProvider(OrcaAppType paramOrcaAppType, @IsClientSmsPermitted Provider<Boolean> paramProvider)
  {
    this.a = paramOrcaAppType;
    this.b = paramProvider;
  }

  public Boolean a()
  {
    return Boolean.valueOf(false);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.IsCallLogEnabledProvider
 * JD-Core Version:    0.6.0
 */