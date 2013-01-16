package com.facebook.orca.presence;

import com.facebook.orca.debug.BLog;
import com.google.common.util.concurrent.FutureCallback;

class PresenceManager$4
  implements FutureCallback<Void>
{
  public void a(Throwable paramThrowable)
  {
    PresenceManager.a(this.a, false);
    BLog.c(PresenceManager.j(), "Failed to load facebook users", paramThrowable);
  }

  public void a(Void paramVoid)
  {
    PresenceManager.d(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.presence.PresenceManager.4
 * JD-Core Version:    0.6.0
 */