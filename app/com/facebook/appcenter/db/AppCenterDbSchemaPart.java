package com.facebook.appcenter.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.sqlite.SharedSQLiteSchemaPart;
import com.facebook.orca.debug.BLog;

public class AppCenterDbSchemaPart extends SharedSQLiteSchemaPart
{
  private static final Class<?> a = AppCenterDbSchemaPart.class;

  public AppCenterDbSchemaPart()
  {
    super("appcenter", 1);
  }

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE appdetails(app_id TEXT PRIMARY KEY, data TEXT )");
  }

  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    BLog.d(a, "Upgrading part from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS appdetails");
    a(paramSQLiteDatabase);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.db.AppCenterDbSchemaPart
 * JD-Core Version:    0.6.0
 */