package com.facebook.katana.platform;

import android.content.Context;

public class Permission
{
  private final int a;
  private final String b;
  private final Permission.Bucket c;
  private final int d;

  public Permission(int paramInt1, String paramString, Permission.Bucket paramBucket, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramBucket;
    this.d = paramInt2;
  }

  public int a()
  {
    return this.a;
  }

  public String a(Context paramContext)
  {
    return paramContext.getString(this.d);
  }

  public Permission.Bucket b()
  {
    return this.c;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.Permission
 * JD-Core Version:    0.6.0
 */