package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.FetchMobileAppDataMethod;
import com.facebook.orca.users.UserSerialization;

class MessagesModule$FetchMobileAppDataMethodProvider extends AbstractProvider<FetchMobileAppDataMethod>
{
  private MessagesModule$FetchMobileAppDataMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public FetchMobileAppDataMethod a()
  {
    return new FetchMobileAppDataMethod((UserSerialization)b(UserSerialization.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.FetchMobileAppDataMethodProvider
 * JD-Core Version:    0.6.0
 */