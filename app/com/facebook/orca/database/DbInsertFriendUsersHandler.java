package com.facebook.orca.database;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.util.TriState;
import com.facebook.orca.common.names.NameSplitter;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.server.GetFriendsResult;
import com.facebook.orca.users.Birthday;
import com.facebook.orca.users.Name;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserFbidIdentifier;
import com.facebook.orca.users.UserSerialization;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import javax.inject.Provider;

public class DbInsertFriendUsersHandler
{
  private final Class<?> a = DbInsertFriendUsersHandler.class;
  private final UsersDatabaseSupplier b;
  private final UserSerialization c;
  private final DbInsertFriendUsersHandler.MyNameLookupBuilder d;
  private final NameSplitter e;
  private final DbUsersPropertyUtil f;
  private final Provider<User> g;

  public DbInsertFriendUsersHandler(UsersDatabaseSupplier paramUsersDatabaseSupplier, UserSerialization paramUserSerialization, DbInsertFriendUsersHandler.MyNameLookupBuilder paramMyNameLookupBuilder, NameSplitter paramNameSplitter, DbUsersPropertyUtil paramDbUsersPropertyUtil, Provider<User> paramProvider)
  {
    this.b = paramUsersDatabaseSupplier;
    this.c = paramUserSerialization;
    this.d = paramMyNameLookupBuilder;
    this.e = paramNameSplitter;
    this.f = paramDbUsersPropertyUtil;
    this.g = paramProvider;
  }

  private void a(User paramUser)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("fbid", paramUser.b());
    Name localName = paramUser.d();
    if (localName != null)
    {
      localContentValues.put("first_name", localName.getFirstName());
      localContentValues.put("last_name", localName.getLastName());
      localContentValues.put("name", localName.getDisplayName());
    }
    localContentValues.put("pic_big", paramUser.o());
    localContentValues.put("pic_square", paramUser.p());
    if (paramUser.r() != null)
      localContentValues.put("pic_crop", this.c.a(paramUser.r()).toString());
    localContentValues.put("email_addresses", this.c.a(paramUser.i()).toString());
    localContentValues.put("phone_numbers", this.c.b(paramUser.j()).toString());
    localContentValues.put("rank", Float.valueOf(paramUser.v()));
    if (paramUser.w() != TriState.UNSET)
      if (paramUser.w() != TriState.YES)
        break label340;
    label340: for (int i = 1; ; i = 0)
    {
      localContentValues.put("is_pushable", Integer.valueOf(i));
      if (paramUser.y() != null)
      {
        localContentValues.put("birthday_month", Integer.valueOf(paramUser.y().a()));
        localContentValues.put("birthday_day", Integer.valueOf(paramUser.y().b()));
        localContentValues.put("birthday_year", Integer.valueOf(paramUser.y().c()));
      }
      if (paramUser.B() != null)
        localContentValues.put("last_active", this.c.a(paramUser.B()).toString());
      if (paramUser.C() != null)
        localContentValues.put("mobile_app_data", this.c.a(paramUser.C()).toString());
      this.b.b().replaceOrThrow("facebook_users", "", localContentValues);
      this.d.a(paramUser.b(), paramUser.f(), this.e.a(0));
      return;
    }
  }

  private void a(User paramUser, int paramInt)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("fbid", paramUser.b());
    localContentValues.put("display_order", Integer.valueOf(paramInt));
    localSQLiteDatabase.replaceOrThrow("favorite_contacts", "", localContentValues);
  }

  private void b(User paramUser)
  {
    if ((paramUser.B() == null) || (paramUser.h() == null));
    while (true)
    {
      return;
      String str = paramUser.h().a();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("last_active", this.c.a(paramUser.B()).toString());
      this.b.b().update("facebook_users", localContentValues, "fbid=?", new String[] { str });
    }
  }

  private void c(User paramUser)
  {
    if ((paramUser.C() == null) || (paramUser.h() == null));
    while (true)
    {
      return;
      String str = paramUser.h().a();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("mobile_app_data", this.c.a(paramUser.C()).toString());
      this.b.b().update("facebook_users", localContentValues, "fbid=?", new String[] { str });
    }
  }

  public void a()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      localSQLiteDatabase.delete("facebook_users", null, null);
      localSQLiteDatabase.delete("facebook_users_name_lookup", null, null);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
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
    throw localObject;
  }

  public void a(GetFriendsResult paramGetFriendsResult)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      if (paramGetFriendsResult.b());
      Iterator localIterator = paramGetFriendsResult.a().iterator();
      for (int i = 0; localIterator.hasNext(); i++)
        a((User)localIterator.next());
      long l = this.f.a(DbProperties.e, 0L) + i;
      this.f.b(DbProperties.e, l);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
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
    throw localObject;
  }

  public void a(ImmutableList<User> paramImmutableList)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      localSQLiteDatabase.delete("favorite_contacts", null, null);
      Iterator localIterator = paramImmutableList.iterator();
      int j;
      for (int i = 0; localIterator.hasNext(); i = j)
      {
        User localUser = (User)localIterator.next();
        j = i + 1;
        a(localUser, i);
      }
      this.f.b(DbProperties.f, paramImmutableList.size());
      this.f.b(DbProperties.g, System.currentTimeMillis());
      localSQLiteDatabase.setTransactionSuccessful();
      return;
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
    throw localObject;
  }

  public void b()
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      a((User)this.g.b());
      long l = this.f.a(DbProperties.e, 0L);
      this.f.b(DbProperties.e, l + 1L);
      localSQLiteDatabase.setTransactionSuccessful();
      return;
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
    throw localObject;
  }

  public void b(ImmutableList<User> paramImmutableList)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      Iterator localIterator = paramImmutableList.iterator();
      while (localIterator.hasNext())
        b((User)localIterator.next());
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

  public void c(ImmutableList<User> paramImmutableList)
  {
    SQLiteDatabase localSQLiteDatabase = this.b.b();
    localSQLiteDatabase.beginTransaction();
    try
    {
      Iterator localIterator = paramImmutableList.iterator();
      while (localIterator.hasNext())
        c((User)localIterator.next());
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
 * Qualified Name:     com.facebook.orca.database.DbInsertFriendUsersHandler
 * JD-Core Version:    0.6.0
 */