package com.facebook.app;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.facebook.base.BuildConstants;

public abstract class DelegatingApplication<T extends ApplicationLike> extends Application
{
  private T a;

  private void d()
  {
    monitorenter;
    try
    {
      if (this.a == null)
        this.a = a();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  protected abstract T a();

  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    e();
    b();
    d();
  }

  protected void b()
  {
  }

  protected T c()
  {
    d();
    return this.a;
  }

  protected void e()
  {
    boolean bool1 = true;
    try
    {
      ApplicationInfo localApplicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
      boolean bool2;
      if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null) && ("release".equals(localApplicationInfo.metaData.getString("com.facebook.package_type"))))
      {
        bool2 = bool1;
        if (bool2)
          break label64;
      }
      while (true)
      {
        BuildConstants.a(bool1);
        label57: return;
        bool2 = false;
        break;
        label64: bool1 = false;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label57;
    }
  }

  public void onCreate()
  {
    super.onCreate();
    d();
    this.a.b();
  }

  public void onLowMemory()
  {
    super.onLowMemory();
    d();
    this.a.c();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.app.DelegatingApplication
 * JD-Core Version:    0.6.0
 */