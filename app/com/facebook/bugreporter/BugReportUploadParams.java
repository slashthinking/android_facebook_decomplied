package com.facebook.bugreporter;

import android.net.Uri;
import com.google.common.collect.ImmutableList;

public class BugReportUploadParams
{
  private final String a;
  private final ImmutableList<Uri> b;
  private final String c;
  private final ImmutableList<Long> d;
  private final String e;
  private final String f;

  public BugReportUploadParams(String paramString1, ImmutableList<Uri> paramImmutableList, String paramString2, ImmutableList<Long> paramImmutableList1, String paramString3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramImmutableList;
    this.c = paramString2;
    this.d = paramImmutableList1;
    this.e = paramString3;
    this.f = paramString4;
  }

  public String a()
  {
    return this.a;
  }

  public ImmutableList<Uri> b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public ImmutableList<Long> d()
  {
    return this.d;
  }

  public String e()
  {
    return this.e;
  }

  public String f()
  {
    return this.f;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReportUploadParams
 * JD-Core Version:    0.6.0
 */