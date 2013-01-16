package com.facebook.katana.server.module;

import com.facebook.katana.server.Fb4aService;
import com.facebook.katana.server.FetchMinorStatusQueue;
import com.facebook.katana.server.PlatformOperationQueue;
import com.facebook.katana.server.UserSetContactInfoQueue;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.server.OrcaServiceRegistry;

public class Fb4aServiceInitializer
  implements INeedInit
{
  private final OrcaServiceRegistry a;

  public Fb4aServiceInitializer(OrcaServiceRegistry paramOrcaServiceRegistry)
  {
    this.a = paramOrcaServiceRegistry;
  }

  public void i_()
  {
    this.a.a(FetchMinorStatusQueue.class, Fb4aService.class);
    this.a.a("fetch_minor_status", FetchMinorStatusQueue.class);
    this.a.a(UserSetContactInfoQueue.class, Fb4aService.class);
    this.a.a("user_set_contact_info", UserSetContactInfoQueue.class);
    this.a.a(PlatformOperationQueue.class, Fb4aService.class);
    this.a.a("platform_get_authorization_string", PlatformOperationQueue.class);
    this.a.a("platform_authorize_app", PlatformOperationQueue.class);
    this.a.a("platform_get_native_gdp_nux_status", PlatformOperationQueue.class);
    this.a.a("platform_update_native_gdp_nux_status", PlatformOperationQueue.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceInitializer
 * JD-Core Version:    0.6.0
 */