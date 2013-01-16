package com.facebook.katana.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.dialog.InstallMessengerApkActivity;
import com.facebook.orca.activity.AbstractFbActivityListener;
import com.facebook.orca.threadlist.ThreadListActivity;

public class InstallMessengerApkDialogInjector extends AbstractFbActivityListener
{
  private boolean i(Activity paramActivity)
  {
    try
    {
      PackageInfo localPackageInfo = paramActivity.getPackageManager().getPackageInfo("com.facebook.orca", 0);
      i = 0;
      if (localPackageInfo != null)
        i = 1;
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        int i = 0;
    }
  }

  public void f(Activity paramActivity)
  {
    if ((!(paramActivity instanceof ThreadListActivity)) || (i(paramActivity)) || (AppSession.b(paramActivity, false) == null));
    while (true)
    {
      return;
      if (InstallMessengerApkActivity.a(paramActivity))
      {
        paramActivity.startActivity(new Intent(paramActivity, InstallMessengerApkActivity.class));
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.InstallMessengerApkDialogInjector
 * JD-Core Version:    0.6.0
 */