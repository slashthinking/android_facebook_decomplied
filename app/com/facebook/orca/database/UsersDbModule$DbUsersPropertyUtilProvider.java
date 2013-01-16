package com.facebook.orca.database;

import com.facebook.orca.inject.AbstractProvider;

class UsersDbModule$DbUsersPropertyUtilProvider extends AbstractProvider<DbUsersPropertyUtil>
{
  private UsersDbModule$DbUsersPropertyUtilProvider(UsersDbModule paramUsersDbModule)
  {
  }

  public DbUsersPropertyUtil a()
  {
    return new DbUsersPropertyUtil((UsersDatabaseSupplier)b(UsersDatabaseSupplier.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.UsersDbModule.DbUsersPropertyUtilProvider
 * JD-Core Version:    0.6.0
 */