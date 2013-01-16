package com.facebook.appcenter.modules;

import com.facebook.appcenter.cache.AppServerStateCache;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$AppServerStateCacheProvider extends AbstractProvider<AppServerStateCache>
{
  private AppCenterModule$AppServerStateCacheProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public AppServerStateCache a()
  {
    return new AppServerStateCache();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppServerStateCacheProvider
 * JD-Core Version:    0.6.0
 */