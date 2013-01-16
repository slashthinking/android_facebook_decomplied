package com.facebook.analytics;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$AnalyticsInitializerProvider extends AbstractProvider<AnalyticsInitializer>
{
  private AnalyticsModule$AnalyticsInitializerProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public AnalyticsInitializer a()
  {
    return new AnalyticsInitializer((FbErrorReporter)b(FbErrorReporter.class), (UniqueIdForDeviceHolder)b(UniqueIdForDeviceHolder.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.AnalyticsInitializerProvider
 * JD-Core Version:    0.6.2
 */