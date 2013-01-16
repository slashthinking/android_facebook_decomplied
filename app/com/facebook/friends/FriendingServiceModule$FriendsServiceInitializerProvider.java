package com.facebook.friends;

import com.facebook.friends.service.FriendingServiceInitializer;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceRegistry;

class FriendingServiceModule$FriendsServiceInitializerProvider extends AbstractProvider<FriendingServiceInitializer>
{
  private FriendingServiceModule$FriendsServiceInitializerProvider(FriendingServiceModule paramFriendingServiceModule)
  {
  }

  public FriendingServiceInitializer a()
  {
    return new FriendingServiceInitializer((OrcaServiceRegistry)b(OrcaServiceRegistry.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendingServiceModule.FriendsServiceInitializerProvider
 * JD-Core Version:    0.6.0
 */