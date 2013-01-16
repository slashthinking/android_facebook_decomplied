package com.facebook.katana.net;

import com.facebook.common.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class HttpOperation$ResponseInputStream extends InputStream
{
  private final String a;
  private final int b;
  private int c;
  private InputStream d;

  public HttpOperation$ResponseInputStream(InputStream paramInputStream, String paramString1, String paramString2)
  {
    this.d = paramInputStream;
    this.a = paramString1;
    this.b = a(paramString1);
    this.c = 0;
  }

  private static int a(String paramString)
  {
    if ((paramString.startsWith("application/json")) || (paramString.startsWith("text/html")) || (paramString.startsWith("text/javascript")));
    for (int i = 2097152; ; i = 220000)
    {
      return i;
      if ((!paramString.equals("image/jpeg")) && (!paramString.equals("image/gif")) && (!paramString.equals("image/png")))
        break;
    }
    throw new IllegalArgumentException("Unsupported content type: " + paramString);
  }

  private void c()
  {
    if (this.c >= this.b)
      throw new IOException("Content too large (length unknown): " + this.c + " (" + this.a + ")");
  }

  public int a()
  {
    return this.c;
  }

  public void a(File paramFile)
  {
    this.c += FileUtils.a(this.d, paramFile);
  }

  public String b()
  {
    InputStreamReader localInputStreamReader = new InputStreamReader(this.d);
    StringWriter localStringWriter = new StringWriter(2048);
    char[] arrayOfChar = new char[2048];
    while (true)
    {
      int i = localInputStreamReader.read(arrayOfChar);
      if (i <= 0)
        break;
      localStringWriter.write(arrayOfChar, 0, i);
    }
    return localStringWriter.toString();
  }

  public void close()
  {
    this.d.close();
  }

  public int read()
  {
    c();
    int i = this.d.read();
    this.c = (1 + this.c);
    return i;
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    c();
    if (paramInt2 + this.c > this.b)
      paramInt2 -= paramInt2 + this.c - this.b;
    int i = this.d.read(paramArrayOfByte, paramInt1, paramInt2);
    this.c = (i + this.c);
    return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.net.HttpOperation.ResponseInputStream
 * JD-Core Version:    0.6.0
 */