package com.facebook.appcenter.workflow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.facebook.orca.debug.BLog;
import java.util.HashMap;

public class AppInstallController
{
  private Context a;
  private BroadcastReceiver b;
  private HashMap<String, AppInstallController.AppInstallInfo> c;
  private PackageManager d;

  public AppInstallController(Context paramContext, PackageManager paramPackageManager)
  {
    this.a = paramContext;
    this.d = paramPackageManager;
    this.c = new HashMap();
    this.b = a();
  }

  private BroadcastReceiver a()
  {
    AppInstallController.1 local1 = new AppInstallController.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
    localIntentFilter.addDataScheme("package");
    this.a.registerReceiver(local1, localIntentFilter);
    return local1;
  }

  public void a(String paramString, Uri paramUri, AppInstallController.IAppInstallListener paramIAppInstallListener)
  {
    PackageInfo localPackageInfo = this.d.getPackageArchiveInfo(paramUri.getPath(), 4096);
    String str = null;
    if (localPackageInfo != null)
      str = localPackageInfo.packageName;
    if ((localPackageInfo == null) || (str == null))
      paramIAppInstallListener.b(paramString);
    while (true)
    {
      return;
      this.c.put(str, new AppInstallController.AppInstallInfo(paramString, paramIAppInstallListener));
      BLog.a("AppInstallController", "the package name of this binary : " + str);
      BLog.a("AppInstallController", "starting install: " + paramUri);
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(paramUri, "application/vnd.android.package-archive");
      localIntent.setFlags(268435460);
      this.a.startActivity(localIntent);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.workflow.AppInstallController
 * JD-Core Version:    0.6.0
 */