package com.facebook.timeline.ui;

import android.widget.Toast;
import com.facebook.timeline.TimelineDataFetcher;
import com.google.common.util.concurrent.FutureCallback;

class TimelineFriendDialog$5$1
  implements FutureCallback<Void>
{
  public void a(Throwable paramThrowable)
  {
    TimelineFriendDialog.e(this.a.a).g();
    Toast.makeText(TimelineFriendDialog.f(this.a.a), 2131361833, 1).show();
  }

  public void a(Void paramVoid)
  {
    TimelineFriendDialog.e(this.a.a).g();
    TimelineFriendDialog.e(this.a.a).e();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.ui.TimelineFriendDialog.5.1
 * JD-Core Version:    0.6.0
 */