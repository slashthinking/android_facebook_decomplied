package com.facebook.orca.app;

import com.facebook.base.GatekeeperSetProvider;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.FetchGatekeepersMethod;

class MessagesModule$FetchGatekeepersMethodProvider extends AbstractProvider<FetchGatekeepersMethod>
{
  private MessagesModule$FetchGatekeepersMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public FetchGatekeepersMethod a()
  {
    return new FetchGatekeepersMethod(c(GatekeeperSetProvider.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FetchGatekeepersMethodProvider
 * JD-Core Version:    0.6.0
 */