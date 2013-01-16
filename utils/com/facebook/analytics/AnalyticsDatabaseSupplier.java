package com.facebook.analytics;

import android.content.Context;
import com.facebook.orca.common.sqlite.AbstractDatabaseSupplier;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.collect.ImmutableList;

public class AnalyticsDatabaseSupplier extends AbstractDatabaseSupplier
{
  private final AnalyticsDbSchemaPart a;

  public AnalyticsDatabaseSupplier(Context paramContext, AndroidThreadUtil paramAndroidThreadUtil, AnalyticsDbSchemaPart paramAnalyticsDbSchemaPart)
  {
    super(paramContext, paramAndroidThreadUtil, ImmutableList.a(paramAnalyticsDbSchemaPart), "analytics_db2", ImmutableList.d());
    this.a = paramAnalyticsDbSchemaPart;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsDatabaseSupplier
 * JD-Core Version:    0.6.2
 */