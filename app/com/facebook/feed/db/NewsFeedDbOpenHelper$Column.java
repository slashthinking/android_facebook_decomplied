package com.facebook.feed.db;

import android.database.Cursor;
import com.facebook.orca.common.util.SqlQueryBuilder;
import com.facebook.orca.common.util.SqlQueryBuilder.Expression;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

class NewsFeedDbOpenHelper$Column
{
  public static final Column a = new Column("ROWID", "INTEGER", false);
  private static Function<Column, String> b = new NewsFeedDbOpenHelper.Column.1();
  private static ImmutableSet<String> c = ImmutableSet.a("ROWID", "OID", "__ROWID__");
  private String d;
  private String e;

  public NewsFeedDbOpenHelper$Column(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, true);
  }

  private NewsFeedDbOpenHelper$Column(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
      if (c.contains(paramString1.toUpperCase()))
        break label50;
    label50: for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "%s can't be used as column name", new Object[] { paramString1 });
      this.d = paramString1;
      this.e = paramString2;
      return;
    }
  }

  private String b()
  {
    return this.d + " " + this.e;
  }

  private static String b(String paramString, ImmutableList<Column> paramImmutableList)
  {
    return "CREATE TABLE " + paramString + " (" + Joiner.on(", ").join(Collections2.a(paramImmutableList, b)) + ")";
  }

  private static String b(String paramString1, String paramString2, ImmutableList<Column> paramImmutableList)
  {
    return "CREATE INDEX IF NOT EXISTS " + paramString2 + " ON " + paramString1 + " ( " + Joiner.on(", ").join(paramImmutableList) + " )";
  }

  public int a(Cursor paramCursor)
  {
    return paramCursor.getColumnIndex(this.d);
  }

  public SqlQueryBuilder.Expression a(String paramString)
  {
    return SqlQueryBuilder.a(this.d, paramString);
  }

  public String a()
  {
    return this.d + " DESC";
  }

  public SqlQueryBuilder.Expression b(String paramString)
  {
    return SqlQueryBuilder.b(this.d, paramString);
  }

  public String toString()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDbOpenHelper.Column
 * JD-Core Version:    0.6.0
 */