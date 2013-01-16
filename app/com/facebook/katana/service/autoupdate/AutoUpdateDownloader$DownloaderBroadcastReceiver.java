package com.facebook.katana.service.autoupdate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class AutoUpdateDownloader$DownloaderBroadcastReceiver extends BroadcastReceiver
{
  private final AutoUpdateDownloader.DownloaderMonitor b;
  private long c = -1L;

  public AutoUpdateDownloader$DownloaderBroadcastReceiver(AutoUpdateDownloader paramAutoUpdateDownloader, AutoUpdateDownloader.DownloaderMonitor paramDownloaderMonitor)
  {
    this.b = paramDownloaderMonitor;
  }

  public void a(long paramLong)
  {
    this.c = paramLong;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getExtras().getLong("extra_download_id") != this.c);
    while (true)
    {
      return;
      this.b.d();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AutoUpdateDownloader.DownloaderBroadcastReceiver
 * JD-Core Version:    0.6.0
 */