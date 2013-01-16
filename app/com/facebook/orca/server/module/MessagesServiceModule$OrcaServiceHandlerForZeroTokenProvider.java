package com.facebook.orca.server.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.zero.ZeroTokenHandler;

class MessagesServiceModule$OrcaServiceHandlerForZeroTokenProvider extends AbstractProvider<OrcaServiceHandler>
{
  private MessagesServiceModule$OrcaServiceHandlerForZeroTokenProvider(MessagesServiceModule paramMessagesServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(ZeroTokenHandler.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.module.MessagesServiceModule.OrcaServiceHandlerForZeroTokenProvider
 * JD-Core Version:    0.6.0
 */