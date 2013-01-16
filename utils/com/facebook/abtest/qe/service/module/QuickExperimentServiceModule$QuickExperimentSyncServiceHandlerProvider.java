package com.facebook.abtest.qe.service.module;

import com.facebook.abtest.qe.QuickExperimentManager;
import com.facebook.abtest.qe.protocol.SyncQuickExperimentMethod;
import com.facebook.abtest.qe.service.QuickExperimentSyncServiceHandler;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.protocol.base.BatchRunner;

class QuickExperimentServiceModule$QuickExperimentSyncServiceHandlerProvider extends AbstractProvider<QuickExperimentSyncServiceHandler>
{
  private QuickExperimentServiceModule$QuickExperimentSyncServiceHandlerProvider(QuickExperimentServiceModule paramQuickExperimentServiceModule)
  {
  }

  public QuickExperimentSyncServiceHandler a()
  {
    return new QuickExperimentSyncServiceHandler(a(BatchRunner.class), a(String.class, MeUserId.class), (LocaleUtil)b(LocaleUtil.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (SyncQuickExperimentMethod)b(SyncQuickExperimentMethod.class), (QuickExperimentManager)b(QuickExperimentManager.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.service.module.QuickExperimentServiceModule.QuickExperimentSyncServiceHandlerProvider
 * JD-Core Version:    0.6.2
 */