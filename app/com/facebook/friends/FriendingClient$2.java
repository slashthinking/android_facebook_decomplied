package com.facebook.friends;

import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowMethod.Result;
import com.facebook.orca.server.OperationResult;
import com.google.common.base.Function;
import java.util.List;

class FriendingClient$2
  implements Function<OperationResult, List<PersonYouMayKnow>>
{
  public List<PersonYouMayKnow> a(OperationResult paramOperationResult)
  {
    FetchPeopleYouMayKnowMethod.Result localResult = (FetchPeopleYouMayKnowMethod.Result)paramOperationResult.h();
    monitorenter;
    try
    {
      this.a.a = localResult.pageInfo;
      return localResult.peopleYouMayKnow;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.FriendingClient.2
 * JD-Core Version:    0.6.0
 */