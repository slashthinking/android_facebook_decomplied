package com.facebook.feed.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.feed.cache.FeedStoryPartial;
import com.facebook.feed.cache.FeedUnitPartial;
import com.facebook.feed.cache.PagesYouMayLikeFeedUnitPartial;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.SqlQueryBuilder.Expression;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;

public class DbFeedUnitPartialHandler
{
  private static final String[] a;
  private final SQLiteDatabase b;
  private final DbFeedStoryPartialSerialization c;
  private final DbPagesYouMayLikeFeedUnitPartialSerialization d;
  private final AndroidThreadUtil e;

  static
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.a.toString();
    arrayOfString[1] = NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.b.toString();
    arrayOfString[2] = NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.c.toString();
    a = arrayOfString;
  }

  public DbFeedUnitPartialHandler(@NewsFeedDb SQLiteDatabase paramSQLiteDatabase, DbFeedStoryPartialSerialization paramDbFeedStoryPartialSerialization, DbPagesYouMayLikeFeedUnitPartialSerialization paramDbPagesYouMayLikeFeedUnitPartialSerialization, AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.b = ((SQLiteDatabase)Preconditions.checkNotNull(paramSQLiteDatabase));
    this.c = ((DbFeedStoryPartialSerialization)Preconditions.checkNotNull(paramDbFeedStoryPartialSerialization));
    this.d = ((DbPagesYouMayLikeFeedUnitPartialSerialization)Preconditions.checkNotNull(paramDbPagesYouMayLikeFeedUnitPartialSerialization));
    this.e = ((AndroidThreadUtil)Preconditions.checkNotNull(paramAndroidThreadUtil));
  }

  public Collection<FeedUnitPartial> a()
  {
    this.e.b();
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("feed_unit_partial");
    Cursor localCursor = localSQLiteQueryBuilder.query(this.b, a, null, null, null, null, null);
    int i = NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.b.a(localCursor);
    int j = NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.c.a(localCursor);
    ImmutableList.Builder localBuilder = ImmutableList.e();
    while (true)
    {
      String str;
      try
      {
        if (!localCursor.moveToNext())
          break label174;
        str = localCursor.getString(i);
        if (Objects.equal(str, FeedStoryPartial.a))
        {
          localObject2 = this.c.a(localCursor.getString(j));
          if (localObject2 == null)
            continue;
          localBuilder.b(localObject2);
          continue;
        }
      }
      finally
      {
        if (localCursor == null)
          continue;
        localCursor.close();
      }
      if (Objects.equal(str, PagesYouMayLikeFeedUnitPartial.a))
      {
        PagesYouMayLikeFeedUnitPartial localPagesYouMayLikeFeedUnitPartial = this.d.a(localCursor.getString(j));
        localObject2 = localPagesYouMayLikeFeedUnitPartial;
        continue;
        label174: if (localCursor != null)
          localCursor.close();
        return localBuilder.b();
      }
      Object localObject2 = null;
    }
  }

  public void a(FeedUnitPartial paramFeedUnitPartial)
  {
    this.e.b();
    Preconditions.checkNotNull(paramFeedUnitPartial);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.a.toString(), paramFeedUnitPartial.c);
    if ((paramFeedUnitPartial instanceof FeedStoryPartial))
    {
      localContentValues.put(NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.b.toString(), FeedStoryPartial.a);
      localContentValues.put(NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.c.toString(), this.c.a((FeedStoryPartial)paramFeedUnitPartial));
    }
    while (true)
    {
      this.b.replaceOrThrow("feed_unit_partial", "", localContentValues);
      return;
      if (!(paramFeedUnitPartial instanceof PagesYouMayLikeFeedUnitPartial))
        continue;
      localContentValues.put(NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.b.toString(), PagesYouMayLikeFeedUnitPartial.a);
      localContentValues.put(NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.c.toString(), this.d.a((PagesYouMayLikeFeedUnitPartial)paramFeedUnitPartial));
    }
  }

  public void a(String paramString)
  {
    this.e.b();
    Preconditions.checkNotNull(paramString);
    SqlQueryBuilder.Expression localExpression = NewsFeedDbOpenHelper.FeedUnitPartialTable.Columns.a.a(paramString);
    this.b.delete("feed_unit_partial", localExpression.a(), localExpression.b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.DbFeedUnitPartialHandler
 * JD-Core Version:    0.6.0
 */