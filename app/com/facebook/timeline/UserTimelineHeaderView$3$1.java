package com.facebook.timeline;

import android.widget.Toast;
import com.facebook.friends.FriendRequestResponse;
import com.google.common.util.concurrent.FutureCallback;

class UserTimelineHeaderView$3$1
  implements FutureCallback<Void>
{
  public void a(Throwable paramThrowable)
  {
    Toast.makeText(this.b.a.getContext(), 2131361832, 1).show();
  }

  public void a(Void paramVoid)
  {
    TimelineDataFetcher localTimelineDataFetcher = this.b.a.getDataFetcher();
    if (this.a == FriendRequestResponse.CONFIRM);
    for (boolean bool = true; ; bool = false)
    {
      localTimelineDataFetcher.d(bool);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.UserTimelineHeaderView.3.1
 * JD-Core Version:    0.6.0
 */