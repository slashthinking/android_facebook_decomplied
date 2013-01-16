package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;

public abstract class ThreadViewFragmentBroadcastReceiver extends SafeLocalBroadcastReceiver
{
  private String a;
  private boolean b;

  public ThreadViewFragmentBroadcastReceiver(Context paramContext)
  {
    super(paramContext, d());
  }

  private static IntentFilter d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.orca.ACTION_THREAD_CACHE_CLEARED");
    localIntentFilter.addAction("com.facebook.orca.ACTION_THREAD_UPDATED_FOR_UI");
    localIntentFilter.addAction("com.facebook.orca.ACTION_REMOVED_THREAD_FOR_UI");
    localIntentFilter.addAction("com.facebook.orca.ACTION_PERSISTENT_CHANNEL_STATE_CHANGED");
    return localIntentFilter;
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    ThreadViewFragmentBroadcastReceiver.Action localAction;
    if ("com.facebook.orca.ACTION_THREAD_CACHE_CLEARED".equals(str1))
      localAction = ThreadViewFragmentBroadcastReceiver.Action.FINISH;
    while (true)
    {
      if (localAction != null)
        a(localAction);
      return;
      if ("com.facebook.orca.ACTION_PERSISTENT_CHANNEL_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        localAction = ThreadViewFragmentBroadcastReceiver.Action.REFRESH_DATA;
        continue;
      }
      boolean bool1 = this.b;
      localAction = null;
      if (!bool1)
        continue;
      String str2 = paramIntent.getStringExtra("threadid");
      String str3 = this.a;
      localAction = null;
      if (str3 == null)
        continue;
      boolean bool2 = this.a.equals(str2);
      localAction = null;
      if (!bool2)
        continue;
      if ("com.facebook.orca.ACTION_THREAD_UPDATED_FOR_UI".equals(str1))
      {
        localAction = ThreadViewFragmentBroadcastReceiver.Action.REFRESH_DATA;
        continue;
      }
      boolean bool3 = "com.facebook.orca.ACTION_REMOVED_THREAD_FOR_UI".equals(str1);
      localAction = null;
      if (!bool3)
        continue;
      localAction = ThreadViewFragmentBroadcastReceiver.Action.FINISH;
    }
  }

  public abstract void a(ThreadViewFragmentBroadcastReceiver.Action paramAction);

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewFragmentBroadcastReceiver
 * JD-Core Version:    0.6.0
 */