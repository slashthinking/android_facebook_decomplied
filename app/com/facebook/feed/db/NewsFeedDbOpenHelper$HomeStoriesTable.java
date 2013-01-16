package com.facebook.feed.db;

import android.database.sqlite.SQLiteDatabase;
import com.google.common.collect.ImmutableList;

public final class NewsFeedDbOpenHelper$HomeStoriesTable
{
  public static final ImmutableList<NewsFeedDbOpenHelper.Column> a = ImmutableList.a(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.a, NewsFeedDbOpenHelper.HomeStoriesTable.Columns.b, NewsFeedDbOpenHelper.HomeStoriesTable.Columns.c, NewsFeedDbOpenHelper.HomeStoriesTable.Columns.d, NewsFeedDbOpenHelper.HomeStoriesTable.Columns.e);

  private static void d(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(NewsFeedDbOpenHelper.Column.a("home_stories", a));
    paramSQLiteDatabase.execSQL(NewsFeedDbOpenHelper.Column.a("home_stories", "home_stories_prev_cursor_index", ImmutableList.a(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.c)));
    paramSQLiteDatabase.execSQL(NewsFeedDbOpenHelper.Column.a("home_stories", "home_stories_start_cursor_index", ImmutableList.a(NewsFeedDbOpenHelper.HomeStoriesTable.Columns.d)));
  }

  private static void e(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(NewsFeedDbOpenHelper.a("home_stories"));
  }

  private static void f(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.delete("home_stories", null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbOpenHelper.HomeStoriesTable
 * JD-Core Version:    0.6.0
 */