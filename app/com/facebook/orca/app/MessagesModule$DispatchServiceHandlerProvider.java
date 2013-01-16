package com.facebook.orca.app;

import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.dispatch.DispatchServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.WebServiceHandler;
import com.facebook.orca.sms.MmsSmsServiceHandler;

class MessagesModule$DispatchServiceHandlerProvider extends AbstractProvider<DispatchServiceHandler>
{
  private MessagesModule$DispatchServiceHandlerProvider(MessagesModule paramMessagesModule)
  {
  }

  public DispatchServiceHandler a()
  {
    return new DispatchServiceHandler((MmsSmsServiceHandler)b(MmsSmsServiceHandler.class), (WebServiceHandler)b(WebServiceHandler.class), a(Boolean.class, IsClientSmsEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.DispatchServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */