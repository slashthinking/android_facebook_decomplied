package com.facebook.appcenter.modules;

import com.facebook.appcenter.cache.AppCategoryCache;
import com.facebook.appcenter.cache.AppDetailCache;
import com.facebook.appcenter.cache.AppListCache;
import com.facebook.appcenter.db.DbAppDetailDeleter;
import com.facebook.appcenter.db.DbAppDetailFetcher;
import com.facebook.appcenter.db.DbAppDetailInserter;
import com.facebook.appcenter.protocol.FetchAppCategoryMethod;
import com.facebook.appcenter.protocol.FetchAppDetailMethod;
import com.facebook.appcenter.protocol.FetchAppListMethod;
import com.facebook.appcenter.protocol.GrantAppGdpMethod;
import com.facebook.appcenter.service.AppDataServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class AppCenterModule$AppCenterHandlerProvider extends AbstractProvider<AppDataServiceHandler>
{
  private AppCenterModule$AppCenterHandlerProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public AppDataServiceHandler a()
  {
    return new AppDataServiceHandler(a(SingleMethodRunner.class), (FetchAppDetailMethod)b(FetchAppDetailMethod.class), (FetchAppListMethod)b(FetchAppListMethod.class), (FetchAppCategoryMethod)b(FetchAppCategoryMethod.class), (GrantAppGdpMethod)b(GrantAppGdpMethod.class), (AppDetailCache)b(AppDetailCache.class), (AppListCache)b(AppListCache.class), (AppCategoryCache)b(AppCategoryCache.class), (DbAppDetailFetcher)b(DbAppDetailFetcher.class), (DbAppDetailInserter)b(DbAppDetailInserter.class), (DbAppDetailDeleter)b(DbAppDetailDeleter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterHandlerProvider
 * JD-Core Version:    0.6.0
 */