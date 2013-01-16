package com.facebook.bugreporter;

import android.net.Uri;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class BugReportBuilder
{
  private Uri a;
  private String b;
  private Uri c;
  private Uri d;
  private String e;
  private List<Long> f = ImmutableList.d();
  private String g;
  private String h;

  public Uri a()
  {
    return this.a;
  }

  public BugReportBuilder a(Uri paramUri)
  {
    this.a = paramUri;
    return this;
  }

  public BugReportBuilder a(BugReport paramBugReport)
  {
    this.a = paramBugReport.a();
    this.b = paramBugReport.b();
    this.c = paramBugReport.c();
    this.d = paramBugReport.d();
    this.e = paramBugReport.e();
    this.f = ImmutableList.a(paramBugReport.f());
    this.g = paramBugReport.g();
    this.h = paramBugReport.h();
    return this;
  }

  public BugReportBuilder a(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public BugReportBuilder a(List<Long> paramList)
  {
    this.f = paramList;
    return this;
  }

  public BugReportBuilder b(Uri paramUri)
  {
    this.c = paramUri;
    return this;
  }

  public BugReportBuilder b(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public String b()
  {
    return this.b;
  }

  public Uri c()
  {
    return this.c;
  }

  public BugReportBuilder c(Uri paramUri)
  {
    this.d = paramUri;
    return this;
  }

  public BugReportBuilder c(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public Uri d()
  {
    return this.d;
  }

  public BugReportBuilder d(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public String e()
  {
    return this.e;
  }

  public List<Long> f()
  {
    return this.f;
  }

  public String g()
  {
    return this.g;
  }

  public String h()
  {
    return this.h;
  }

  public BugReport i()
  {
    return new BugReport(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.bugreporter.BugReportBuilder
 * JD-Core Version:    0.6.0
 */