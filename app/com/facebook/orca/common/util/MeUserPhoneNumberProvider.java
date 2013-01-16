package com.facebook.orca.common.util;

import android.telephony.TelephonyManager;
import com.facebook.orca.annotations.FromApplication;
import javax.inject.Inject;
import javax.inject.Provider;

public class MeUserPhoneNumberProvider
  implements Provider<String>
{
  private final TelephonyManager a;

  @Inject
  public MeUserPhoneNumberProvider(@FromApplication TelephonyManager paramTelephonyManager)
  {
    this.a = paramTelephonyManager;
  }

  public String a()
  {
    return this.a.getLine1Number();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.MeUserPhoneNumberProvider
 * JD-Core Version:    0.6.0
 */