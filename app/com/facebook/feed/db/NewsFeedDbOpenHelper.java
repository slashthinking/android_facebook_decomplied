package com.facebook.feed.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.orca.annotations.FromApplication;

public class NewsFeedDbOpenHelper extends SQLiteOpenHelper
{
  private static final Class<?> a = NewsFeedDbOpenHelper.class;

  public NewsFeedDbOpenHelper(@FromApplication Context paramContext)
  {
    super(paramContext, "newsfeed_db", null, 12);
  }

  private static String b(String paramString)
  {
    return "DROP TABLE IF EXISTS " + paramString;
  }

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    NewsFeedDbOpenHelper.HomeStoriesTable.c(paramSQLiteDatabase);
    NewsFeedDbOpenHelper.PrefetchedFeedTable.c(paramSQLiteDatabase);
    NewsFeedDbOpenHelper.FeedbackTable.c(paramSQLiteDatabase);
    NewsFeedDbOpenHelper.FeedUnitPartialTable.c(paramSQLiteDatabase);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    NewsFeedDbOpenHelper.HomeStoriesTable.a(paramSQLiteDatabase);
    NewsFeedDbOpenHelper.PrefetchedFeedTable.a(paramSQLiteDatabase);
    NewsFeedDbOpenHelper.FeedbackTable.a(paramSQLiteDatabase);
    NewsFeedDbOpenHelper.FeedUnitPartialTable.a(paramSQLiteDatabase);
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    NewsFeedDbOpenHelper.HomeStoriesTable.b(paramSQLiteDatabase);
    NewsFeedDbOpenHelper.PrefetchedFeedTable.b(paramSQLiteDatabase);
    NewsFeedDbOpenHelper.FeedbackTable.b(paramSQLiteDatabase);
    NewsFeedDbOpenHelper.FeedUnitPartialTable.b(paramSQLiteDatabase);
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbOpenHelper
 * JD-Core Version:    0.6.0
 */