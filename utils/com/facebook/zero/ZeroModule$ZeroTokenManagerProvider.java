package com.facebook.zero;

import android.telephony.TelephonyManager;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.zero.annotations.IsZeroRatingFeatureEnabled;

class ZeroModule$ZeroTokenManagerProvider extends AbstractProvider<ZeroTokenManager>
{
  private ZeroModule$ZeroTokenManagerProvider(ZeroModule paramZeroModule)
  {
  }

  public ZeroTokenManager a()
  {
    return new ZeroTokenManager((TelephonyManager)b(TelephonyManager.class, FromApplication.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), a(Boolean.class, IsZeroRatingFeatureEnabled.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.ZeroModule.ZeroTokenManagerProvider
 * JD-Core Version:    0.6.2
 */