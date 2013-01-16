package com.facebook.katana.orca;

import com.facebook.analytics.performance.PerformanceLoggingActivityListener;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$PerformanceLoggingActivityListenerProvider extends AbstractProvider<PerformanceLoggingActivityListener>
{
  private FbandroidAppModule$PerformanceLoggingActivityListenerProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public PerformanceLoggingActivityListener a()
  {
    return new PerformanceLoggingActivityListener();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.PerformanceLoggingActivityListenerProvider
 * JD-Core Version:    0.6.0
 */