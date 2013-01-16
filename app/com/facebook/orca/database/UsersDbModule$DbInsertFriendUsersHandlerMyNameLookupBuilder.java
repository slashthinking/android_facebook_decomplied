package com.facebook.orca.database;

import com.facebook.orca.common.names.NameSplitter;
import com.facebook.orca.inject.AbstractProvider;

class UsersDbModule$DbInsertFriendUsersHandlerMyNameLookupBuilder extends AbstractProvider<DbInsertFriendUsersHandler.MyNameLookupBuilder>
{
  private UsersDbModule$DbInsertFriendUsersHandlerMyNameLookupBuilder(UsersDbModule paramUsersDbModule)
  {
  }

  public DbInsertFriendUsersHandler.MyNameLookupBuilder a()
  {
    return new DbInsertFriendUsersHandler.MyNameLookupBuilder((UsersDatabaseSupplier)b(UsersDatabaseSupplier.class), (NameSplitter)b(NameSplitter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.UsersDbModule.DbInsertFriendUsersHandlerMyNameLookupBuilder
 * JD-Core Version:    0.6.0
 */