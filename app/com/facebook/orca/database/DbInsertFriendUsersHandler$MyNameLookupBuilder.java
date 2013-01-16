package com.facebook.orca.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.facebook.orca.common.names.NameLookupBuilder;
import com.facebook.orca.common.names.NameSplitter;

public class DbInsertFriendUsersHandler$MyNameLookupBuilder extends NameLookupBuilder
{
  private final UsersDatabaseSupplier a;

  public DbInsertFriendUsersHandler$MyNameLookupBuilder(UsersDatabaseSupplier paramUsersDatabaseSupplier, NameSplitter paramNameSplitter)
  {
    super(paramNameSplitter);
    this.a = paramUsersDatabaseSupplier;
  }

  protected void a(String paramString1, int paramInt, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("fbid", paramString1);
    localContentValues.put("name_type", Integer.valueOf(paramInt));
    localContentValues.put("normalized_name", paramString2);
    this.a.b().insert("facebook_users_name_lookup", null, localContentValues);
  }

  protected String[] a(String paramString)
  {
    return new String[0];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbInsertFriendUsersHandler.MyNameLookupBuilder
 * JD-Core Version:    0.6.0
 */