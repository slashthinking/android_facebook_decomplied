package com.facebook.orca.common.sqlite;

import android.database.sqlite.SQLiteDatabase;
import com.google.common.base.Preconditions;

public abstract class SharedSQLiteSchemaPart
{
  private final String a;
  private final int b;
  private SharedSQLiteOpenHelper c;

  protected SharedSQLiteSchemaPart(String paramString, int paramInt)
  {
    if (paramInt >= i);
    while (true)
    {
      Preconditions.checkArgument(i, "Version must be positive");
      this.a = paramString;
      this.b = paramInt;
      return;
      i = 0;
    }
  }

  public final String a()
  {
    return this.a;
  }

  protected abstract void a(SQLiteDatabase paramSQLiteDatabase);

  protected abstract void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);

  void a(SharedSQLiteOpenHelper paramSharedSQLiteOpenHelper)
  {
    monitorenter;
    while (true)
    {
      boolean bool;
      try
      {
        if (this.c == null)
          continue;
        if (this.c != paramSharedSQLiteOpenHelper)
          continue;
        continue;
        Preconditions.checkArgument(bool, "SharedSQLiteDbPart initialized more than once");
        this.c = paramSharedSQLiteOpenHelper;
        return;
        bool = false;
      }
      finally
      {
        monitorexit;
      }
    }
  }

  public final int b()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.sqlite.SharedSQLiteSchemaPart
 * JD-Core Version:    0.6.0
 */