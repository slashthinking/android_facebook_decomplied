package com.facebook.concurrent;

import android.os.Process;

class NamedThreadFactory$1
  implements Runnable
{
  public void run()
  {
    try
    {
      Process.setThreadPriority(NamedThreadFactory.a(this.b));
      label10: this.a.run();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label10;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.concurrent.NamedThreadFactory.1
 * JD-Core Version:    0.6.0
 */