package com.facebook.feed.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;

public class NewsFeedDatabaseInitializer
  implements INeedInit
{
  private static final Class<?> a = NewsFeedDatabaseInitializer.class;
  private static final WtfToken b = new WtfToken();
  private NewsFeedDbOpenHelper c;
  private Context d;

  public NewsFeedDatabaseInitializer(@FromApplication Context paramContext, NewsFeedDbOpenHelper paramNewsFeedDbOpenHelper)
  {
    this.d = paramContext;
    this.c = paramNewsFeedDbOpenHelper;
  }

  public void i_()
  {
    try
    {
      this.c.getWritableDatabase();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        BLog.a(b, a, "Newsfeed database may be corrupted.", localSQLiteException);
        this.d.deleteDatabase("newsfeed_db");
        this.c.getWritableDatabase();
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.db.NewsFeedDatabaseInitializer
 * JD-Core Version:    0.6.0
 */