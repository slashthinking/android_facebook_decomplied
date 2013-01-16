package com.facebook.katana.service.vault.methods;

import android.os.Build;

public class VaultDevicePostParams
{
  private final String a;
  private final String b = f();
  private final Boolean c;
  private final String d;
  private final Boolean e;

  public VaultDevicePostParams(String paramString)
  {
    this.a = paramString;
    this.c = null;
    this.d = null;
    this.e = null;
  }

  public VaultDevicePostParams(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    this.a = paramString1;
    this.c = Boolean.valueOf(paramBoolean1);
    this.d = paramString2;
    this.e = Boolean.valueOf(paramBoolean2);
  }

  private static String f()
  {
    String str1 = Build.MANUFACTURER;
    if ((str1 == null) || (str1.length() == 0));
    for (String str2 = Build.MODEL; ; str2 = Character.toUpperCase(str1.charAt(0)) + str1.substring(1) + " " + Build.MODEL)
      return str2;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public Boolean c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public Boolean e()
  {
    return this.e;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.vault.methods.VaultDevicePostParams
 * JD-Core Version:    0.6.0
 */