package com.facebook.apache.http.entity.mime.content;

public abstract class AbstractContentBody
  implements ContentBody
{
  private final String a;
  private final String b;
  private final String c;

  public AbstractContentBody(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("MIME type may not be null");
    this.a = paramString;
    int i = paramString.indexOf('/');
    if (i != -1)
      this.b = paramString.substring(0, i);
    for (this.c = paramString.substring(i + 1); ; this.c = null)
    {
      return;
      this.b = paramString;
    }
  }

  public String a()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.apache.http.entity.mime.content.AbstractContentBody
 * JD-Core Version:    0.6.0
 */