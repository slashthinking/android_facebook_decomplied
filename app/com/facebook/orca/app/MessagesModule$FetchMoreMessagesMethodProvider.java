package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.FetchMoreMessagesMethod;
import com.facebook.orca.protocol.methods.FetchThreadsFqlHelper;

class MessagesModule$FetchMoreMessagesMethodProvider extends AbstractProvider<FetchMoreMessagesMethod>
{
  private MessagesModule$FetchMoreMessagesMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public FetchMoreMessagesMethod a()
  {
    return new FetchMoreMessagesMethod((FetchThreadsFqlHelper)b(FetchThreadsFqlHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FetchMoreMessagesMethodProvider
 * JD-Core Version:    0.6.0
 */