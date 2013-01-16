package com.facebook.appcenter.workflow;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.facebook.appcenter.cache.AppServerStateCache;
import com.facebook.appcenter.model.AppInfo.AppServerState;
import java.io.File;

public class AppWorkflowManager
{
  public static boolean a = false;
  private static final Class<?> b = AppWorkflowManager.class;
  private Context c;
  private AppDownloadController d;
  private AppInstallController e;
  private PackageUtil f;
  private AppServerStateCache g;
  private WorkflowDatabaseHelper h;
  private AppDownloadController.IAppDownloadListener i;
  private AppInstallController.IAppInstallListener j;
  private PackageManager k;
  private AppWorkflowManager.IWorkflowDisplayStateListener l;

  public AppWorkflowManager(Context paramContext, AppServerStateCache paramAppServerStateCache, AppDownloadController paramAppDownloadController, AppInstallController paramAppInstallController, PackageUtil paramPackageUtil, WorkflowDatabaseHelper paramWorkflowDatabaseHelper, PackageManager paramPackageManager)
  {
    this.c = paramContext;
    this.g = paramAppServerStateCache;
    this.d = paramAppDownloadController;
    this.e = paramAppInstallController;
    this.f = paramPackageUtil;
    this.h = paramWorkflowDatabaseHelper;
    this.k = paramPackageManager;
    this.i = a();
    this.j = b();
    a(new AppWorkflowManager.1(this));
  }

  private AppDownloadController.IAppDownloadListener a()
  {
    return new AppWorkflowManager.2(this);
  }

  private void a(String paramString, AppWorkflowManager.DisplayState paramDisplayState)
  {
    if (this.l != null)
      this.l.a(paramString, paramDisplayState);
  }

  private boolean a(AppInfo.AppServerState paramAppServerState)
  {
    if ((!paramAppServerState.c()) || ((!paramAppServerState.b()) && (!paramAppServerState.a())));
    for (int m = 1; ; m = 0)
      return m;
  }

  private boolean a(String paramString, AppInfo.AppServerState paramAppServerState)
  {
    if ((this.f.a(this.h.a(paramString))) && (!a(paramAppServerState)));
    for (int m = 1; ; m = 0)
      return m;
  }

  private AppInstallController.IAppInstallListener b()
  {
    return new AppWorkflowManager.3(this);
  }

  private void c(String paramString)
  {
    a(paramString, AppWorkflowManager.DisplayState.AUTHORIZING);
  }

  private void d(String paramString)
  {
    a(paramString, AppWorkflowManager.DisplayState.BUYING);
  }

  private void e(String paramString)
  {
    a(paramString, AppWorkflowManager.DisplayState.DOWNLOADING);
    File localFile = this.f.b(paramString);
    this.d.a(paramString, "http://www.appsapk.com/wp-content/uploads/apps-3/Chess%20Free.apk", localFile, "AppId: " + paramString, "Downloading...", this.i);
  }

  private void f(String paramString)
  {
    a(paramString, AppWorkflowManager.DisplayState.INSTALLING);
    File localFile = this.f.b(paramString);
    this.e.a(paramString, Uri.fromFile(localFile), this.j);
  }

  private void g(String paramString)
  {
    String str = this.h.a(paramString);
    if (str != null)
    {
      Intent localIntent = this.k.getLaunchIntentForPackage(str);
      this.c.startActivity(localIntent);
    }
  }

  private AppInfo.AppServerState h(String paramString)
  {
    AppInfo.AppServerState localAppServerState = this.g.a(paramString);
    if (localAppServerState == null)
      throw new RuntimeException("server state for appId " + paramString + " is null");
    return localAppServerState;
  }

  private void i(String paramString)
  {
    AppInfo.AppServerState localAppServerState = h(paramString);
    if (!localAppServerState.c())
      c(paramString);
    while (true)
    {
      return;
      if ((!localAppServerState.b()) && (!localAppServerState.a()))
      {
        d(paramString);
        continue;
      }
      if (this.f.a(this.h.a(paramString)))
      {
        a(paramString, AppWorkflowManager.DisplayState.LAUNCH);
        continue;
      }
      if (this.f.a(this.h.b(paramString)))
      {
        f(paramString);
        continue;
      }
      e(paramString);
    }
  }

  public void a(AppWorkflowManager.IWorkflowDisplayStateListener paramIWorkflowDisplayStateListener)
  {
    this.l = paramIWorkflowDisplayStateListener;
  }

  public void a(String paramString)
  {
    if (a(paramString, h(paramString)))
      g(paramString);
    while (true)
    {
      return;
      i(paramString);
    }
  }

  public void a(String paramString, boolean paramBoolean)
  {
    AppInfo.AppServerState localAppServerState = h(paramString);
    if (a(paramString, localAppServerState))
      a(paramString, AppWorkflowManager.DisplayState.LAUNCH);
    while (true)
    {
      return;
      long l1 = this.h.b(paramString);
      if ((!paramBoolean) && (this.f.b(l1)) && (!a(localAppServerState)))
      {
        a(paramString, AppWorkflowManager.DisplayState.DOWNLOADING);
        this.d.a(l1, paramString, this.i);
        continue;
      }
      if (localAppServerState.a())
      {
        a(paramString, AppWorkflowManager.DisplayState.FREE);
        continue;
      }
      if (localAppServerState.b())
      {
        a(paramString, AppWorkflowManager.DisplayState.INSTALL);
        continue;
      }
      a(paramString, AppWorkflowManager.DisplayState.BUY);
    }
  }

  public void b(String paramString)
  {
    a(paramString, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.workflow.AppWorkflowManager
 * JD-Core Version:    0.6.0
 */