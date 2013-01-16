package com.facebook.katana.orca;

import com.facebook.analytics.AnalyticCounters;
import com.facebook.analytics.NetworkDataLogger;
import com.facebook.katana.util.logging.DataLogger;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$NetworkDataLoggerProvider extends AbstractProvider<NetworkDataLogger>
{
  private FbandroidAppModule$NetworkDataLoggerProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public NetworkDataLogger a()
  {
    return new DataLogger(FbandroidAppModule.a(this.a), (AnalyticCounters)b(AnalyticCounters.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.NetworkDataLoggerProvider
 * JD-Core Version:    0.6.0
 */