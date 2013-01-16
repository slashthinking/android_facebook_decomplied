package com.facebook.analytics;

import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$AnalyticsLoggerActivityListenerProvider extends AbstractProvider<AnalyticsLogger.MyActivityListener>
{
  private AnalyticsModule$AnalyticsLoggerActivityListenerProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public AnalyticsLogger.MyActivityListener a()
  {
    return ((AnalyticsLogger)b(AnalyticsLogger.class)).b();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.AnalyticsLoggerActivityListenerProvider
 * JD-Core Version:    0.6.2
 */