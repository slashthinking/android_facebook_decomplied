package com.facebook.appcenter.modules;

import com.facebook.appcenter.db.AppCenterDatabaseSupplier;
import com.facebook.appcenter.db.DbAppDetailFetcher;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class AppCenterModule$DbFetchAppDetailHandlerProvider extends AbstractProvider<DbAppDetailFetcher>
{
  private AppCenterModule$DbFetchAppDetailHandlerProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public DbAppDetailFetcher a()
  {
    return new DbAppDetailFetcher((AppCenterDatabaseSupplier)b(AppCenterDatabaseSupplier.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.DbFetchAppDetailHandlerProvider
 * JD-Core Version:    0.6.0
 */