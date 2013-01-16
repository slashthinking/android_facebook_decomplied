package com.facebook.orca.activity;

public class ConfirmActionParams
{
  private String a;
  private String b;
  private String c;
  private ConfirmActionParams.ButtonStyle d = ConfirmActionParams.ButtonStyle.NORMAL;
  private String e;
  private ConfirmActionParams.ButtonStyle f = ConfirmActionParams.ButtonStyle.NORMAL;

  public String a()
  {
    return this.a;
  }

  public void a(ConfirmActionParams.ButtonStyle paramButtonStyle)
  {
    this.d = paramButtonStyle;
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public String b()
  {
    return this.b;
  }

  public void b(ConfirmActionParams.ButtonStyle paramButtonStyle)
  {
    this.f = paramButtonStyle;
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
    return this.e;
  }

  public void d(String paramString)
  {
    this.e = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.activity.ConfirmActionParams
 * JD-Core Version:    0.6.0
 */