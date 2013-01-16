package com.facebook.appcenter.modules;

import com.facebook.appcenter.db.AppCenterDatabaseSupplier;
import com.facebook.appcenter.db.DbAppDetailInserter;
import com.facebook.orca.inject.AbstractProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

class AppCenterModule$DbInsertAppDetailHandlerProvider extends AbstractProvider<DbAppDetailInserter>
{
  private AppCenterModule$DbInsertAppDetailHandlerProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public DbAppDetailInserter a()
  {
    return new DbAppDetailInserter((AppCenterDatabaseSupplier)b(AppCenterDatabaseSupplier.class), (ObjectMapper)b(ObjectMapper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.DbInsertAppDetailHandlerProvider
 * JD-Core Version:    0.6.0
 */