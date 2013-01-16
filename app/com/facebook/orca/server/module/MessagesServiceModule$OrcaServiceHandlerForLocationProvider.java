package com.facebook.orca.server.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.location.LocationServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler;

class MessagesServiceModule$OrcaServiceHandlerForLocationProvider extends AbstractProvider<OrcaServiceHandler>
{
  private MessagesServiceModule$OrcaServiceHandlerForLocationProvider(MessagesServiceModule paramMessagesServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(LocationServiceHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.module.MessagesServiceModule.OrcaServiceHandlerForLocationProvider
 * JD-Core Version:    0.6.0
 */