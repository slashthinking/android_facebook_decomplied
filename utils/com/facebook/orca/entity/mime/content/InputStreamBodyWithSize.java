package com.facebook.orca.entity.mime.content;

import com.facebook.apache.http.entity.mime.content.InputStreamBody;
import java.io.InputStream;

public class InputStreamBodyWithSize extends InputStreamBody
{
  private final long a;

  public InputStreamBodyWithSize(InputStream paramInputStream, String paramString1, String paramString2, long paramLong)
  {
    super(paramInputStream, paramString1, paramString2);
    this.a = paramLong;
  }

  public long e()
  {
    return this.a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.entity.mime.content.InputStreamBodyWithSize
 * JD-Core Version:    0.6.2
 */