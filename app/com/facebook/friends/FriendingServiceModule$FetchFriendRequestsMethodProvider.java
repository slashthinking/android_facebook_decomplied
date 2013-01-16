package com.facebook.friends;

import android.content.res.Resources;
import com.facebook.friends.protocol.FetchFriendRequestsMethod;
import com.facebook.graphql.common.GraphQLHelper;
import com.facebook.orca.inject.AbstractProvider;

class FriendingServiceModule$FetchFriendRequestsMethodProvider extends AbstractProvider<FetchFriendRequestsMethod>
{
  private FriendingServiceModule$FetchFriendRequestsMethodProvider(FriendingServiceModule paramFriendingServiceModule)
  {
  }

  public FetchFriendRequestsMethod a()
  {
    return new FetchFriendRequestsMethod((Resources)b(Resources.class), (GraphQLHelper)b(GraphQLHelper.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendingServiceModule.FetchFriendRequestsMethodProvider
 * JD-Core Version:    0.6.0
 */