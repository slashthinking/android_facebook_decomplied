package com.facebook.orca.entity.mime;

import com.facebook.apache.http.entity.mime.MultipartEntity;
import java.io.OutputStream;

public class MultipartEntityWithProgressListener extends MultipartEntity
{
  ContentSerializationListener a = null;

  public void a(ContentSerializationListener paramContentSerializationListener)
  {
    this.a = paramContentSerializationListener;
  }

  public void writeTo(OutputStream paramOutputStream)
  {
    if (this.a != null)
      paramOutputStream = new OutputStreamWithProgressListener(paramOutputStream, this.a);
    super.writeTo(paramOutputStream);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.entity.mime.MultipartEntityWithProgressListener
 * JD-Core Version:    0.6.2
 */