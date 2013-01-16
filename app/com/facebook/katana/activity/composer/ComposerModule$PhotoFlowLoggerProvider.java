package com.facebook.katana.activity.composer;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.photos.analytics.PhotoFlowLogger;

class ComposerModule$PhotoFlowLoggerProvider extends AbstractProvider<PhotoFlowLogger>
{
  private ComposerModule$PhotoFlowLoggerProvider(ComposerModule paramComposerModule)
  {
  }

  public PhotoFlowLogger a()
  {
    return new PhotoFlowLogger((AnalyticsLogger)b(AnalyticsLogger.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerModule.PhotoFlowLoggerProvider
 * JD-Core Version:    0.6.0
 */