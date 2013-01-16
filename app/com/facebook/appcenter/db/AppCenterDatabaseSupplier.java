package com.facebook.appcenter.db;

import android.content.Context;
import com.facebook.orca.common.sqlite.AbstractDatabaseSupplier;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.collect.ImmutableList;

public class AppCenterDatabaseSupplier extends AbstractDatabaseSupplier
{
  private final AppCenterDbSchemaPart a;

  public AppCenterDatabaseSupplier(Context paramContext, AndroidThreadUtil paramAndroidThreadUtil, AppCenterDbSchemaPart paramAppCenterDbSchemaPart)
  {
    super(paramContext, paramAndroidThreadUtil, ImmutableList.a(paramAppCenterDbSchemaPart), "appcenter_db", ImmutableList.d());
    this.a = paramAppCenterDbSchemaPart;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.db.AppCenterDatabaseSupplier
 * JD-Core Version:    0.6.0
 */