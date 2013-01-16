package com.facebook.appcenter.modules;

import com.facebook.appcenter.service.AppCenterServicesInitializer;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceRegistry;

class AppCenterModule$AppCenterServicesInitializerProvider extends AbstractProvider<AppCenterServicesInitializer>
{
  private AppCenterModule$AppCenterServicesInitializerProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public AppCenterServicesInitializer a()
  {
    return new AppCenterServicesInitializer((OrcaServiceRegistry)b(OrcaServiceRegistry.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterServicesInitializerProvider
 * JD-Core Version:    0.6.0
 */