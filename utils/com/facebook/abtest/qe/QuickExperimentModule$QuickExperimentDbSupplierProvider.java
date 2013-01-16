package com.facebook.abtest.qe;

import com.facebook.abtest.qe.db.QuickExperimentDbSchemaPart;
import com.facebook.abtest.qe.db.QuickExperimentDbSupplier;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class QuickExperimentModule$QuickExperimentDbSupplierProvider extends AbstractProvider<QuickExperimentDbSupplier>
{
  private QuickExperimentModule$QuickExperimentDbSupplierProvider(QuickExperimentModule paramQuickExperimentModule)
  {
  }

  public QuickExperimentDbSupplier a()
  {
    return new QuickExperimentDbSupplier(QuickExperimentModule.a(this.a), (AndroidThreadUtil)b(AndroidThreadUtil.class), (QuickExperimentDbSchemaPart)b(QuickExperimentDbSchemaPart.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.QuickExperimentModule.QuickExperimentDbSupplierProvider
 * JD-Core Version:    0.6.2
 */