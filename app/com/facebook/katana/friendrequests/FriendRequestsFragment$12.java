package com.facebook.katana.friendrequests;

import com.facebook.friends.FriendRequestResponse;
import com.facebook.friends.FriendRequestState;
import com.facebook.friends.model.FriendRequest;
import com.facebook.graphql.model.GraphQLProfile;
import com.google.common.util.concurrent.FutureCallback;

class FriendRequestsFragment$12
  implements FutureCallback<Void>
{
  public void a(Throwable paramThrowable)
  {
    FriendRequestsFragment.a(this.c, "Responding to friend request failed", paramThrowable);
  }

  public void a(Void paramVoid)
  {
    int i;
    FriendRequestsAdapter localFriendRequestsAdapter;
    String str;
    if (this.a == FriendRequestResponse.CONFIRM)
    {
      i = 1;
      localFriendRequestsAdapter = FriendRequestsFragment.a(this.c);
      str = this.b.profile.id;
      if (i == 0)
        break label55;
    }
    label55: for (FriendRequestState localFriendRequestState = FriendRequestState.ACCEPTED; ; localFriendRequestState = FriendRequestState.IGNORED)
    {
      localFriendRequestsAdapter.a(str, localFriendRequestState);
      return;
      i = 0;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestsFragment.12
 * JD-Core Version:    0.6.0
 */