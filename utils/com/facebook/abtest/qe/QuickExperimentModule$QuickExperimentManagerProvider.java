package com.facebook.abtest.qe;

import com.facebook.abtest.qe.db.QuickExperimentStorage;
import com.facebook.abtest.qe.registry.QuickExperimentNameHolder;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class QuickExperimentModule$QuickExperimentManagerProvider extends AbstractProvider<QuickExperimentManager>
{
  private QuickExperimentModule$QuickExperimentManagerProvider(QuickExperimentModule paramQuickExperimentModule)
  {
  }

  public QuickExperimentManager a()
  {
    return new QuickExperimentManagerImpl(c(QuickExperimentNameHolder.class), (QuickExperimentStorage)b(QuickExperimentStorage.class), (AnalyticsLogger)b(AnalyticsLogger.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (LocaleUtil)b(LocaleUtil.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.QuickExperimentModule.QuickExperimentManagerProvider
 * JD-Core Version:    0.6.2
 */