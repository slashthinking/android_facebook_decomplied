package com.facebook.orca.server;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperation;

class ServicesModule$OrcaServiceOperationForAppProvider extends AbstractProvider<OrcaServiceOperation>
{
  private ServicesModule$OrcaServiceOperationForAppProvider(ServicesModule paramServicesModule)
  {
  }

  public OrcaServiceOperation a()
  {
    return new OrcaServiceOperation(ServicesModule.a(this.a), (OrcaServiceRegistry)b(OrcaServiceRegistry.class), (AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ServicesModule.OrcaServiceOperationForAppProvider
 * JD-Core Version:    0.6.0
 */