package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.FetchThreadListMethod;
import com.facebook.orca.protocol.methods.FetchThreadsFqlHelper;

class MessagesModule$FetchThreadListMethodProvider extends AbstractProvider<FetchThreadListMethod>
{
  private MessagesModule$FetchThreadListMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public FetchThreadListMethod a()
  {
    return new FetchThreadListMethod((FetchThreadsFqlHelper)b(FetchThreadsFqlHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FetchThreadListMethodProvider
 * JD-Core Version:    0.6.0
 */