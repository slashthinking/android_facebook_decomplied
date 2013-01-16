package com.facebook.abtest.qe.db;

import android.content.Context;
import com.facebook.orca.common.sqlite.AbstractDatabaseSupplier;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.collect.ImmutableList;

public class QuickExperimentDbSupplier extends AbstractDatabaseSupplier
{
  private final QuickExperimentDbSchemaPart a;

  public QuickExperimentDbSupplier(Context paramContext, AndroidThreadUtil paramAndroidThreadUtil, QuickExperimentDbSchemaPart paramQuickExperimentDbSchemaPart)
  {
    super(paramContext, paramAndroidThreadUtil, ImmutableList.a(paramQuickExperimentDbSchemaPart), "qe_db", ImmutableList.d());
    this.a = paramQuickExperimentDbSchemaPart;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.db.QuickExperimentDbSupplier
 * JD-Core Version:    0.6.2
 */