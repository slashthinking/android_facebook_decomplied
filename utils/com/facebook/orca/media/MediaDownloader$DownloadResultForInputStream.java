package com.facebook.orca.media;

import com.google.common.io.Closeables;
import java.io.InputStream;

class MediaDownloader$DownloadResultForInputStream extends MediaDownloader.DownloadResult
{
  private final InputStream a;

  MediaDownloader$DownloadResultForInputStream(InputStream paramInputStream)
  {
    super(MediaDownloader.DownloadResultCode.SUCCESS);
    this.a = paramInputStream;
  }

  public InputStream b()
  {
    return this.a;
  }

  public void c()
  {
    Closeables.a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaDownloader.DownloadResultForInputStream
 * JD-Core Version:    0.6.2
 */