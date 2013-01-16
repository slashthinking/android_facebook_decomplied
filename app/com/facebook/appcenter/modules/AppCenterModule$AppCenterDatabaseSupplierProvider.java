package com.facebook.appcenter.modules;

import android.content.Context;
import com.facebook.appcenter.db.AppCenterDatabaseSupplier;
import com.facebook.appcenter.db.AppCenterDbSchemaPart;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$AppCenterDatabaseSupplierProvider extends AbstractProvider<AppCenterDatabaseSupplier>
{
  private AppCenterModule$AppCenterDatabaseSupplierProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public AppCenterDatabaseSupplier a()
  {
    return new AppCenterDatabaseSupplier((Context)b(Context.class, FromApplication.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (AppCenterDbSchemaPart)b(AppCenterDbSchemaPart.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterDatabaseSupplierProvider
 * JD-Core Version:    0.6.0
 */