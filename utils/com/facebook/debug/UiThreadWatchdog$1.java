package com.facebook.debug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class UiThreadWatchdog$1 extends BroadcastReceiver
{
  UiThreadWatchdog$1(UiThreadWatchdog paramUiThreadWatchdog)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    UiThreadWatchdog.a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.debug.UiThreadWatchdog.1
 * JD-Core Version:    0.6.2
 */