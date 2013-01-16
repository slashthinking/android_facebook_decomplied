package com.facebook.nearby.module;

import com.facebook.analytics.InteractionLogger;
import com.facebook.nearby.analytics.NearbyAnalytics;
import com.facebook.orca.inject.AbstractProvider;

class NearbyModule$NearbyAnalyticsProvider extends AbstractProvider<NearbyAnalytics>
{
  private NearbyModule$NearbyAnalyticsProvider(NearbyModule paramNearbyModule)
  {
  }

  public NearbyAnalytics a()
  {
    return new NearbyAnalytics((InteractionLogger)b(InteractionLogger.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.module.NearbyModule.NearbyAnalyticsProvider
 * JD-Core Version:    0.6.0
 */