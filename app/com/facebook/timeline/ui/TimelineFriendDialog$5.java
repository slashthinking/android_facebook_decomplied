package com.facebook.timeline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.friends.FriendingClient;
import com.facebook.timeline.TimelineFriendingClient;
import com.facebook.timeline.TimelineHeaderData;
import com.google.common.util.concurrent.Futures;

class TimelineFriendDialog$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a();
    Futures.a(TimelineFriendDialog.a(this.a).a().c(TimelineFriendDialog.d(this.a).d()), new TimelineFriendDialog.5.1(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.ui.TimelineFriendDialog.5
 * JD-Core Version:    0.6.0
 */