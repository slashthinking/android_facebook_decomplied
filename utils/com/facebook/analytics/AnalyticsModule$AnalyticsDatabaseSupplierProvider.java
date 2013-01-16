package com.facebook.analytics;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class AnalyticsModule$AnalyticsDatabaseSupplierProvider extends AbstractProvider<AnalyticsDatabaseSupplier>
{
  private AnalyticsModule$AnalyticsDatabaseSupplierProvider(AnalyticsModule paramAnalyticsModule)
  {
  }

  public AnalyticsDatabaseSupplier a()
  {
    return new AnalyticsDatabaseSupplier((Context)b(Context.class, FromApplication.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (AnalyticsDbSchemaPart)b(AnalyticsDbSchemaPart.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsModule.AnalyticsDatabaseSupplierProvider
 * JD-Core Version:    0.6.2
 */