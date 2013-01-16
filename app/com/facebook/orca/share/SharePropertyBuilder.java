package com.facebook.orca.share;

public class SharePropertyBuilder
{
  private String a;
  private String b;
  private String c;

  public String a()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public String b()
  {
    return this.b;
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }

  public String c()
  {
    return this.c;
  }

  public void c(String paramString)
  {
    this.c = paramString;
  }

  public ShareProperty d()
  {
    return new ShareProperty(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.share.SharePropertyBuilder
 * JD-Core Version:    0.6.0
 */