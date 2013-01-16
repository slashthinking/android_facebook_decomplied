package com.facebook.timeline;

import android.widget.Toast;
import com.google.common.util.concurrent.FutureCallback;

class UserTimelineHeaderView$RequestFriendCallback
  implements FutureCallback<Void>
{
  private UserTimelineHeaderView$RequestFriendCallback(UserTimelineHeaderView paramUserTimelineHeaderView)
  {
  }

  public void a(Throwable paramThrowable)
  {
    this.a.getHeaderData().a(TimelineHeaderData.UserFriendshipStatus.CAN_REQUEST);
    UserTimelineHeaderView.c(this.a);
    Toast.makeText(this.a.getContext(), 2131361822, 1).show();
  }

  public void a(Void paramVoid)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.UserTimelineHeaderView.RequestFriendCallback
 * JD-Core Version:    0.6.0
 */