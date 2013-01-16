package com.facebook.uberbar.module;

import com.facebook.orca.app.INeedInit;
import com.facebook.orca.server.OrcaServiceRegistry;
import com.facebook.uberbar.UberbarService;
import com.facebook.uberbar.api.FetchUberbarResultQueue;

public class UberbarServicesInitializer
  implements INeedInit
{
  private final OrcaServiceRegistry a;

  public UberbarServicesInitializer(OrcaServiceRegistry paramOrcaServiceRegistry)
  {
    this.a = paramOrcaServiceRegistry;
  }

  public void i_()
  {
    this.a.a(FetchUberbarResultQueue.class, UberbarService.class);
    this.a.a("fetch_uberbar_result", FetchUberbarResultQueue.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.module.UberbarServicesInitializer
 * JD-Core Version:    0.6.2
 */