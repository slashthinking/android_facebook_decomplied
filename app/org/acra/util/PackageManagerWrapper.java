package org.acra.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import org.acra.ACRA;

public final class PackageManagerWrapper
{
  private final Context context;

  public PackageManagerWrapper(Context paramContext)
  {
    this.context = paramContext;
  }

  public PackageInfo getPackageInfo()
  {
    PackageManager localPackageManager = this.context.getPackageManager();
    Object localObject = null;
    if (localPackageManager == null);
    while (true)
    {
      return localObject;
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(this.context.getPackageName(), 0);
        localObject = localPackageInfo;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.v(ACRA.LOG_TAG, "Failed to find PackageInfo for current App : " + this.context.getPackageName());
        localObject = null;
      }
      catch (RuntimeException localRuntimeException)
      {
        localObject = null;
      }
    }
  }

  public boolean hasPermission(String paramString)
  {
    PackageManager localPackageManager = this.context.getPackageManager();
    int i = 0;
    if (localPackageManager == null);
    while (true)
    {
      return i;
      try
      {
        int j = localPackageManager.checkPermission(paramString, this.context.getPackageName());
        i = 0;
        if (j != 0)
          continue;
        i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        i = 0;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.PackageManagerWrapper
 * JD-Core Version:    0.6.0
 */