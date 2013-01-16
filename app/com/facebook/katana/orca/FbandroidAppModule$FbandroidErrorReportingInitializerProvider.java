package com.facebook.katana.orca;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.katana.util.FbandroidErrorReportingInitializer;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$FbandroidErrorReportingInitializerProvider extends AbstractProvider<FbandroidErrorReportingInitializer>
{
  private FbandroidAppModule$FbandroidErrorReportingInitializerProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public FbandroidErrorReportingInitializer a()
  {
    return new FbandroidErrorReportingInitializer((FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.FbandroidErrorReportingInitializerProvider
 * JD-Core Version:    0.6.0
 */