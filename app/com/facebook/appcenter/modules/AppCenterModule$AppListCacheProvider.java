package com.facebook.appcenter.modules;

import com.facebook.appcenter.cache.AppListCache;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$AppListCacheProvider extends AbstractProvider<AppListCache>
{
  private AppCenterModule$AppListCacheProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public AppListCache a()
  {
    return new AppListCache();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppListCacheProvider
 * JD-Core Version:    0.6.0
 */