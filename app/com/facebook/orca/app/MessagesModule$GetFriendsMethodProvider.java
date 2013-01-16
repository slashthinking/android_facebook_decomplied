package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.methods.GetFriendsMethod;
import com.facebook.orca.protocol.methods.UserFqlHelper;
import com.facebook.orca.users.UserSerialization;

class MessagesModule$GetFriendsMethodProvider extends AbstractProvider<GetFriendsMethod>
{
  private MessagesModule$GetFriendsMethodProvider(MessagesModule paramMessagesModule)
  {
  }

  public GetFriendsMethod a()
  {
    return new GetFriendsMethod((UserFqlHelper)b(UserFqlHelper.class), (UserSerialization)b(UserSerialization.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.GetFriendsMethodProvider
 * JD-Core Version:    0.6.0
 */