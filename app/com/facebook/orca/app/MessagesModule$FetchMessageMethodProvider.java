package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.FetchMessageMethod;
import com.facebook.orca.protocol.methods.FetchThreadsFqlHelper;

class MessagesModule$FetchMessageMethodProvider extends AbstractProvider<FetchMessageMethod>
{
  private MessagesModule$FetchMessageMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public FetchMessageMethod a()
  {
    return new FetchMessageMethod((FetchThreadsFqlHelper)b(FetchThreadsFqlHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FetchMessageMethodProvider
 * JD-Core Version:    0.6.0
 */