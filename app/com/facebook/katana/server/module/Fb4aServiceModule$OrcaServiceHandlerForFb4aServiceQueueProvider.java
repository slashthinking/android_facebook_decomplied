package com.facebook.katana.server.module;

import com.facebook.katana.server.handler.FetchMinorStatusHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandler;

class Fb4aServiceModule$OrcaServiceHandlerForFb4aServiceQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private Fb4aServiceModule$OrcaServiceHandlerForFb4aServiceQueueProvider(Fb4aServiceModule paramFb4aServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(FetchMinorStatusHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceModule.OrcaServiceHandlerForFb4aServiceQueueProvider
 * JD-Core Version:    0.6.0
 */