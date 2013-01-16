package com.facebook.orca.common.http;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

class ClientGZipContentCompression$GzipDecompressingEntity extends HttpEntityWrapper
{
  public ClientGZipContentCompression$GzipDecompressingEntity(HttpEntity paramHttpEntity)
  {
    super(paramHttpEntity);
  }

  public InputStream getContent()
  {
    return new GZIPInputStream(this.wrappedEntity.getContent());
  }

  public long getContentLength()
  {
    return -1L;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.ClientGZipContentCompression.GzipDecompressingEntity
 * JD-Core Version:    0.6.2
 */