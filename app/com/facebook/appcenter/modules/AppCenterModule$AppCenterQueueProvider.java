package com.facebook.appcenter.modules;

import com.facebook.appcenter.service.AppDataServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandler;

class AppCenterModule$AppCenterQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private AppCenterModule$AppCenterQueueProvider(AppCenterModule paramAppCenterModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(AppDataServiceHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.modules.AppCenterModule.AppCenterQueueProvider
 * JD-Core Version:    0.6.0
 */