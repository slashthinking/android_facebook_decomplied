package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.FetchThreadMethod;
import com.facebook.orca.protocol.methods.FetchThreadsFqlHelper;

class MessagesModule$FetchThreadMethodProvider extends AbstractProvider<FetchThreadMethod>
{
  private MessagesModule$FetchThreadMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public FetchThreadMethod a()
  {
    return new FetchThreadMethod((FetchThreadsFqlHelper)b(FetchThreadsFqlHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FetchThreadMethodProvider
 * JD-Core Version:    0.6.0
 */