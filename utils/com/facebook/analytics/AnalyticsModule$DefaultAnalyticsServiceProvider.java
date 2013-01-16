package com.facebook.analytics;

import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$DefaultAnalyticsServiceProvider extends AbstractProvider<IAnalyticsService>
{
  private AnalyticsModule$DefaultAnalyticsServiceProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public IAnalyticsService a()
  {
    return ((AnalyticsServiceManager)b(AnalyticsServiceManager.class)).b();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.DefaultAnalyticsServiceProvider
 * JD-Core Version:    0.6.2
 */