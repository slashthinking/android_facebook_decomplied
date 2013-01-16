package com.facebook.katana.binding;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class WorkerThread
{
  private final Handler a = new Handler(Looper.getMainLooper());
  private final HandlerThread b = new HandlerThread("FB4A Worker");
  private final Handler c;

  public WorkerThread()
  {
    this.b.start();
    this.c = new Handler(this.b.getLooper());
  }

  public Handler a()
  {
    return this.c;
  }

  public Handler b()
  {
    return this.a;
  }

  public void c()
  {
    this.b.quit();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.WorkerThread
 * JD-Core Version:    0.6.0
 */