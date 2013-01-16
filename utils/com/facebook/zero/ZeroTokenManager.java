package com.facebook.zero;

import android.telephony.TelephonyManager;
import com.facebook.common.util.TriState;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.zero.prefs.ZeroPrefKeys;
import com.facebook.zero.protocol.CarrierMccMnc;
import com.facebook.zero.protocol.methods.FetchZeroTokenResult;
import javax.inject.Provider;

public class ZeroTokenManager
{
  private static final Class<?> a = ZeroTokenManager.class;
  private final TelephonyManager b;
  private final OrcaSharedPreferences c;
  private Provider<Boolean> d;

  public ZeroTokenManager(TelephonyManager paramTelephonyManager, OrcaSharedPreferences paramOrcaSharedPreferences, Provider<Boolean> paramProvider)
  {
    this.b = paramTelephonyManager;
    this.c = paramOrcaSharedPreferences;
    this.d = paramProvider;
  }

  public void a()
  {
    if (b() != null)
    {
      Class localClass = a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = b();
      BLog.b(localClass, "existing zero token '%s' was invalidated.", arrayOfObject);
    }
    this.c.b().a(ZeroPrefKeys.b, null).a();
  }

  public void a(FetchZeroTokenResult paramFetchZeroTokenResult)
  {
    String str = paramFetchZeroTokenResult.a();
    if (str == null)
    {
      BLog.b(a, "did not get a zero token.");
      a();
    }
    while (true)
    {
      return;
      BLog.b(a, "got a new zero token '%s'. ", new Object[] { str });
      this.c.b().a(ZeroPrefKeys.b, str).a();
    }
  }

  public String b()
  {
    return this.c.a(ZeroPrefKeys.b, null);
  }

  public CarrierMccMnc c()
  {
    String str1 = this.b.getSimOperator();
    String str2 = "0";
    String str3 = "0";
    if ((str1 != null) && (str1.length() > 6))
    {
      str2 = str1.substring(0, 3);
      str3 = str1.substring(3);
    }
    return new CarrierMccMnc(str2, str3);
  }

  public TriState d()
  {
    TriState localTriState;
    if (!((Boolean)this.d.b()).booleanValue())
      localTriState = TriState.NO;
    while (true)
    {
      return localTriState;
      if (!this.c.a(ZeroPrefKeys.b))
        localTriState = TriState.UNSET;
      else if (this.c.a(ZeroPrefKeys.b, null) != null)
        localTriState = TriState.YES;
      else
        localTriState = TriState.NO;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.ZeroTokenManager
 * JD-Core Version:    0.6.2
 */