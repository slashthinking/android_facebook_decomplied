package com.facebook.abtest.qe;

import com.facebook.abtest.qe.db.QuickExperimentDbSchemaPart;
import com.facebook.orca.inject.AbstractProvider;

class QuickExperimentModule$QuickExperimentDbSchemaPartProvider extends AbstractProvider<QuickExperimentDbSchemaPart>
{
  private QuickExperimentModule$QuickExperimentDbSchemaPartProvider(QuickExperimentModule paramQuickExperimentModule)
  {
  }

  public QuickExperimentDbSchemaPart a()
  {
    return new QuickExperimentDbSchemaPart();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.QuickExperimentModule.QuickExperimentDbSchemaPartProvider
 * JD-Core Version:    0.6.2
 */