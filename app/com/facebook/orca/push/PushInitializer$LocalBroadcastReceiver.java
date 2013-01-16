package com.facebook.orca.push;

import com.facebook.content.SecureBroadcastReceiver;

public class PushInitializer$LocalBroadcastReceiver extends SecureBroadcastReceiver
{
  public PushInitializer$LocalBroadcastReceiver()
  {
    super("com.facebook.orca.push.ACTION_ALARM", new PushInitializer.AlarmReceiver());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.PushInitializer.LocalBroadcastReceiver
 * JD-Core Version:    0.6.0
 */