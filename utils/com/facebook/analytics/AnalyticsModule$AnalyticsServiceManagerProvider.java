package com.facebook.analytics;

import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$AnalyticsServiceManagerProvider extends AbstractProvider<AnalyticsServiceManager>
{
  private AnalyticsModule$AnalyticsServiceManagerProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public AnalyticsServiceManager a()
  {
    return new AnalyticsServiceManager(AnalyticsModule.a(this.a));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.AnalyticsServiceManagerProvider
 * JD-Core Version:    0.6.2
 */