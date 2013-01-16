package com.facebook.orca.database;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class UsersDbModule extends AbstractModule
{
  protected void a()
  {
    a(UsersDbSchemaPart.class).a(new UsersDbModule.UsersDbSchemaPartProvider(this, null)).a();
    a(UsersDatabaseSupplier.class).a(new UsersDbModule.UsersDatabaseSupplierProvider(this, null)).a();
    a(DbInsertFriendUsersHandler.MyNameLookupBuilder.class).a(new UsersDbModule.DbInsertFriendUsersHandlerMyNameLookupBuilder(this, null));
    a(DbInsertFriendUsersHandler.class).a(new UsersDbModule.DbInsertFriendUsersHandlerProvider(this, null));
    a(DbUsersPropertyUtil.class).a(new UsersDbModule.DbUsersPropertyUtilProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.UsersDbModule
 * JD-Core Version:    0.6.0
 */