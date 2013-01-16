package com.facebook.timeline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.friends.FriendingClient;
import com.google.common.util.concurrent.Futures;

class TimelineActionMenu$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Futures.a(TimelineActionMenu.f(this.a).a(TimelineActionMenu.b(this.a).c(), TimelineActionMenu.b(this.a).d()), new TimelineActionMenu.5.1(this));
    Intent localIntent = TimelineActionMenu.d(this.a).b(TimelineActionMenu.c(this.a), "fb://feed");
    TimelineActionMenu.h(this.a).a(localIntent, TimelineActionMenu.c(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineActionMenu.5
 * JD-Core Version:    0.6.0
 */