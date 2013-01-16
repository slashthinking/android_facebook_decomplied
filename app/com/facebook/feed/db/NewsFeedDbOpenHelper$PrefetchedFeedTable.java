package com.facebook.feed.db;

import android.database.sqlite.SQLiteDatabase;
import com.google.common.collect.ImmutableList;

public final class NewsFeedDbOpenHelper$PrefetchedFeedTable
{
  public static final ImmutableList<NewsFeedDbOpenHelper.Column> a = ImmutableList.a(NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.a, NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.b, NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.c, NewsFeedDbOpenHelper.PrefetchedFeedTable.Columns.d);

  private static void d(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(NewsFeedDbOpenHelper.Column.a("prefetched_feed", a));
  }

  private static void e(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(NewsFeedDbOpenHelper.a("prefetched_feed"));
  }

  private static void f(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.delete("prefetched_feed", null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbOpenHelper.PrefetchedFeedTable
 * JD-Core Version:    0.6.0
 */