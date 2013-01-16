package com.facebook.katana.service.autoupdate;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;

public class AutoUpdateDownloader
{
  private final Context a;
  private final DownloadManager b;
  private final AutoUpdateNotifier c;
  private final OrcaSharedPreferences d;
  private final FbErrorReporter e;
  private final long f;

  public AutoUpdateDownloader(AutoUpdateNotifier paramAutoUpdateNotifier, Context paramContext, DownloadManager paramDownloadManager, OrcaSharedPreferences paramOrcaSharedPreferences, FbErrorReporter paramFbErrorReporter, long paramLong)
  {
    this.c = paramAutoUpdateNotifier;
    this.a = paramContext;
    this.b = paramDownloadManager;
    this.d = paramOrcaSharedPreferences;
    this.e = paramFbErrorReporter;
    this.f = paramLong;
  }

  private String a(TaggedBuildInfo paramTaggedBuildInfo)
  {
    try
    {
      int i = this.d.a(AutoUpdateConstants.f, -1);
      str = this.d.a(AutoUpdateConstants.g, null);
      int j = paramTaggedBuildInfo.mNewVersion;
      if ((i == j) && (str != null))
        return str;
    }
    catch (ClassCastException localClassCastException)
    {
      while (true)
      {
        this.e.a("AutoUploadDownloader.getDownloadedFileForBuild", "Stored download file data type does not match: " + localClassCastException.getMessage());
        String str = null;
      }
    }
    catch (Exception localException)
    {
      while (true)
        this.e.a("AutoUploadDownloader.getDownloadedFileForBuild", "Error getting stored downloaded files data: " + localException.getMessage());
    }
  }

  private void a(long paramLong, String paramString, TaggedBuildInfo paramTaggedBuildInfo, boolean paramBoolean)
  {
    DownloadManager.Query localQuery = new DownloadManager.Query();
    localQuery.setFilterById(new long[] { paramLong });
    Cursor localCursor = this.b.query(localQuery);
    try
    {
      if (!localCursor.moveToFirst())
        throw new AutoUpdateServiceException("Empty DownloadManager cursor");
    }
    catch (AutoUpdateServiceException localAutoUpdateServiceException)
    {
      this.e.a("AutoUpdateService", localAutoUpdateServiceException.getMessage(), false);
      int i;
      int j;
      while (true)
      {
        return;
        i = localCursor.getInt(localCursor.getColumnIndex("status"));
        j = localCursor.getInt(localCursor.getColumnIndex("reason"));
        String str = localCursor.getString(localCursor.getColumnIndex("local_filename"));
        if (i != 8)
          break;
        this.d.b().a(AutoUpdateConstants.f, paramTaggedBuildInfo.mNewVersion).a(AutoUpdateConstants.g, str).a();
        this.c.a(this.a, str, paramBoolean);
        localCursor.close();
      }
      throw new AutoUpdateServiceException("Download failed with status " + i + " and reason " + j);
    }
    finally
    {
      localCursor.close();
    }
    throw localObject;
  }

  @SuppressLint({"NewApi"})
  public void a(String paramString, TaggedBuildInfo paramTaggedBuildInfo, boolean paramBoolean)
  {
    String str1 = a(paramTaggedBuildInfo);
    if (str1 != null)
      this.c.a(this.a, str1, paramBoolean);
    while (true)
    {
      return;
      DownloadManager.Request localRequest = new DownloadManager.Request(Uri.parse(paramTaggedBuildInfo.mNewVersionUrl));
      localRequest.setTitle(this.a.getResources().getString(2131362970));
      CookieSyncManager.createInstance(this.a);
      String str2 = CookieManager.getInstance().getCookie(paramTaggedBuildInfo.mNewVersionUrl);
      if ((str2 == null) || (!str2.contains("c_user=")))
        continue;
      localRequest.addRequestHeader("Cookie", str2);
      localRequest.addRequestHeader("Accept", "application/octet-stream");
      AutoUpdateDownloader.DownloaderMonitor localDownloaderMonitor = new AutoUpdateDownloader.DownloaderMonitor(this.f);
      AutoUpdateDownloader.DownloaderBroadcastReceiver localDownloaderBroadcastReceiver = new AutoUpdateDownloader.DownloaderBroadcastReceiver(this, localDownloaderMonitor);
      this.a.registerReceiver(localDownloaderBroadcastReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
      long l = this.b.enqueue(localRequest);
      localDownloaderBroadcastReceiver.a(l);
      boolean bool = false;
      localDownloaderMonitor.a();
      try
      {
        bool = localDownloaderMonitor.b();
        this.a.unregisterReceiver(localDownloaderBroadcastReceiver);
        localDownloaderMonitor.c();
        if (!bool)
          continue;
        a(l, paramString, paramTaggedBuildInfo, paramBoolean);
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
        {
          Thread.currentThread();
          Thread.interrupted();
          localDownloaderMonitor.c();
        }
      }
      finally
      {
        localDownloaderMonitor.c();
      }
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AutoUpdateDownloader
 * JD-Core Version:    0.6.0
 */