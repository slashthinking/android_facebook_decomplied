package com.facebook.feed.db;

import android.database.sqlite.SQLiteDatabase;
import com.google.common.collect.ImmutableList;

public final class NewsFeedDbOpenHelper$FeedUnitPartialTable
{
  public static final ImmutableList<NewsFeedDbOpenHelper.Column> a = ImmutableList.a(NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.a, NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.b, NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.c);

  private static void d(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(NewsFeedDbOpenHelper.Column.a("feed_unit_partial", a));
  }

  private static void e(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(NewsFeedDbOpenHelper.a("feed_unit_partial"));
  }

  private static void f(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.delete("feed_unit_partial", null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbOpenHelper.FeedUnitPartialTable
 * JD-Core Version:    0.6.0
 */