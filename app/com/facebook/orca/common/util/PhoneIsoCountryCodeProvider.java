package com.facebook.orca.common.util;

import android.telephony.TelephonyManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Strings;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;

public class PhoneIsoCountryCodeProvider
  implements Provider<String>
{
  private static final Class<?> a = PhoneIsoCountryCodeProvider.class;
  private final TelephonyManager b;
  private final Provider<Locale> c;

  @Inject
  public PhoneIsoCountryCodeProvider(@FromApplication TelephonyManager paramTelephonyManager, Provider<Locale> paramProvider)
  {
    this.b = paramTelephonyManager;
    this.c = paramProvider;
  }

  public String a()
  {
    String str1 = this.b.getSimCountryIso();
    if (Strings.isNullOrEmpty(str1))
      str1 = this.b.getNetworkCountryIso();
    if (Strings.isNullOrEmpty(str1))
      str1 = ((Locale)this.c.b()).getCountry();
    if (!Strings.isNullOrEmpty(str1));
    for (String str2 = str1.toUpperCase(); ; str2 = null)
    {
      return str2;
      BLog.e(a, "No ISO country code detected! This should never happen.");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.PhoneIsoCountryCodeProvider
 * JD-Core Version:    0.6.0
 */