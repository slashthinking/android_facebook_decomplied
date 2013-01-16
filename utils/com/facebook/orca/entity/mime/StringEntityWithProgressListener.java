package com.facebook.orca.entity.mime;

import java.io.OutputStream;
import org.apache.http.entity.StringEntity;

public class StringEntityWithProgressListener extends StringEntity
{
  private ContentSerializationListener a = null;

  public StringEntityWithProgressListener(String paramString)
  {
    super(paramString);
  }

  public void a(ContentSerializationListener paramContentSerializationListener)
  {
    this.a = paramContentSerializationListener;
  }

  public void writeTo(OutputStream paramOutputStream)
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("Output stream may not be null");
    if (this.a == null)
      paramOutputStream.write(this.content);
    while (true)
    {
      paramOutputStream.flush();
      return;
      OutputStreamWithProgressListener localOutputStreamWithProgressListener = new OutputStreamWithProgressListener(paramOutputStream, this.a);
      int i = this.content.length;
      for (int j = 0; j < i; j += 4096)
        localOutputStreamWithProgressListener.write(this.content, j, Math.min(i - j, 4096));
      paramOutputStream = localOutputStreamWithProgressListener;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.entity.mime.StringEntityWithProgressListener
 * JD-Core Version:    0.6.2
 */