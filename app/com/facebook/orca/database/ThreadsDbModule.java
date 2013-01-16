package com.facebook.orca.database;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class ThreadsDbModule extends AbstractModule
{
  protected void a()
  {
    a(ThreadsDbSchemaPart.class).a(new ThreadsDbModule.ThreadsDbSchemaPartProvider(this, null)).a();
    a(ThreadsDatabaseSupplier.class).a(new ThreadsDbModule.ThreadsDatabaseSupplierProvider(this, null)).a();
    a(DbCache.class).a(new ThreadsDbModule.DbCacheProvider(this, null)).a();
    a(DbFetchThreadHandler.class).a(new ThreadsDbModule.DbFetchThreadHandlerProvider(this, null));
    a(DbFetchThreadUsersHandler.class).a(new ThreadsDbModule.DbFetchThreadUsersHandlerProvider(this, null));
    a(DbFetchThreadsHandler.class).a(new ThreadsDbModule.DbFetchThreadsHandlerProvider(this, null));
    a(DbInsertThreadUsersHandler.class).a(new ThreadsDbModule.DbInsertThreadUsersHandlerProvider(this, null));
    a(DbInsertThreadsHandler.class).a(new ThreadsDbModule.DbInsertThreadsHandlerProvider(this, null));
    a(DbSendHandler.class).a(new ThreadsDbModule.DbSendHandlerProvider(this, null));
    a(DbServiceHandler.class).a(new ThreadsDbModule.DbServiceHandlerProvider(this, null));
    a(DbThreadsPropertyUtil.class).a(new ThreadsDbModule.DbThreadsPropertyUtilProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.ThreadsDbModule
 * JD-Core Version:    0.6.0
 */