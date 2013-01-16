package com.facebook.appcenter.workflow;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.os.Environment;
import java.io.File;

public class PackageUtil
{
  private Context a;
  private DownloadManager b;
  private PackageManager c;

  public PackageUtil(Context paramContext, DownloadManager paramDownloadManager, PackageManager paramPackageManager)
  {
    this.a = paramContext;
    this.b = paramDownloadManager;
    this.c = paramPackageManager;
  }

  private int c(long paramLong)
  {
    DownloadManager.Query localQuery = new DownloadManager.Query();
    localQuery.setFilterById(new long[] { paramLong });
    Cursor localCursor = this.b.query(localQuery);
    boolean bool = localCursor.moveToFirst();
    int i = 0;
    if (bool)
      i = localCursor.getInt(localCursor.getColumnIndex("status"));
    return i;
  }

  public boolean a(long paramLong)
  {
    if (c(paramLong) == 8);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean a(String paramString)
  {
    Object localObject = null;
    if (paramString != null);
    try
    {
      PackageInfo localPackageInfo = this.c.getPackageInfo(paramString, 0);
      localObject = localPackageInfo;
      int i = 0;
      if (localObject != null)
        i = 1;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        localObject = null;
    }
  }

  public File b(String paramString)
  {
    return new File(this.a.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "fbapp_" + paramString + ".apk");
  }

  public boolean b(long paramLong)
  {
    if (c(paramLong) == 2);
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.workflow.PackageUtil
 * JD-Core Version:    0.6.0
 */