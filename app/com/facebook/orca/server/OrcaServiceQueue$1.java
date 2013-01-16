package com.facebook.orca.server;

import android.os.HandlerThread;
import com.google.common.util.concurrent.ListenableFuture;

class OrcaServiceQueue$1
  implements Runnable
{
  public void run()
  {
    if (OrcaServiceQueue.a(this.a) != null)
      OrcaServiceQueue.a(this.a).quit();
    if (OrcaServiceQueue.b(this.a) != null)
      OrcaServiceQueue.OperationHolder.a(OrcaServiceQueue.b(this.a)).cancel(false);
    OrcaServiceQueue.a(this.a, null);
    OrcaServiceQueue.a(this.a, null);
    OrcaServiceQueue.c(this.a).b(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OrcaServiceQueue.1
 * JD-Core Version:    0.6.0
 */