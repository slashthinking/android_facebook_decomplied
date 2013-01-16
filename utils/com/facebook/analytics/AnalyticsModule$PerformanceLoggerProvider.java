package com.facebook.analytics;

import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$PerformanceLoggerProvider extends AbstractProvider<PerformanceLogger>
{
  private AnalyticsModule$PerformanceLoggerProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public PerformanceLogger a()
  {
    return new PerformanceLogger((AnalyticsLogger)b(AnalyticsLogger.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.PerformanceLoggerProvider
 * JD-Core Version:    0.6.2
 */