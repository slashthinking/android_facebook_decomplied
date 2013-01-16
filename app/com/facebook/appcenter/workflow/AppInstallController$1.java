package com.facebook.appcenter.workflow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.orca.debug.BLog;
import java.util.HashMap;

class AppInstallController$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getData().toString().replaceFirst("package:", "");
    String str2 = paramIntent.getAction();
    AppInstallController.AppInstallInfo localAppInstallInfo = (AppInstallController.AppInstallInfo)AppInstallController.a(this.a).get(str1);
    if (localAppInstallInfo == null);
    while (true)
    {
      return;
      String str3 = localAppInstallInfo.a();
      AppInstallController.IAppInstallListener localIAppInstallListener = localAppInstallInfo.b();
      if ("android.intent.action.PACKAGE_ADDED".equals(str2))
      {
        BLog.a("AppInstallReceiver", "Package Added = " + str1);
        localIAppInstallListener.a(str3);
        continue;
      }
      if ("android.intent.action.PACKAGE_CHANGED".equals(str2))
      {
        BLog.a("AppInstallReceiver", "Package Changed = " + str1);
        continue;
      }
      if (!"android.intent.action.PACKAGE_REPLACED".equals(str2))
        continue;
      BLog.a("AppInstallReceiver", "Package Replaced = " + str1);
      localIAppInstallListener.a(str3);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.workflow.AppInstallController.1
 * JD-Core Version:    0.6.0
 */