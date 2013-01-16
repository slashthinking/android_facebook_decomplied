package com.facebook.friends;

import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.protocol.FetchFriendRequestsMethod.Result;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Function;
import java.util.List;

class FriendingClient$1
  implements Function<OperationResult, List<FriendRequest>>
{
  public List<FriendRequest> a(OperationResult paramOperationResult)
  {
    FetchFriendRequestsMethod.Result localResult = (FetchFriendRequestsMethod.Result)paramOperationResult.h();
    monitorenter;
    try
    {
      this.a.b = localResult.pageInfo;
      return localResult.friendRequests;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendingClient.1
 * JD-Core Version:    0.6.0
 */