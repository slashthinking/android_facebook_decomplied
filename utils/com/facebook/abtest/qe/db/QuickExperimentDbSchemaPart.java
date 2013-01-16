package com.facebook.abtest.qe.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.sqlite.SharedSQLiteSchemaPart;

public class QuickExperimentDbSchemaPart extends SharedSQLiteSchemaPart
{
  private static final Class<?> a = QuickExperimentDbSchemaPart.class;

  public QuickExperimentDbSchemaPart()
  {
    super("quick_experiment", 1);
  }

  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE experiments (name TEXT PRIMARY KEY NOT NULL, groupName TEXT, loggingEnabled INTEGER, locale TEXT, customContentJSON TEXT)");
  }

  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS experiments");
    a(paramSQLiteDatabase);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.db.QuickExperimentDbSchemaPart
 * JD-Core Version:    0.6.2
 */