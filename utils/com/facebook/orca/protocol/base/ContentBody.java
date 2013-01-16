package com.facebook.orca.protocol.base;

import com.facebook.apache.http.entity.mime.content.AbstractContentBody;

public abstract class ContentBody extends AbstractContentBody
{
  private final int a;
  private final String b;

  public ContentBody(String paramString1, int paramInt, String paramString2)
  {
    super(paramString1);
    this.a = paramInt;
    this.b = paramString2;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return null;
  }

  public String d()
  {
    return "binary";
  }

  public long e()
  {
    return this.a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.base.ContentBody
 * JD-Core Version:    0.6.2
 */