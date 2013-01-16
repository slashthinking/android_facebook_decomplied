package com.facebook.appcenter.service;

import com.facebook.orca.app.INeedInit;
import com.facebook.orca.server.OrcaServiceRegistry;

public class AppCenterServicesInitializer
  implements INeedInit
{
  private final OrcaServiceRegistry a;

  public AppCenterServicesInitializer(OrcaServiceRegistry paramOrcaServiceRegistry)
  {
    this.a = paramOrcaServiceRegistry;
  }

  public void i_()
  {
    this.a.a(FetchAppDataQueue.class, AppCenterService.class);
    this.a.a("fetch_app_detail", FetchAppDataQueue.class);
    this.a.a("fetch_app_list", FetchAppDataQueue.class);
    this.a.a("fetch_app_categories", FetchAppDataQueue.class);
    this.a.a("grant_app_gdp", FetchAppDataQueue.class);
    this.a.a("delete_app_detail", FetchAppDataQueue.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.service.AppCenterServicesInitializer
 * JD-Core Version:    0.6.0
 */