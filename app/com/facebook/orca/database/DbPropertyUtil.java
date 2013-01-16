package com.facebook.orca.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.util.TypedKey;
import com.google.common.base.Supplier;
import javax.inject.Provider;

public abstract class DbPropertyUtil<T extends TypedKey>
{
  private static final String[] c = { "value" };
  private final Provider<SQLiteDatabase> a;
  private final String b;

  protected DbPropertyUtil(Supplier<SQLiteDatabase> paramSupplier, String paramString)
  {
    this.a = new DbPropertyUtil.1(this, paramSupplier);
    this.b = paramString;
  }

  public long a(T paramT, long paramLong)
  {
    String str = a(paramT);
    if (str == null);
    while (true)
    {
      return paramLong;
      try
      {
        long l = Long.parseLong(str);
        paramLong = l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
  }

  public String a(T paramT)
  {
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.a.b();
    String str1 = this.b;
    String[] arrayOfString1 = c;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramT.a();
    Cursor localCursor = localSQLiteDatabase.query(str1, arrayOfString1, "key=?", arrayOfString2, null, null, null);
    try
    {
      if (localCursor.moveToNext())
      {
        String str3 = localCursor.getString(0);
        str2 = str3;
        return str2;
      }
      localCursor.close();
      String str2 = null;
    }
    finally
    {
      localCursor.close();
    }
  }

  public void a(T paramT, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramT.a());
    localContentValues.put("value", paramString);
    ((SQLiteDatabase)this.a.b()).replaceOrThrow(this.b, null, localContentValues);
  }

  public boolean a(T paramT, boolean paramBoolean)
  {
    String str = a(paramT);
    if (str == null);
    while (true)
    {
      return paramBoolean;
      try
      {
        long l = Long.parseLong(str);
        if (l != 0L);
        for (boolean bool = true; ; bool = false)
        {
          paramBoolean = bool;
          break;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
  }

  public void b(T paramT)
  {
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.a.b();
    String str = this.b;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramT.a();
    localSQLiteDatabase.delete(str, "key = ?", arrayOfString);
  }

  public void b(T paramT, long paramLong)
  {
    a(paramT, Long.toString(paramLong));
  }

  public void b(T paramT, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "1"; ; str = "0")
    {
      a(paramT, str);
      return;
    }
  }

  public void c(T paramT)
  {
    SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)this.a.b();
    String str = this.b;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = (paramT.a() + "%");
    localSQLiteDatabase.delete(str, "key LIKE ? ", arrayOfString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbPropertyUtil
 * JD-Core Version:    0.6.0
 */