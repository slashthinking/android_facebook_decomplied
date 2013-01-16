package com.facebook.orca.server;

import com.facebook.orca.inject.AbstractProvider;

class ServicesModule$OrcaServiceQueueManagerProvider extends AbstractProvider<OrcaServiceQueueManager>
{
  private ServicesModule$OrcaServiceQueueManagerProvider(ServicesModule paramServicesModule)
  {
  }

  public OrcaServiceQueueManager a()
  {
    return new OrcaServiceQueueManager(ServicesModule.a(this.a), (OrcaServiceRegistry)b(OrcaServiceRegistry.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ServicesModule.OrcaServiceQueueManagerProvider
 * JD-Core Version:    0.6.0
 */