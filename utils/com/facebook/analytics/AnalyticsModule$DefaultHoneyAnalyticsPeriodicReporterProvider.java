package com.facebook.analytics;

import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;

class AnalyticsModule$DefaultHoneyAnalyticsPeriodicReporterProvider extends AbstractProvider<DefaultHoneyAnalyticsPeriodicReporter>
{
  private AnalyticsModule$DefaultHoneyAnalyticsPeriodicReporterProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public DefaultHoneyAnalyticsPeriodicReporter a()
  {
    return new DefaultHoneyAnalyticsPeriodicReporter(AnalyticsModule.a(this.a), (OrcaServiceOperation)b(OrcaServiceOperation.class, FromApplication.class), (AnalyticsConfig)b(AnalyticsConfig.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.DefaultHoneyAnalyticsPeriodicReporterProvider
 * JD-Core Version:    0.6.2
 */