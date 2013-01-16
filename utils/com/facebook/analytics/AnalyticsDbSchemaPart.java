package com.facebook.analytics;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.sqlite.SharedSQLiteSchemaPart;
import com.facebook.orca.debug.BLog;

public class AnalyticsDbSchemaPart extends SharedSQLiteSchemaPart
{
  private static final Class<?> a = AnalyticsDbSchemaPart.class;

  public AnalyticsDbSchemaPart()
  {
    super("analytics", 4);
  }

  protected void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE analytics_db_properties (key TEXT PRIMARY KEY, value TEXT)");
    paramSQLiteDatabase.execSQL("CREATE TABLE events (bid TEXT, type TEXT, data TEXT, timestamp INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE batches (id TEXT, sid TEXT, uid INTEGER, seq INTEGER, timestamp INTEGER, active INTEGER, meta TEXT, PRIMARY KEY (id))");
    paramSQLiteDatabase.execSQL("create table counter_names(_id integer primary key autoincrement, name text not null,  unique(name) on conflict ignore);");
    paramSQLiteDatabase.execSQL("create index counter_names_index on counter_names(name)");
    paramSQLiteDatabase.execSQL("create table counter_values(time integer, counter integer references counter_names(_id), value integer);");
    paramSQLiteDatabase.execSQL("create view view_counter as select time, name, value from counter_names join counter_values where _id = counter");
  }

  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    BLog.d(a, "Upgrading part from version " + paramInt1 + " to " + paramInt2 + ", which will destroy all old data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS analytics_db_properties");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS batches");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS counter_values");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS counter_names_index");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS counter_names");
    paramSQLiteDatabase.execSQL("DROP VIEW IF EXISTS view_counter");
    a(paramSQLiteDatabase);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsDbSchemaPart
 * JD-Core Version:    0.6.2
 */