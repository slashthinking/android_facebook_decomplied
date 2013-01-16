package com.facebook.appcenter.workflow;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import com.facebook.orca.debug.BLog;
import com.google.common.collect.Maps;
import java.io.File;
import java.util.HashMap;

public class AppDownloadController
{
  private Context a;
  private BroadcastReceiver b;
  private HashMap<Long, AppDownloadController.AppDownloadInfo> c;
  private DownloadManager d;
  private WorkflowDatabaseHelper e;

  public AppDownloadController(Context paramContext, DownloadManager paramDownloadManager, WorkflowDatabaseHelper paramWorkflowDatabaseHelper)
  {
    this.a = paramContext;
    this.d = paramDownloadManager;
    this.e = paramWorkflowDatabaseHelper;
    this.c = Maps.a();
    this.b = a();
  }

  private BroadcastReceiver a()
  {
    AppDownloadController.1 local1 = new AppDownloadController.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.DOWNLOAD_COMPLETE");
    this.a.registerReceiver(local1, localIntentFilter);
    return local1;
  }

  public long a(String paramString1, String paramString2, File paramFile, String paramString3, String paramString4, AppDownloadController.IAppDownloadListener paramIAppDownloadListener)
  {
    BLog.a("AppDownloadController", "Started download from url: " + paramString2);
    paramFile.delete();
    DownloadManager.Request localRequest = new DownloadManager.Request(Uri.parse(paramString2));
    localRequest.setTitle(paramString3);
    localRequest.setDescription(paramString4);
    localRequest.setDestinationUri(Uri.fromFile(paramFile));
    long l1 = this.d.enqueue(localRequest);
    long l2 = this.e.b(paramString1);
    this.e.a(paramString1, l1);
    a(l2);
    a(l1, paramString1, paramIAppDownloadListener);
    return l1;
  }

  public void a(long paramLong)
  {
    if (paramLong != -1L)
    {
      this.c.remove(Long.valueOf(paramLong));
      this.d.remove(new long[] { paramLong });
    }
  }

  public void a(long paramLong, String paramString, AppDownloadController.IAppDownloadListener paramIAppDownloadListener)
  {
    this.c.put(Long.valueOf(paramLong), new AppDownloadController.AppDownloadInfo(paramString, paramIAppDownloadListener));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.workflow.AppDownloadController
 * JD-Core Version:    0.6.0
 */