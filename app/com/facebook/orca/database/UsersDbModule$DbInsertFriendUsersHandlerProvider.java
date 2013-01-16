package com.facebook.orca.database;

import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.common.names.NameSplitter;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserSerialization;

class UsersDbModule$DbInsertFriendUsersHandlerProvider extends AbstractProvider<DbInsertFriendUsersHandler>
{
  private UsersDbModule$DbInsertFriendUsersHandlerProvider(UsersDbModule paramUsersDbModule)
  {
  }

  public DbInsertFriendUsersHandler a()
  {
    return new DbInsertFriendUsersHandler((UsersDatabaseSupplier)b(UsersDatabaseSupplier.class), (UserSerialization)b(UserSerialization.class), (DbInsertFriendUsersHandler.MyNameLookupBuilder)b(DbInsertFriendUsersHandler.MyNameLookupBuilder.class), (NameSplitter)b(NameSplitter.class), (DbUsersPropertyUtil)b(DbUsersPropertyUtil.class), a(User.class, MeUser.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.UsersDbModule.DbInsertFriendUsersHandlerProvider
 * JD-Core Version:    0.6.0
 */