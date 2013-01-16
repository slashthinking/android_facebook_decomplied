package com.facebook.abtest.qe.service.module;

import com.facebook.abtest.qe.service.background.SyncQuickExperimentBackgroundTask;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class QuickExperimentServiceModule$SyncQuickExperimentBackgroundTaskProvider extends AbstractProvider<SyncQuickExperimentBackgroundTask>
{
  private QuickExperimentServiceModule$SyncQuickExperimentBackgroundTaskProvider(QuickExperimentServiceModule paramQuickExperimentServiceModule)
  {
  }

  public SyncQuickExperimentBackgroundTask a()
  {
    return new SyncQuickExperimentBackgroundTask(a(String.class, MeUserId.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class, FromApplication.class), (LocaleUtil)b(LocaleUtil.class), (Clock)b(Clock.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.service.module.QuickExperimentServiceModule.SyncQuickExperimentBackgroundTaskProvider
 * JD-Core Version:    0.6.2
 */