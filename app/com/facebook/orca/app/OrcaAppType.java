package com.facebook.orca.app;

import com.facebook.app.Product;
import com.facebook.orca.config.PlatformAppConfig;

public class OrcaAppType
  implements PlatformAppConfig
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final IntendedAudience h;
  private final Product i;

  public OrcaAppType(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, IntendedAudience paramIntendedAudience, Product paramProduct)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramIntendedAudience;
    this.i = paramProduct;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public String d()
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

  public String g()
  {
    return this.g;
  }

  public IntendedAudience h()
  {
    return this.h;
  }

  public Product i()
  {
    return this.i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.OrcaAppType
 * JD-Core Version:    0.6.0
 */