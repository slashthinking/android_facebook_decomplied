package com.facebook.bookmark.ipc;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.db.Table;
import com.facebook.common.db.Table.Column;
import com.google.common.collect.Lists;
import java.util.List;

public class SyncStatusTable extends Table
{
  public static final List<Table.Column> a = Lists.a(arrayOfColumn);
  public static final String[] b = a(a);

  static
  {
    Table.Column[] arrayOfColumn = new Table.Column[2];
    arrayOfColumn[0] = SyncStatusTable.Columns.a;
    arrayOfColumn[1] = SyncStatusTable.Columns.b;
  }

  public int a()
  {
    return 1;
  }

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    super.a(paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("INSERT INTO bookmark_sync_status (" + SyncStatusTable.Columns.a + ", " + SyncStatusTable.Columns.b + ") VALUES (0, 0)");
  }

  public String b()
  {
    return "bookmark_sync_status";
  }

  public List<Table.Column> c()
  {
    return a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ipc.SyncStatusTable
 * JD-Core Version:    0.6.2
 */