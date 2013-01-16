package com.facebook.katana;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.common.util.Log;
import com.facebook.katana.provider.KeyValueManager;

public class FB4AVersion
{
  private static final Class<?> c = FB4AVersion.class;
  private static final FB4AVersion d = new FB4AVersion();
  private Long a = null;
  private Long b = null;

  public static FB4AVersion a(Context paramContext)
  {
    if (d.a == null)
      d.d(paramContext);
    return d;
  }

  private void d(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo2 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      localPackageInfo1 = localPackageInfo2;
      if (localPackageInfo1 != null)
      {
        this.a = Long.valueOf(localPackageInfo1.versionCode);
        this.b = Long.valueOf(KeyValueManager.a(paramContext, "last_run_build", -1L));
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        Log.a(c, "Cannot get package manager", localNameNotFoundException);
        PackageInfo localPackageInfo1 = null;
        continue;
        this.a = Long.valueOf(-1L);
      }
    }
  }

  public boolean a()
  {
    if (this.b.longValue() < this.a.longValue());
    for (int i = 1; ; i = 0)
      return i;
  }

  public void b(Context paramContext)
  {
    KeyValueManager.a(paramContext, "last_run_build", this.a);
  }

  public boolean b()
  {
    if (this.b.longValue() == -1L);
    for (int i = 1; ; i = 0)
      return i;
  }

  public long c()
  {
    return this.a.longValue();
  }

  public long c(Context paramContext)
  {
    KeyValueManager.a(paramContext, "last_run_build", Long.valueOf(this.a.longValue() - 1L));
    return this.a.longValue() - 1L;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FB4AVersion
 * JD-Core Version:    0.6.0
 */