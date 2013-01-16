package com.facebook.orca.config;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.facebook.orca.common.util.StringUtil;

public abstract class AbstractOrcaConfig
  implements OrcaConfig
{
  private static final String a = null;
  private final String b;
  private final TelephonyManager c;
  private final PackageInfo d;

  AbstractOrcaConfig(PackageInfo paramPackageInfo, TelephonyManager paramTelephonyManager)
  {
    this.d = paramPackageInfo;
    this.c = paramTelephonyManager;
    this.b = h();
  }

  private static String a(String paramString)
  {
    if (StringUtil.a(paramString));
    for (String str = "null"; ; str = paramString.replace(" ", "_"))
      return str;
  }

  private String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Orca-Android/");
    localStringBuilder.append(this.d.versionName);
    localStringBuilder.append(" ");
    localStringBuilder.append("OS/");
    localStringBuilder.append(a(Build.VERSION.RELEASE));
    localStringBuilder.append(" ");
    localStringBuilder.append("Model/");
    localStringBuilder.append(a(Build.MODEL));
    localStringBuilder.append(" ");
    localStringBuilder.append("VersionCode/");
    localStringBuilder.append(this.d.versionCode);
    localStringBuilder.append(" ");
    localStringBuilder.append("Product/");
    localStringBuilder.append("Messenger");
    localStringBuilder.append(" ");
    localStringBuilder.append("Carrier/");
    localStringBuilder.append(a(this.c.getNetworkOperatorName()));
    localStringBuilder.append(" ");
    localStringBuilder.append("Manufacturer/");
    localStringBuilder.append(a(Build.MANUFACTURER));
    localStringBuilder.append(" ");
    localStringBuilder.append("Brand/");
    localStringBuilder.append(a(Build.BRAND));
    if (a != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append("Preload/");
      localStringBuilder.append(a(a));
    }
    return localStringBuilder.toString();
  }

  public String a()
  {
    return this.d.versionName;
  }

  public int b()
  {
    return this.d.versionCode;
  }

  public int c()
  {
    return 1;
  }

  public boolean d()
  {
    return false;
  }

  public String e()
  {
    return this.b;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.config.AbstractOrcaConfig
 * JD-Core Version:    0.6.0
 */