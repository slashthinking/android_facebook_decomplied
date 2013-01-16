package com.facebook.orca.server.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.WebServiceHandler;
import com.facebook.orca.server.FilterChainLink;
import com.facebook.orca.server.OrcaServiceHandler;
import com.facebook.orca.server.OrcaServiceHandler.Filter;
import com.facebook.orca.server.TerminatingHandler;

class MessagesServiceModule$OrcaServiceHandlerWithJustWebServiceProvider extends AbstractProvider<OrcaServiceHandler>
{
  private MessagesServiceModule$OrcaServiceHandlerWithJustWebServiceProvider(MessagesServiceModule paramMessagesServiceModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return new FilterChainLink((OrcaServiceHandler.Filter)b(WebServiceHandler.class), new TerminatingHandler());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.module.MessagesServiceModule.OrcaServiceHandlerWithJustWebServiceProvider
 * JD-Core Version:    0.6.0
 */