package com.facebook.apache.http.entity.mime.content;

import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamBody extends AbstractContentBody
{
  private final InputStream a;
  private final String b;

  public InputStreamBody(InputStream paramInputStream, String paramString1, String paramString2)
  {
    super(paramString1);
    if (paramInputStream == null)
      throw new IllegalArgumentException("Input stream may not be null");
    this.a = paramInputStream;
    this.b = paramString2;
  }

  public void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("Output stream may not be null");
    try
    {
      byte[] arrayOfByte = new byte[4096];
      while (true)
      {
        int i = this.a.read(arrayOfByte);
        if (i == -1)
          break;
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      this.a.close();
    }
    paramOutputStream.flush();
    this.a.close();
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
    return -1L;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.apache.http.entity.mime.content.InputStreamBody
 * JD-Core Version:    0.6.0
 */