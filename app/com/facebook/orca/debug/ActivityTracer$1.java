package com.facebook.orca.debug;

import android.os.MessageQueue.IdleHandler;

class ActivityTracer$1
  implements MessageQueue.IdleHandler
{
  public boolean queueIdle()
  {
    if (ActivityTracer.a(this.a) != null)
    {
      if (ActivityTracer.a(this.a).a() <= 20L)
        break label35;
      Tracer.a(ActivityTracer.a());
    }
    while (true)
    {
      return false;
      label35: Tracer.b();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.ActivityTracer.1
 * JD-Core Version:    0.6.0
 */