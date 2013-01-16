package com.facebook.orca.server;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class ServicesModule$OrcaServiceOperationFactoryForAppProvider extends AbstractProvider<OrcaServiceOperationFactory>
{
  private ServicesModule$OrcaServiceOperationFactoryForAppProvider(ServicesModule paramServicesModule)
  {
  }

  public OrcaServiceOperationFactory a()
  {
    return new OrcaServiceOperationFactory(ServicesModule.a(this.a), (OrcaServiceRegistry)b(OrcaServiceRegistry.class), (AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ServicesModule.OrcaServiceOperationFactoryForAppProvider
 * JD-Core Version:    0.6.0
 */