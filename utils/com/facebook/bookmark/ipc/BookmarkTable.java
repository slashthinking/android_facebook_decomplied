package com.facebook.bookmark.ipc;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.db.Table;
import com.facebook.common.db.Table.Column;
import com.google.common.collect.Lists;
import java.util.List;

public class BookmarkTable extends Table
{
  public static final List<Table.Column> a;
  public static final String[] b;
  public static final String[] c = arrayOfString;

  static
  {
    Table.Column[] arrayOfColumn = new Table.Column[12];
    arrayOfColumn[0] = BookmarkTable.Columns.a;
    arrayOfColumn[1] = BookmarkTable.Columns.b;
    arrayOfColumn[2] = BookmarkTable.Columns.c;
    arrayOfColumn[3] = BookmarkTable.Columns.d;
    arrayOfColumn[4] = BookmarkTable.Columns.e;
    arrayOfColumn[5] = BookmarkTable.Columns.f;
    arrayOfColumn[6] = BookmarkTable.Columns.g;
    arrayOfColumn[7] = BookmarkTable.Columns.h;
    arrayOfColumn[8] = BookmarkTable.Columns.i;
    arrayOfColumn[9] = BookmarkTable.Columns.j;
    arrayOfColumn[10] = BookmarkTable.Columns.k;
    arrayOfColumn[11] = BookmarkTable.Columns.l;
    a = Lists.a(arrayOfColumn);
    b = a(a);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = BookmarkTable.Columns.b.a;
    arrayOfString[1] = BookmarkTable.Columns.h.a;
  }

  public int a()
  {
    return 1;
  }

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    super.a(paramSQLiteDatabase);
    paramSQLiteDatabase.execSQL("CREATE INDEX BOOKMARK_FBID_INDEX ON bookmarks(" + BookmarkTable.Columns.b.a + ")");
    paramSQLiteDatabase.execSQL("CREATE INDEX GROUP_ID_INDEX ON bookmarks(" + BookmarkTable.Columns.i.a + ")");
  }

  public String b()
  {
    return "bookmarks";
  }

  public List<Table.Column> c()
  {
    return a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.ipc.BookmarkTable
 * JD-Core Version:    0.6.2
 */