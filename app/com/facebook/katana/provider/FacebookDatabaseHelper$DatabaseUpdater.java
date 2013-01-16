package com.facebook.katana.provider;

import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;

abstract class FacebookDatabaseHelper$DatabaseUpdater
{
  private long a;
  private String b;
  private final String c;

  public FacebookDatabaseHelper$DatabaseUpdater(String paramString)
  {
    this.c = paramString;
  }

  private void c()
  {
    this.b = "";
    this.a = SystemClock.elapsedRealtime();
  }

  public String a()
  {
    return this.c;
  }

  protected abstract void a(SQLiteDatabase paramSQLiteDatabase);

  protected void a(String paramString)
  {
    long l = SystemClock.elapsedRealtime() - this.a;
    this.b = (this.b + paramString + " " + l + "ms\n");
  }

  public String b()
  {
    return this.b;
  }

  public void b(SQLiteDatabase paramSQLiteDatabase)
  {
    c();
    a(paramSQLiteDatabase);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.provider.FacebookDatabaseHelper.DatabaseUpdater
 * JD-Core Version:    0.6.0
 */