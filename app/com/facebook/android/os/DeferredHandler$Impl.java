package com.facebook.android.os;

import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import java.util.LinkedList;

class DeferredHandler$Impl extends Handler
  implements MessageQueue.IdleHandler
{
  private DeferredHandler$Impl(DeferredHandler paramDeferredHandler)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    synchronized (DeferredHandler.a(this.a))
    {
      if (DeferredHandler.a(this.a).size() != 0)
      {
        Runnable localRunnable = (Runnable)DeferredHandler.a(this.a).removeFirst();
        localRunnable.run();
        synchronized (DeferredHandler.a(this.a))
        {
          this.a.b();
        }
      }
    }
  }

  public boolean queueIdle()
  {
    handleMessage(null);
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.android.os.DeferredHandler.Impl
 * JD-Core Version:    0.6.0
 */