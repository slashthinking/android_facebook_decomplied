package com.facebook.analytics;

import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.app.AppInitLock;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class AnalyticsModule$AnalyticsEventProcessorProvider extends AbstractProvider<AnalyticsEventProcessor>
{
  private AnalyticsModule$AnalyticsEventProcessorProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public AnalyticsEventProcessor a()
  {
    return new AnalyticsEventProcessor(AnalyticsModule.a(this.a), a(String.class, MeUserId.class), (AnalyticsPropertyUtil)b(AnalyticsPropertyUtil.class), (AnalyticsDatabaseSupplier)b(AnalyticsDatabaseSupplier.class), (AnalyticsStorage)b(AnalyticsStorage.class), (HoneyAnalyticsPeriodicReporter)b(HoneyAnalyticsPeriodicReporter.class), (AnalyticsDeviceUtils)b(AnalyticsDeviceUtils.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (AppInitLock)b(AppInitLock.class), (Clock)b(Clock.class), (CounterHistoricalData)b(CounterHistoricalData.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.AnalyticsEventProcessorProvider
 * JD-Core Version:    0.6.2
 */