package com.facebook.appcenter.modules;

import com.facebook.appcenter.db.AppCenterDbSchemaPart;
import com.facebook.orca.inject.AbstractProvider;

class AppCenterModule$AppCenterDbSchemaPartProvider extends AbstractProvider<AppCenterDbSchemaPart>
{
  private AppCenterModule$AppCenterDbSchemaPartProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public AppCenterDbSchemaPart a()
  {
    return new AppCenterDbSchemaPart();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterDbSchemaPartProvider
 * JD-Core Version:    0.6.0
 */