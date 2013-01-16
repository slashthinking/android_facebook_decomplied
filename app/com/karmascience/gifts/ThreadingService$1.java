package com.karmascience.gifts;

import android.os.Handler;
import android.os.Looper;

class ThreadingService$1
  implements Runnable
{
  public void run()
  {
    Looper.prepare();
    synchronized (this.a)
    {
      ThreadingService.a(this.a, new Handler());
      Looper.loop();
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.ThreadingService.1
 * JD-Core Version:    0.6.0
 */