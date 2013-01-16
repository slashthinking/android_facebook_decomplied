package com.facebook.appcenter.modules;

import com.facebook.appcenter.app.AppCenterDataManager;
import com.facebook.appcenter.cache.AppCategoryCache;
import com.facebook.appcenter.cache.AppServerStateCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class AppCenterModule$AppCenterDataManagerProvider extends AbstractProvider<AppCenterDataManager>
{
  private AppCenterModule$AppCenterDataManagerProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public AppCenterDataManager a()
  {
    return new AppCenterDataManager(AppCenterModule.a(this.a), (AppServerStateCache)b(AppServerStateCache.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (AppCategoryCache)b(AppCategoryCache.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterDataManagerProvider
 * JD-Core Version:    0.6.0
 */