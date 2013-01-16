package com.facebook.orca.prefs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PrefsDbOpenHelper extends SQLiteOpenHelper
{
  private static final Class<?> a = PrefsDbOpenHelper.class;

  public PrefsDbOpenHelper(Context paramContext)
  {
    super(paramContext, "prefs_db", null, 1);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE preferences (key TEXT PRIMARY KEY, type INTEGER, value TEXT)");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.PrefsDbOpenHelper
 * JD-Core Version:    0.6.0
 */