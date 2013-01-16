package com.facebook.common.db;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.util.Log;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import java.util.List;

public abstract class Table
{
  public static String[] a(List<Table.Column> paramList)
  {
    String[] arrayOfString = new String[paramList.size()];
    for (int i = 0; i < paramList.size(); i++)
      arrayOfString[i] = ((Table.Column)paramList.get(i)).a;
    return arrayOfString;
  }

  public abstract int a();

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    String str = "CREATE TABLE " + b() + " (" + Joiner.on(',').join(Iterables.a(c(), new Table.1(this))) + ")";
    Log.c(getClass().getSimpleName(), str);
    paramSQLiteDatabase.execSQL(str);
  }

  public void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= a())
      a(paramSQLiteDatabase);
  }

  public abstract String b();

  public abstract List<Table.Column> c();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.db.Table
 * JD-Core Version:    0.6.2
 */