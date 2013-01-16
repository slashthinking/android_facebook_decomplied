package com.facebook.orca.database;

import android.content.Context;
import com.facebook.orca.common.sqlite.AbstractDatabaseSupplier;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.collect.ImmutableList;

public class UsersDatabaseSupplier extends AbstractDatabaseSupplier
{
  private static final ImmutableList<String> a = ImmutableList.a("users_db");
  private final UsersDbSchemaPart b;

  public UsersDatabaseSupplier(Context paramContext, AndroidThreadUtil paramAndroidThreadUtil, UsersDbSchemaPart paramUsersDbSchemaPart)
  {
    super(paramContext, paramAndroidThreadUtil, ImmutableList.a(paramUsersDbSchemaPart), "users_db2", a);
    this.b = paramUsersDbSchemaPart;
  }

  public void a()
  {
    monitorenter;
    try
    {
      this.b.b(b());
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.UsersDatabaseSupplier
 * JD-Core Version:    0.6.0
 */