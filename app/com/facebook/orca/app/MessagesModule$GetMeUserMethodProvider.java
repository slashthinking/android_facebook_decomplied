package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.GetMeUserMethod;
import com.facebook.orca.protocol.methods.UserFqlHelper;
import com.facebook.orca.users.UserSerialization;

class MessagesModule$GetMeUserMethodProvider extends AbstractProvider<GetMeUserMethod>
{
  private MessagesModule$GetMeUserMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public GetMeUserMethod a()
  {
    return new GetMeUserMethod((UserFqlHelper)b(UserFqlHelper.class), (UserSerialization)b(UserSerialization.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.GetMeUserMethodProvider
 * JD-Core Version:    0.6.0
 */