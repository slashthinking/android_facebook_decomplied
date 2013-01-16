package com.facebook.analytics;

import android.telephony.TelephonyManager;
import com.facebook.config.AppBuildInfo;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.config.PlatformAppConfig;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class AnalyticsModule$HoneyAnalyticsUploadHandlerProvider extends AbstractProvider<HoneyAnalyticsUploadHandler>
{
  private AnalyticsModule$HoneyAnalyticsUploadHandlerProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public HoneyAnalyticsUploadHandler a()
  {
    return new HoneyAnalyticsUploadHandler((AppBuildInfo)b(AppBuildInfo.class), (PlatformAppConfig)b(PlatformAppConfig.class), (AnalyticsStorage)b(AnalyticsStorage.class), (TelephonyManager)b(TelephonyManager.class, FromApplication.class), (UniqueIdForDeviceHolder)b(UniqueIdForDeviceHolder.class), (OrcaNetworkManager)b(OrcaNetworkManager.class), (SingleMethodRunner)b(SingleMethodRunner.class), (SendAnalyticLogsMethod)b(SendAnalyticLogsMethod.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.HoneyAnalyticsUploadHandlerProvider
 * JD-Core Version:    0.6.2
 */