package com.facebook.orca.database;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class UsersDbModule$UsersDatabaseSupplierProvider extends AbstractProvider<UsersDatabaseSupplier>
{
  private UsersDbModule$UsersDatabaseSupplierProvider(UsersDbModule paramUsersDbModule)
  {
  }

  public UsersDatabaseSupplier a()
  {
    return new UsersDatabaseSupplier((Context)b(Context.class, FromApplication.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (UsersDbSchemaPart)b(UsersDbSchemaPart.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.UsersDbModule.UsersDatabaseSupplierProvider
 * JD-Core Version:    0.6.0
 */