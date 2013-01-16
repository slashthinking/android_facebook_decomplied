package com.facebook.katana.server.module;

import com.facebook.katana.server.handler.UserSetContactInfoServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandler;

class Fb4aServiceModule$OrcaServiceHandlerForUserSetContactInfoQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private Fb4aServiceModule$OrcaServiceHandlerForUserSetContactInfoQueueProvider(Fb4aServiceModule paramFb4aServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(UserSetContactInfoServiceHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceModule.OrcaServiceHandlerForUserSetContactInfoQueueProvider
 * JD-Core Version:    0.6.0
 */