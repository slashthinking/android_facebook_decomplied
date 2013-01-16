package com.facebook.orca.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.orca.debug.BLog;

public abstract class SafeLocalBroadcastReceiver
{
  private static final Class<?> a = SafeLocalBroadcastReceiver.class;
  private final LocalBroadcastManager b;
  private final IntentFilter c;
  private final BroadcastReceiver d;
  private boolean e;

  public SafeLocalBroadcastReceiver(Context paramContext, IntentFilter paramIntentFilter)
  {
    this.b = LocalBroadcastManager.a(paramContext);
    this.c = paramIntentFilter;
    this.d = new SafeLocalBroadcastReceiver.1(this);
  }

  public void a()
  {
    if (this.e)
      BLog.e(a, "Called registerNotificationReceiver twice.");
    while (true)
    {
      return;
      this.b.a(this.d, this.c);
      this.e = true;
    }
  }

  public abstract void a(Context paramContext, Intent paramIntent);

  public void b()
  {
    if (this.e)
    {
      this.b.a(this.d);
      this.e = false;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.SafeLocalBroadcastReceiver
 * JD-Core Version:    0.6.0
 */