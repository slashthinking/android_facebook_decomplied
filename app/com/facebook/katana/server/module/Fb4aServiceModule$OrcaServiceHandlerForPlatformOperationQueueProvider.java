package com.facebook.katana.server.module;

import com.facebook.katana.server.handler.PlatformOperationHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandler;

class Fb4aServiceModule$OrcaServiceHandlerForPlatformOperationQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private Fb4aServiceModule$OrcaServiceHandlerForPlatformOperationQueueProvider(Fb4aServiceModule paramFb4aServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(PlatformOperationHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceModule.OrcaServiceHandlerForPlatformOperationQueueProvider
 * JD-Core Version:    0.6.0
 */