package com.facebook.analytics;

import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$ReliabilityAnalyticsLoggerProvider extends AbstractProvider<ReliabilityAnalyticsLogger>
{
  private AnalyticsModule$ReliabilityAnalyticsLoggerProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public ReliabilityAnalyticsLogger a()
  {
    return new ReliabilityAnalyticsLogger((AnalyticsLogger)b(AnalyticsLogger.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.ReliabilityAnalyticsLoggerProvider
 * JD-Core Version:    0.6.2
 */