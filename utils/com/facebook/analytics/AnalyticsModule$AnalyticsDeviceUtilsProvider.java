package com.facebook.analytics;

import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import com.facebook.analytics.feature.FeatureStatusReporter;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.net.OrcaNetworkManager;

class AnalyticsModule$AnalyticsDeviceUtilsProvider extends AbstractProvider<AnalyticsDeviceUtils>
{
  private AnalyticsModule$AnalyticsDeviceUtilsProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public AnalyticsDeviceUtils a()
  {
    return new AnalyticsDeviceUtils(AnalyticsModule.a(this.a), (TelephonyManager)b(TelephonyManager.class, FromApplication.class), (PackageManager)b(PackageManager.class), (OrcaNetworkManager)b(OrcaNetworkManager.class), (AnalyticCounters)b(AnalyticCounters.class), c(FeatureStatusReporter.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.AnalyticsDeviceUtilsProvider
 * JD-Core Version:    0.6.2
 */