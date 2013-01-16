package com.facebook.feed.db;

import android.database.sqlite.SQLiteDatabase;
import com.google.common.collect.ImmutableList;

public final class NewsFeedDbOpenHelper$FeedbackTable
{
  public static final ImmutableList<NewsFeedDbOpenHelper.Column> a = ImmutableList.a(NewsFeedDbOpenHelper.FeedbackTable.Columns.a, NewsFeedDbOpenHelper.FeedbackTable.Columns.b);

  private static void d(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(NewsFeedDbOpenHelper.Column.a("feedback", a));
  }

  private static void e(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(NewsFeedDbOpenHelper.a("feedback"));
  }

  private static void f(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.delete("feedback", null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbOpenHelper.FeedbackTable
 * JD-Core Version:    0.6.0
 */