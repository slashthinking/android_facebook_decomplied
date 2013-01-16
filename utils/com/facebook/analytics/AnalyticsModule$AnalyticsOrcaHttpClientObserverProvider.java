package com.facebook.analytics;

import com.facebook.analytics.util.NetworkDataLogUtils;
import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$AnalyticsOrcaHttpClientObserverProvider extends AbstractProvider<AnalyticsOrcaHttpClientObserver>
{
  private AnalyticsModule$AnalyticsOrcaHttpClientObserverProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public AnalyticsOrcaHttpClientObserver a()
  {
    return new AnalyticsOrcaHttpClientObserver((NetworkDataLogger)b(NetworkDataLogger.class), (NetworkDataLogUtils)b(NetworkDataLogUtils.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.AnalyticsOrcaHttpClientObserverProvider
 * JD-Core Version:    0.6.2
 */