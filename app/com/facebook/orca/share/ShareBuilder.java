package com.facebook.orca.share;

import java.util.Collections;
import java.util.List;

public class ShareBuilder
{
  private String a;
  private String b;
  private String c;
  private String d;
  private List<ShareMedia> e = Collections.emptyList();
  private List<ShareProperty> f = Collections.emptyList();

  public String a()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public void a(List<ShareMedia> paramList)
  {
    this.e = paramList;
  }

  public String b()
  {
    return this.b;
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }

  public void b(List<ShareProperty> paramList)
  {
    this.f = paramList;
  }

  public String c()
  {
    return this.c;
  }

  public void c(String paramString)
  {
    this.c = paramString;
  }

  public List<ShareMedia> d()
  {
    return this.e;
  }

  public void d(String paramString)
  {
    this.d = paramString;
  }

  public String e()
  {
    return this.d;
  }

  public List<ShareProperty> f()
  {
    return this.f;
  }

  public Share g()
  {
    return new Share(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.share.ShareBuilder
 * JD-Core Version:    0.6.0
 */