package com.facebook.diagnostics;

import android.app.Activity;
import java.util.concurrent.ConcurrentMap;

class FPSController$FPSThread extends Thread
{
  volatile boolean a;

  FPSController$FPSThread(FPSController paramFPSController)
  {
    super("FPS");
  }

  public void run()
  {
    while (true)
      if (!this.a)
        try
        {
          Thread.sleep(10L);
          Activity localActivity = FPSController.b(this.b);
          if (localActivity != null)
          {
            FPSView localFPSView = (FPSView)FPSController.f(this.b).get(localActivity);
            if (localFPSView != null)
              localFPSView.postInvalidate();
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          Thread.currentThread().interrupt();
        }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.diagnostics.FPSController.FPSThread
 * JD-Core Version:    0.6.2
 */