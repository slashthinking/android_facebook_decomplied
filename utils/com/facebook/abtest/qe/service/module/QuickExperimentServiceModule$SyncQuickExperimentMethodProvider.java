package com.facebook.abtest.qe.service.module;

import com.facebook.abtest.qe.protocol.SyncQuickExperimentMethod;
import com.facebook.abtest.qe.protocol.SyncQuickExperimentResultHelper;
import com.facebook.orca.inject.AbstractProvider;

class QuickExperimentServiceModule$SyncQuickExperimentMethodProvider extends AbstractProvider<SyncQuickExperimentMethod>
{
  private QuickExperimentServiceModule$SyncQuickExperimentMethodProvider(QuickExperimentServiceModule paramQuickExperimentServiceModule)
  {
  }

  public SyncQuickExperimentMethod a()
  {
    return new SyncQuickExperimentMethod(new SyncQuickExperimentResultHelper());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.service.module.QuickExperimentServiceModule.SyncQuickExperimentMethodProvider
 * JD-Core Version:    0.6.2
 */