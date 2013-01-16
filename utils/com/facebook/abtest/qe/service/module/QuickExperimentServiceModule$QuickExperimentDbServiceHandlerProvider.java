package com.facebook.abtest.qe.service.module;

import com.facebook.abtest.qe.db.QuickExperimentStorage;
import com.facebook.abtest.qe.service.QuickExperimentDbServiceHandler;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.orca.inject.AbstractProvider;

class QuickExperimentServiceModule$QuickExperimentDbServiceHandlerProvider extends AbstractProvider<QuickExperimentDbServiceHandler>
{
  private QuickExperimentServiceModule$QuickExperimentDbServiceHandlerProvider(QuickExperimentServiceModule paramQuickExperimentServiceModule)
  {
  }

  public QuickExperimentDbServiceHandler a()
  {
    return new QuickExperimentDbServiceHandler((LocaleUtil)b(LocaleUtil.class), (QuickExperimentStorage)b(QuickExperimentStorage.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.service.module.QuickExperimentServiceModule.QuickExperimentDbServiceHandlerProvider
 * JD-Core Version:    0.6.2
 */