package com.facebook.katana.service.autoupdate;

import android.app.DownloadManager;
import android.content.Context;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class AutoUpdateModule$AutoUpdateDownloaderProvider extends AbstractProvider<AutoUpdateDownloader>
{
  private AutoUpdateModule$AutoUpdateDownloaderProvider(AutoUpdateModule paramAutoUpdateModule)
  {
  }

  public AutoUpdateDownloader a()
  {
    return new AutoUpdateDownloader((AutoUpdateNotifier)b(AutoUpdateNotifier.class), (Context)b(Context.class), (DownloadManager)b(DownloadManager.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (FbErrorReporter)b(FbErrorReporter.class), 900L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AutoUpdateModule.AutoUpdateDownloaderProvider
 * JD-Core Version:    0.6.0
 */