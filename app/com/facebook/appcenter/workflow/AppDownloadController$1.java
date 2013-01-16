package com.facebook.appcenter.workflow;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.facebook.orca.debug.BLog;
import java.util.HashMap;

class AppDownloadController$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Long localLong;
    AppDownloadController.IAppDownloadListener localIAppDownloadListener;
    if ("android.intent.action.DOWNLOAD_COMPLETE".equals(paramIntent.getAction()))
    {
      localLong = Long.valueOf(paramIntent.getExtras().getLong("extra_download_id"));
      if (AppDownloadController.a(this.a).containsKey(localLong))
      {
        localIAppDownloadListener = ((AppDownloadController.AppDownloadInfo)AppDownloadController.a(this.a).get(localLong)).b();
        if (localIAppDownloadListener != null)
        {
          DownloadManager.Query localQuery = new DownloadManager.Query();
          long[] arrayOfLong = new long[1];
          arrayOfLong[0] = localLong.longValue();
          localQuery.setFilterById(arrayOfLong);
          Cursor localCursor = AppDownloadController.b(this.a).query(localQuery);
          if (localCursor.moveToFirst())
          {
            int i = localCursor.getInt(localCursor.getColumnIndex("reason"));
            long l = localCursor.getLong(localCursor.getColumnIndex("total_size"));
            String str = localCursor.getString(localCursor.getColumnIndex("local_uri"));
            BLog.a("AppDownloadReceiver", "Reason: " + i);
            BLog.a("AppDownloadReceiver", "Bytes: " + l);
            BLog.a("AppDownloadReceiver", "localURI: " + str);
            int j = localCursor.getInt(localCursor.getColumnIndex("status"));
            BLog.a("AppDownloadReceiver", "Status: " + j);
            if ((8 != j) || (l <= 0L))
              break label368;
            localIAppDownloadListener.a(localLong.longValue(), ((AppDownloadController.AppDownloadInfo)AppDownloadController.a(this.a).get(localLong)).a());
            BLog.a("AppDownloadReceiver", "download successful: " + localLong);
          }
        }
      }
    }
    while (true)
    {
      AppDownloadController.a(this.a).remove(localLong);
      return;
      label368: localIAppDownloadListener.a(((AppDownloadController.AppDownloadInfo)AppDownloadController.a(this.a).get(localLong)).a());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.workflow.AppDownloadController.1
 * JD-Core Version:    0.6.0
 */