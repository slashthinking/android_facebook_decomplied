package com.facebook.feed.util;

import android.app.Activity;
import android.content.IntentFilter;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;

public abstract class FeedNetworkConnectivityReceiver extends SafeLocalBroadcastReceiver
{
  public FeedNetworkConnectivityReceiver(Activity paramActivity)
  {
    super(paramActivity, d());
    a();
  }

  private static IntentFilter d()
  {
    return new IntentFilter("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FeedNetworkConnectivityReceiver
 * JD-Core Version:    0.6.0
 */