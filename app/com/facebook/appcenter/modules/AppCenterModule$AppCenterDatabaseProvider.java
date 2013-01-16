package com.facebook.appcenter.modules;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appcenter.db.AppCenterDatabaseSupplier;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$AppCenterDatabaseProvider extends AbstractProvider<SQLiteDatabase>
{
  private AppCenterModule$AppCenterDatabaseProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public SQLiteDatabase a()
  {
    return ((AppCenterDatabaseSupplier)b(AppCenterDatabaseSupplier.class)).b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterDatabaseProvider
 * JD-Core Version:    0.6.0
 */