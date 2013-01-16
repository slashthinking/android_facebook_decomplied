package com.facebook.analytics;

import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$AnalyticsPropertyUtilProvider extends AbstractProvider<AnalyticsPropertyUtil>
{
  private AnalyticsModule$AnalyticsPropertyUtilProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public AnalyticsPropertyUtil a()
  {
    return new AnalyticsPropertyUtil((AnalyticsDatabaseSupplier)b(AnalyticsDatabaseSupplier.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.AnalyticsPropertyUtilProvider
 * JD-Core Version:    0.6.2
 */