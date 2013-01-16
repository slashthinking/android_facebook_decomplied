package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandlerHook;
import com.facebook.orca.server.PreProcessingServiceHandler;

class MessagesModule$PreProcessingServiceHandlerProvider extends AbstractProvider<PreProcessingServiceHandler>
{
  private MessagesModule$PreProcessingServiceHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public PreProcessingServiceHandler a()
  {
    return new PreProcessingServiceHandler(c(OrcaServiceHandlerHook.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.PreProcessingServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */