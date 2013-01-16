package com.facebook.apache.http.entity.mime.content;

import java.io.OutputStream;
import java.nio.charset.Charset;

public class StringBody extends AbstractContentBody
{
  private final int a = 4096;
  private final byte[] b;
  private final Charset c;

  public StringBody(String paramString)
  {
    this(paramString, "text/plain", null);
  }

  public StringBody(String paramString1, String paramString2, Charset paramCharset)
  {
    super(paramString2);
    if (paramString1 == null)
      throw new IllegalArgumentException("Text may not be null");
    if (paramCharset == null)
      paramCharset = Charset.forName("US-ASCII");
    this.b = paramString1.getBytes(paramCharset.name());
    this.c = paramCharset;
  }

  public StringBody(String paramString, Charset paramCharset)
  {
    this(paramString, "text/plain", paramCharset);
  }

  public void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("Output stream may not be null");
    int i = this.b.length;
    for (int j = 0; j < i; j += 4096)
      paramOutputStream.write(this.b, j, Math.min(i - j, 4096));
    paramOutputStream.flush();
  }

  public String b()
  {
    return null;
  }

  public String c()
  {
    return this.c.name();
  }

  public String d()
  {
    return "8bit";
  }

  public long e()
  {
    return this.b.length;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.apache.http.entity.mime.content.StringBody
 * JD-Core Version:    0.6.0
 */