package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.FetchMoreThreadsMethod;
import com.facebook.orca.protocol.methods.FetchThreadsFqlHelper;

class MessagesModule$FetchMoreThreadsMethodProvider extends AbstractProvider<FetchMoreThreadsMethod>
{
  private MessagesModule$FetchMoreThreadsMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public FetchMoreThreadsMethod a()
  {
    return new FetchMoreThreadsMethod((FetchThreadsFqlHelper)b(FetchThreadsFqlHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FetchMoreThreadsMethodProvider
 * JD-Core Version:    0.6.0
 */