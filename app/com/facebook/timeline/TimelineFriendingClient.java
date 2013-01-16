package com.facebook.timeline;

import android.content.Context;
import com.facebook.friends.FriendingClient;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public class TimelineFriendingClient
{
  private final Context a;
  private final FriendingClient b;
  private final TimelineHeaderData c;
  private final TimelineDataFetcher d;

  public TimelineFriendingClient(Context paramContext, FriendingClient paramFriendingClient, TimelineHeaderData paramTimelineHeaderData, TimelineDataFetcher paramTimelineDataFetcher)
  {
    this.a = ((Context)Preconditions.checkNotNull(paramContext));
    this.b = ((FriendingClient)Preconditions.checkNotNull(paramFriendingClient));
    this.c = ((TimelineHeaderData)Preconditions.checkNotNull(paramTimelineHeaderData));
    this.d = ((TimelineDataFetcher)Preconditions.checkNotNull(paramTimelineDataFetcher));
  }

  private void b()
  {
    TimelineHeaderData.SubscribeStatus localSubscribeStatus1 = this.c.v();
    TimelineHeaderData localTimelineHeaderData = this.c;
    if (localSubscribeStatus1 == TimelineHeaderData.SubscribeStatus.IS_SUBSCRIBED);
    for (TimelineHeaderData.SubscribeStatus localSubscribeStatus2 = TimelineHeaderData.SubscribeStatus.CAN_SUBSCRIBE; ; localSubscribeStatus2 = TimelineHeaderData.SubscribeStatus.IS_SUBSCRIBED)
    {
      localTimelineHeaderData.a(localSubscribeStatus2);
      return;
    }
  }

  public FriendingClient a()
  {
    return this.b;
  }

  public ListenableFuture<Void> a(boolean paramBoolean)
  {
    TimelineHeaderData localTimelineHeaderData = this.c;
    TimelineHeaderData.SubscribeStatus localSubscribeStatus;
    long l;
    if (paramBoolean)
    {
      localSubscribeStatus = TimelineHeaderData.SubscribeStatus.IS_SUBSCRIBED;
      localTimelineHeaderData.a(localSubscribeStatus);
      l = this.c.d();
      if (!paramBoolean)
        break label73;
    }
    label73: for (ListenableFuture localListenableFuture = this.b.d(l); ; localListenableFuture = this.b.e(l))
    {
      SettableFuture localSettableFuture = SettableFuture.c();
      Futures.a(localListenableFuture, new TimelineFriendingClient.1(this, localSettableFuture, paramBoolean));
      return localSettableFuture;
      localSubscribeStatus = TimelineHeaderData.SubscribeStatus.CAN_SUBSCRIBE;
      break;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFriendingClient
 * JD-Core Version:    0.6.0
 */