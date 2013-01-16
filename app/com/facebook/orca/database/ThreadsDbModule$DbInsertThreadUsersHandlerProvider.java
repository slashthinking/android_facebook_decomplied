package com.facebook.orca.database;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.UserSerialization;

class ThreadsDbModule$DbInsertThreadUsersHandlerProvider extends AbstractProvider<DbInsertThreadUsersHandler>
{
  private ThreadsDbModule$DbInsertThreadUsersHandlerProvider(ThreadsDbModule paramThreadsDbModule)
  {
  }

  public DbInsertThreadUsersHandler a()
  {
    return new DbInsertThreadUsersHandler((ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class), (UserSerialization)b(UserSerialization.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbModule.DbInsertThreadUsersHandlerProvider
 * JD-Core Version:    0.6.0
 */