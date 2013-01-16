package com.facebook.composer;

import com.facebook.analytics.AnalyticsLogger;
import com.facebook.composer.optimistic.ComposerActivityBroadcaster;
import com.facebook.composer.service.ComposerPublishService;
import com.facebook.orca.common.dialogs.ErrorMessageGenerator;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

class ComposerLibModule$ComposerPublishServiceProvider extends AbstractProvider<ComposerPublishService>
{
  private ComposerLibModule$ComposerPublishServiceProvider(ComposerLibModule paramComposerLibModule)
  {
  }

  public ComposerPublishService a()
  {
    return new ComposerPublishService(ComposerLibModule.a(this.a), (ComposerActivityBroadcaster)b(ComposerActivityBroadcaster.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (ErrorMessageGenerator)b(ErrorMessageGenerator.class), (AnalyticsLogger)b(AnalyticsLogger.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.ComposerLibModule.ComposerPublishServiceProvider
 * JD-Core Version:    0.6.2
 */