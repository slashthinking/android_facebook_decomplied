package com.facebook.common.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper
{
  private final List<? extends Table> a;

  public DBHelper(List<? extends Table> paramList, Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    this.a = paramList;
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((Table)localIterator.next()).a(paramSQLiteDatabase);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((Table)localIterator.next()).a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.common.db.DBHelper
 * JD-Core Version:    0.6.2
 */