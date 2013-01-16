package com.facebook.abtest.qe;

import com.facebook.abtest.qe.db.QuickExperimentDbSupplier;
import com.facebook.abtest.qe.db.QuickExperimentStorage;
import com.facebook.orca.inject.AbstractProvider;

class QuickExperimentModule$QuickExperimentStorageProvider extends AbstractProvider<QuickExperimentStorage>
{
  private QuickExperimentModule$QuickExperimentStorageProvider(QuickExperimentModule paramQuickExperimentModule)
  {
  }

  public QuickExperimentStorage a()
  {
    return new QuickExperimentStorage((QuickExperimentDbSupplier)b(QuickExperimentDbSupplier.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.QuickExperimentModule.QuickExperimentStorageProvider
 * JD-Core Version:    0.6.2
 */