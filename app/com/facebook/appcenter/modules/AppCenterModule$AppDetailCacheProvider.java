package com.facebook.appcenter.modules;

import com.facebook.appcenter.cache.AppDetailCache;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$AppDetailCacheProvider extends AbstractProvider<AppDetailCache>
{
  private AppCenterModule$AppDetailCacheProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public AppDetailCache a()
  {
    return new AppDetailCache();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppDetailCacheProvider
 * JD-Core Version:    0.6.0
 */