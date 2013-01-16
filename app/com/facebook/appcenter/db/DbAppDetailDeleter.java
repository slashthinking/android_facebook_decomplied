package com.facebook.appcenter.db;

import android.database.sqlite.SQLiteDatabase;
import javax.inject.Inject;

public class DbAppDetailDeleter
{
  private static final Class<?> a = DbAppDetailDeleter.class;
  private final AppCenterDatabaseSupplier b;

  @Inject
  public DbAppDetailDeleter(AppCenterDatabaseSupplier paramAppCenterDatabaseSupplier)
  {
    this.b = paramAppCenterDatabaseSupplier;
  }

  public void a(String paramString)
  {
    this.b.b().delete("appdetails", "app_id = '" + paramString + "'", null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.db.DbAppDetailDeleter
 * JD-Core Version:    0.6.0
 */