package com.ooqqxx.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Processor extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (NativeCall.onReceiveBroadcast(paramContext, paramIntent))
      abortBroadcast();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.ooqqxx.stat.Processor
 * JD-Core Version:    0.6.0
 */