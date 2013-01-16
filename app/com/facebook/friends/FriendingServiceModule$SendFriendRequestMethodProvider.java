package com.facebook.friends;

import com.facebook.friends.protocol.SendFriendRequestMethod;
import com.facebook.orca.inject.AbstractProvider;

class FriendingServiceModule$SendFriendRequestMethodProvider extends AbstractProvider<SendFriendRequestMethod>
{
  private FriendingServiceModule$SendFriendRequestMethodProvider(FriendingServiceModule paramFriendingServiceModule)
  {
  }

  public SendFriendRequestMethod a()
  {
    return new SendFriendRequestMethod();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendingServiceModule.SendFriendRequestMethodProvider
 * JD-Core Version:    0.6.0
 */