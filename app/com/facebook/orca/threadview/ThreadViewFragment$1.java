package com.facebook.orca.threadview;

import android.app.Activity;
import android.content.Context;
import com.facebook.orca.threadlist.ThreadListActivity;

class ThreadViewFragment$1 extends ThreadViewFragmentBroadcastReceiver
{
  public void a(ThreadViewFragmentBroadcastReceiver.Action paramAction)
  {
    if (paramAction == ThreadViewFragmentBroadcastReceiver.Action.FINISH)
      if ((this.a.n() instanceof ThreadListActivity))
        ThreadViewFragment.a(this.a);
    while (true)
    {
      return;
      ((Activity)this.a.p()).finish();
      continue;
      if (paramAction != ThreadViewFragmentBroadcastReceiver.Action.REFRESH_DATA)
        continue;
      ThreadViewFragment.b(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewFragment.1
 * JD-Core Version:    0.6.0
 */