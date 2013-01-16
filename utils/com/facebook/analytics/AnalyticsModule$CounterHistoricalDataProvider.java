package com.facebook.analytics;

import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$CounterHistoricalDataProvider extends AbstractProvider<CounterHistoricalData>
{
  private AnalyticsModule$CounterHistoricalDataProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public CounterHistoricalData a()
  {
    return new CounterHistoricalData((AnalyticsDatabaseSupplier)b(AnalyticsDatabaseSupplier.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.CounterHistoricalDataProvider
 * JD-Core Version:    0.6.2
 */