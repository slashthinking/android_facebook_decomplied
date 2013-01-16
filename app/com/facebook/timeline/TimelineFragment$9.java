package com.facebook.timeline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.feed.util.FeedNetworkConnectivityReceiver;
import com.facebook.orca.net.OrcaNetworkManager;

class TimelineFragment$9 extends FeedNetworkConnectivityReceiver
{
  public void a(Context paramContext, Intent paramIntent)
  {
    boolean bool = this.a.b.b();
    if ((TimelineFragment.g(this.a) != null) && (TimelineFragment.g(this.a).getVisibility() != 0))
    {
      if (!bool)
        break label46;
      TimelineFragment.h(this.a);
    }
    while (true)
    {
      return;
      label46: TimelineFragment.a(this.a, 2131362130);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineFragment.9
 * JD-Core Version:    0.6.0
 */