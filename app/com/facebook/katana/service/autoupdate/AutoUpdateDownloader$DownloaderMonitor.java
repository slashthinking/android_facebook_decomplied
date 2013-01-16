package com.facebook.katana.service.autoupdate;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor.Guard;
import java.util.concurrent.TimeUnit;

class AutoUpdateDownloader$DownloaderMonitor
{
  private final Monitor a;
  private final Monitor.Guard b;
  private final long c;
  private boolean d;

  AutoUpdateDownloader$DownloaderMonitor(long paramLong)
  {
    this.c = paramLong;
    this.a = new Monitor();
    this.b = new AutoUpdateDownloader.DownloaderMonitor.1(this, this.a);
  }

  public void a()
  {
    this.a.a();
  }

  public boolean b()
  {
    return this.a.a(this.b, this.c, TimeUnit.SECONDS);
  }

  public void c()
  {
    this.a.b();
  }

  public void d()
  {
    this.a.a();
    try
    {
      this.d = true;
      return;
    }
    finally
    {
      this.a.b();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AutoUpdateDownloader.DownloaderMonitor
 * JD-Core Version:    0.6.0
 */