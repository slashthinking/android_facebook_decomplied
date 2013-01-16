package com.facebook.debug;

import android.os.MessageQueue.IdleHandler;

class UiThreadWatchdog$4
  implements MessageQueue.IdleHandler
{
  UiThreadWatchdog$4(UiThreadWatchdog paramUiThreadWatchdog)
  {
  }

  public boolean queueIdle()
  {
    UiThreadWatchdog.d(this.a);
    return UiThreadWatchdog.e(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.debug.UiThreadWatchdog.4
 * JD-Core Version:    0.6.2
 */