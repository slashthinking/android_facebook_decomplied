package com.facebook.timeline;

import android.widget.Toast;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;

class TimelineFriendingClient$1
  implements FutureCallback<Void>
{
  public void a(Throwable paramThrowable)
  {
    TimelineFriendingClient.b(this.c);
    TimelineFriendingClient.a(this.c).h();
    if (this.b);
    for (int i = 2131361813; ; i = 2131361814)
    {
      Toast.makeText(TimelineFriendingClient.c(this.c), i, 1).show();
      this.a.a_(paramThrowable);
      return;
    }
  }

  public void a(Void paramVoid)
  {
    TimelineFriendingClient.a(this.c).h();
    this.a.a_(paramVoid);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFriendingClient.1
 * JD-Core Version:    0.6.0
 */