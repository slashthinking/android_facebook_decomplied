package com.facebook.orca.share;

public class ShareMediaBuilder
{
  private String a;
  private String b;
  private String c;
  private String d;
  private ShareMediaPhoto e;
  private ShareMediaVideo f;

  public String a()
  {
    return this.a;
  }

  public void a(ShareMediaPhoto paramShareMediaPhoto)
  {
    this.e = paramShareMediaPhoto;
  }

  public void a(ShareMediaVideo paramShareMediaVideo)
  {
    this.f = paramShareMediaVideo;
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

  public String d()
  {
    return this.d;
  }

  public void d(String paramString)
  {
    this.d = paramString;
  }

  public ShareMediaPhoto e()
  {
    return this.e;
  }

  public ShareMediaVideo f()
  {
    return this.f;
  }

  public ShareMedia g()
  {
    return new ShareMedia(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.share.ShareMediaBuilder
 * JD-Core Version:    0.6.0
 */