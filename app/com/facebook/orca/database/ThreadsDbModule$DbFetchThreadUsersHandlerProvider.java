package com.facebook.orca.database;

import com.facebook.orca.annotations.ForMessages;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.FacebookUserIterator;
import com.facebook.orca.users.UserSerialization;
import com.fasterxml.jackson.databind.ObjectMapper;

class ThreadsDbModule$DbFetchThreadUsersHandlerProvider extends AbstractProvider<DbFetchThreadUsersHandler>
{
  private ThreadsDbModule$DbFetchThreadUsersHandlerProvider(ThreadsDbModule paramThreadsDbModule)
  {
  }

  public DbFetchThreadUsersHandler a()
  {
    return new DbFetchThreadUsersHandler((ThreadsDatabaseSupplier)b(ThreadsDatabaseSupplier.class), a(FacebookUserIterator.class, ForMessages.class), (UserSerialization)b(UserSerialization.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbModule.DbFetchThreadUsersHandlerProvider
 * JD-Core Version:    0.6.0
 */