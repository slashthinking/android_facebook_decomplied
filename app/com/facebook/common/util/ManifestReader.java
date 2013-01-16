package com.facebook.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.facebook.orca.debug.BLog;
import com.google.common.base.Preconditions;

public class ManifestReader
{
  private final Context a;

  public ManifestReader(Context paramContext)
  {
    this.a = ((Context)Preconditions.checkNotNull(paramContext));
  }

  public String a(String paramString)
  {
    try
    {
      ApplicationInfo localApplicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
      str = null;
      if (localApplicationInfo != null)
      {
        Bundle localBundle = localApplicationInfo.metaData;
        str = null;
        if (localBundle != null)
          str = localApplicationInfo.metaData.getString(paramString);
      }
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        BLog.e(ManifestReader.class, "Error reading <meta-data> from AndroidManifest.xml.", localNameNotFoundException);
        String str = null;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.ManifestReader
 * JD-Core Version:    0.6.0
 */