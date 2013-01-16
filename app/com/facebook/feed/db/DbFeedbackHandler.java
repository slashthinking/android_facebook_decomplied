package com.facebook.feed.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.common.util.Log;
import com.facebook.graphql.model.Feedback;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.SqlQueryBuilder.Expression;
import com.facebook.orca.debug.Tracer;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;

public class DbFeedbackHandler
{
  private static Class<DbFeedbackHandler> a = DbFeedbackHandler.class;
  private static final String[] b;
  private final SQLiteDatabase c;
  private final DbFeedbackSerialization d;
  private final AndroidThreadUtil e;

  static
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = NewsFeedDbOpenHelper.FeedbackTable.Columns.a.toString();
    arrayOfString[1] = NewsFeedDbOpenHelper.FeedbackTable.Columns.b.toString();
    b = arrayOfString;
  }

  public DbFeedbackHandler(@NewsFeedDb SQLiteDatabase paramSQLiteDatabase, DbFeedbackSerialization paramDbFeedbackSerialization, AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.c = ((SQLiteDatabase)Preconditions.checkNotNull(paramSQLiteDatabase));
    this.d = ((DbFeedbackSerialization)Preconditions.checkNotNull(paramDbFeedbackSerialization));
    this.e = ((AndroidThreadUtil)Preconditions.checkNotNull(paramAndroidThreadUtil));
  }

  public Collection<Feedback> a()
  {
    this.e.b();
    Tracer localTracer = Tracer.a("DbFeedbackHandler.loadAllFeedback");
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("feedback");
    Cursor localCursor = localSQLiteQueryBuilder.query(this.c, b, null, null, null, null, null);
    int i = NewsFeedDbOpenHelper.FeedbackTable.Columns.b.a(localCursor);
    ImmutableList.Builder localBuilder = ImmutableList.e();
    try
    {
      while (localCursor.moveToNext())
      {
        Feedback localFeedback = this.d.a(localCursor.getString(i));
        if (localFeedback == null)
          continue;
        localBuilder.b(localFeedback);
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
      Log.e(a, "Feedback cache initial loading took " + localTracer.a() + " ms to load feedbacks.");
    }
    return localBuilder.b();
  }

  public void a(Feedback paramFeedback)
  {
    this.e.b();
    Preconditions.checkNotNull(paramFeedback);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(NewsFeedDbOpenHelper.FeedbackTable.Columns.a.toString(), paramFeedback.legacyApiPostId);
    localContentValues.put(NewsFeedDbOpenHelper.FeedbackTable.Columns.b.toString(), this.d.a(paramFeedback));
    this.c.replaceOrThrow("feedback", "", localContentValues);
  }

  public void a(String paramString)
  {
    this.e.b();
    Preconditions.checkNotNull(paramString);
    SqlQueryBuilder.Expression localExpression = NewsFeedDbOpenHelper.FeedbackTable.Columns.a.a(paramString);
    this.c.delete("feedback", localExpression.a(), localExpression.b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.DbFeedbackHandler
 * JD-Core Version:    0.6.0
 */