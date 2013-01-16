package com.facebook.orca.database;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.facebook.orca.users.UserSerialization;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.List;

class DbInsertThreadUsersHandler
{
  private final Class<?> a = DbInsertThreadUsersHandler.class;
  private final ThreadsDatabaseSupplier b;
  private final UserSerialization c;

  DbInsertThreadUsersHandler(ThreadsDatabaseSupplier paramThreadsDatabaseSupplier, UserSerialization paramUserSerialization)
  {
    this.b = paramThreadsDatabaseSupplier;
    this.c = paramUserSerialization;
  }

  void a(List<User> paramList)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        User localUser = (User)localIterator.next();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("user_key", localUser.c().c());
        Name localName = localUser.d();
        if (localName != null)
        {
          localContentValues.put("first_name", localName.getFirstName());
          localContentValues.put("last_name", localName.getLastName());
          localContentValues.put("name", localName.getDisplayName());
        }
        localContentValues.put("pic_big", localUser.o());
        localContentValues.put("pic_square", localUser.p());
        if (localUser.r() != null)
          localContentValues.put("pic_crop", this.c.a(localUser.r()).toString());
        if (localUser.B() != null)
          localContentValues.put("last_active", this.c.a(localUser.B()).toString());
        localSQLiteDatabase.replaceOrThrow("thread_users", "", localContentValues);
      }
    }
    catch (SQLException localSQLException)
    {
      BLog.d(this.a, "SQLException", localSQLException);
      throw localSQLException;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbInsertThreadUsersHandler
 * JD-Core Version:    0.6.0
 */