package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.FetchLastActiveMethod;
import com.facebook.orca.users.UserSerialization;

class MessagesModule$FetchLastActiveMethodProvider extends AbstractProvider<FetchLastActiveMethod>
{
  private MessagesModule$FetchLastActiveMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public FetchLastActiveMethod a()
  {
    return new FetchLastActiveMethod((UserSerialization)b(UserSerialization.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FetchLastActiveMethodProvider
 * JD-Core Version:    0.6.0
 */