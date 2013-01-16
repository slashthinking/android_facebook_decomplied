package com.facebook.orca.media;

import com.google.common.io.Closeables;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;

class MediaDownloader$DownloadResultForHttpEntity extends MediaDownloader.DownloadResult
{
  private final HttpEntity a;
  private final InputStream b;

  MediaDownloader$DownloadResultForHttpEntity(HttpEntity paramHttpEntity)
  {
    super(MediaDownloader.DownloadResultCode.SUCCESS);
    this.a = paramHttpEntity;
    this.b = paramHttpEntity.getContent();
  }

  public InputStream b()
  {
    return this.b;
  }

  public void c()
  {
    Closeables.a(this.b);
    try
    {
      this.a.consumeContent();
      label16: return;
    }
    catch (IOException localIOException)
    {
      break label16;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaDownloader.DownloadResultForHttpEntity
 * JD-Core Version:    0.6.2
 */