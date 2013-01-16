package com.facebook.orca.media;

import java.io.InputStream;
import org.apache.http.HttpEntity;

public abstract class MediaDownloader$DownloadResult
{
  private final MediaDownloader.DownloadResultCode a;

  protected MediaDownloader$DownloadResult(MediaDownloader.DownloadResultCode paramDownloadResultCode)
  {
    this.a = paramDownloadResultCode;
  }

  public static DownloadResult a(MediaDownloader.DownloadResultCode paramDownloadResultCode)
  {
    return new MediaDownloader.DownloadResultForError(paramDownloadResultCode);
  }

  public static DownloadResult a(InputStream paramInputStream)
  {
    return new MediaDownloader.DownloadResultForInputStream(paramInputStream);
  }

  public static DownloadResult a(HttpEntity paramHttpEntity)
  {
    return new MediaDownloader.DownloadResultForHttpEntity(paramHttpEntity);
  }

  public MediaDownloader.DownloadResultCode a()
  {
    return this.a;
  }

  public InputStream b()
  {
    throw new UnsupportedOperationException();
  }

  public void c()
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaDownloader.DownloadResult
 * JD-Core Version:    0.6.2
 */