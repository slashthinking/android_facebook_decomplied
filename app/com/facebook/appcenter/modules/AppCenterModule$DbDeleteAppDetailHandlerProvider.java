package com.facebook.appcenter.modules;

import com.facebook.appcenter.db.AppCenterDatabaseSupplier;
import com.facebook.appcenter.db.DbAppDetailDeleter;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$DbDeleteAppDetailHandlerProvider extends AbstractProvider<DbAppDetailDeleter>
{
  private AppCenterModule$DbDeleteAppDetailHandlerProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public DbAppDetailDeleter a()
  {
    return new DbAppDetailDeleter((AppCenterDatabaseSupplier)b(AppCenterDatabaseSupplier.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.DbDeleteAppDetailHandlerProvider
 * JD-Core Version:    0.6.0
 */