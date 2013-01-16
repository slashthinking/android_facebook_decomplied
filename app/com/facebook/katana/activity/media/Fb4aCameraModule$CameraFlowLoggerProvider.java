package com.facebook.katana.activity.media;

import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.camera.support.CameraFlowLogger;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.facebook.photos.analytics.WaterfallIdGenerator;

class Fb4aCameraModule$CameraFlowLoggerProvider extends AbstractProvider<CameraFlowLogger>
{
  private Fb4aCameraModule$CameraFlowLoggerProvider(Fb4aCameraModule paramFb4aCameraModule)
  {
  }

  public CameraFlowLogger a()
  {
    return new Fb4aCameraFlowLogger((PhotoFlowLogger)b(PhotoFlowLogger.class), (PerformanceLogger)b(PerformanceLogger.class), (WaterfallIdGenerator)b(WaterfallIdGenerator.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.Fb4aCameraModule.CameraFlowLoggerProvider
 * JD-Core Version:    0.6.0
 */