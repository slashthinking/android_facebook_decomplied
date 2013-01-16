package com.facebook.orca.common.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;

public final class SharedSQLiteOpenHelper extends SQLiteOpenHelper
{
  private static final String[] b = { "version" };
  private final ImmutableList<SharedSQLiteSchemaPart> a;

  public SharedSQLiteOpenHelper(Context paramContext, String paramString, List<? extends SharedSQLiteSchemaPart> paramList)
  {
    super(paramContext, paramString, null, 200);
    this.a = ImmutableList.a(paramList);
  }

  private int a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Cursor localCursor = paramSQLiteDatabase.query("_shared_version", b, "name=?", new String[] { paramString }, null, null, null);
    try
    {
      if (localCursor.moveToNext())
      {
        int j = localCursor.getInt(0);
        i = j;
        return i;
      }
      localCursor.close();
      int i = -1;
    }
    finally
    {
      localCursor.close();
    }
  }

  private void a(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", paramString);
    localContentValues.put("version", Integer.valueOf(paramInt));
    paramSQLiteDatabase.replaceOrThrow("_shared_version", null, localContentValues);
  }

  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE _shared_version (name TEXT PRIMARY KEY, version INTEGER)");
  }

  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransaction();
    SharedSQLiteSchemaPart localSharedSQLiteSchemaPart;
    int i;
    try
    {
      Iterator localIterator1 = this.a.iterator();
      if (!localIterator1.hasNext())
        break label182;
      localSharedSQLiteSchemaPart = (SharedSQLiteSchemaPart)localIterator1.next();
      i = a(paramSQLiteDatabase, localSharedSQLiteSchemaPart.a());
      if (i != -1)
        break label98;
      if (paramSQLiteDatabase.isReadOnly())
        throw new SQLiteException("Can't upgrade readonly database");
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
    localSharedSQLiteSchemaPart.a(paramSQLiteDatabase);
    label98: 
    do
      while (true)
      {
        a(paramSQLiteDatabase, localSharedSQLiteSchemaPart.a(), localSharedSQLiteSchemaPart.b());
        break;
        if (i >= localSharedSQLiteSchemaPart.b())
          break label141;
        if (paramSQLiteDatabase.isReadOnly())
          throw new SQLiteException("Can't upgrade readonly database");
        localSharedSQLiteSchemaPart.a(paramSQLiteDatabase, i, localSharedSQLiteSchemaPart.b());
      }
    while (i <= localSharedSQLiteSchemaPart.b());
    label141: throw new SQLiteException("Can't downgrade version for " + localSharedSQLiteSchemaPart.a());
    label182: paramSQLiteDatabase.setTransactionSuccessful();
    paramSQLiteDatabase.endTransaction();
    Iterator localIterator2 = this.a.iterator();
    while (localIterator2.hasNext())
      ((SharedSQLiteSchemaPart)localIterator2.next()).a(this);
  }

  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.sqlite.SharedSQLiteOpenHelper
 * JD-Core Version:    0.6.0
 */