package com.facebook.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.protocol.SendFriendRequestMethod.HowFound;
import com.google.common.util.concurrent.Futures;

class UserTimelineHeaderView$4
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    switch (UserTimelineHeaderView.5.a[this.a.u().ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return;
      UserTimelineHeaderView.b(this.c);
      continue;
      Futures.a(this.b.a(this.a.d(), SendFriendRequestMethod.HowFound.PROFILE_BUTTON, null), new UserTimelineHeaderView.RequestFriendCallback(this.c, null));
      this.a.a(TimelineHeaderData.UserFriendshipStatus.OUTGOING_REQUEST);
      UserTimelineHeaderView.c(this.c);
      this.a.a(TimelineHeaderData.SubscribeStatus.IS_SUBSCRIBED);
      this.c.h();
      this.c.getDataFetcher().h();
      UserTimelineHeaderView.b(this.c);
      continue;
      UserTimelineHeaderView.b(this.c);
      continue;
      UserTimelineHeaderView.d(this.c);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.UserTimelineHeaderView.4
 * JD-Core Version:    0.6.0
 */