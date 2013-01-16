package com.facebook.orca.server;

import com.facebook.orca.inject.AbstractProvider;

class ServicesModule$OrcaServiceRegistryProvider extends AbstractProvider<OrcaServiceRegistry>
{
  private ServicesModule$OrcaServiceRegistryProvider(ServicesModule paramServicesModule)
  {
  }

  public OrcaServiceRegistry a()
  {
    return new OrcaServiceRegistry();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ServicesModule.OrcaServiceRegistryProvider
 * JD-Core Version:    0.6.0
 */