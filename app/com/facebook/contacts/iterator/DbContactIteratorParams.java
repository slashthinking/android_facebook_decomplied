package com.facebook.contacts.iterator;

import android.database.sqlite.SQLiteQueryBuilder;

public class DbContactIteratorParams
{
  public static final DbContactIteratorParams a;
  private static final String[] b = { "data" };
  private final SQLiteQueryBuilder c;
  private final String[] d;
  private final String e;
  private final String[] f;
  private final String g;
  private final String h;
  private final String i;

  static
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("contact_summaries");
    a = new DbContactIteratorParams(localSQLiteQueryBuilder, b, null, null, null, null, null);
  }

  DbContactIteratorParams(SQLiteQueryBuilder paramSQLiteQueryBuilder, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    this.c = paramSQLiteQueryBuilder;
    this.d = paramArrayOfString1;
    this.e = paramString1;
    this.f = paramArrayOfString2;
    this.g = paramString2;
    this.h = paramString3;
    this.i = paramString4;
  }

  public SQLiteQueryBuilder a()
  {
    return this.c;
  }

  public String[] b()
  {
    return this.d;
  }

  public String c()
  {
    return this.e;
  }

  public String[] d()
  {
    return this.f;
  }

  public String e()
  {
    return this.g;
  }

  public String f()
  {
    return this.h;
  }

  public String g()
  {
    return this.i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.iterator.DbContactIteratorParams
 * JD-Core Version:    0.6.0
 */