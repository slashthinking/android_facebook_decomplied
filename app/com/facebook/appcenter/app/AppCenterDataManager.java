package com.facebook.appcenter.app;

import android.content.Context;
import com.facebook.appcenter.cache.AppCategoryCache;
import com.facebook.appcenter.cache.AppServerStateCache;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.prefs.OrcaSharedPreferences;

public class AppCenterDataManager
  implements INeedInit
{
  private final Context a;
  private final AppServerStateCache b;
  private final OrcaSharedPreferences c;
  private final AppCategoryCache d;
  private int e;

  public AppCenterDataManager(Context paramContext, AppServerStateCache paramAppServerStateCache, OrcaSharedPreferences paramOrcaSharedPreferences, AppCategoryCache paramAppCategoryCache)
  {
    this.a = paramContext;
    this.b = paramAppServerStateCache;
    this.e = 0;
    this.c = paramOrcaSharedPreferences;
    this.d = paramAppCategoryCache;
  }

  public void a(int paramInt)
  {
    this.e = paramInt;
  }

  public int b()
  {
    return this.e;
  }

  public void i_()
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.app.AppCenterDataManager
 * JD-Core Version:    0.6.0
 */