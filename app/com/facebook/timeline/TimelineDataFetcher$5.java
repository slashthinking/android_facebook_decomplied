package com.facebook.timeline;

import com.facebook.feed.protocol.FetchParcelableResult;
import com.facebook.graphql.model.FriendListList;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

class TimelineDataFetcher$5
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    FriendListList localFriendListList = (FriendListList)((FetchParcelableResult)paramOperationResult.h()).a;
    TimelineDataFetcher.e(this.a).B().b(localFriendListList);
  }

  public void a(Throwable paramThrowable)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineDataFetcher.5
 * JD-Core Version:    0.6.0
 */