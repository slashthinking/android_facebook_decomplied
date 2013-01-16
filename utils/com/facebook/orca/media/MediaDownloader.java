package com.facebook.orca.media;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Contacts;
import com.facebook.orca.common.http.OrcaHttpRequestProcessor;
import com.facebook.orca.debug.BLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public class MediaDownloader
{
  private static final Class<?> a = MediaDownloader.class;
  private final OrcaHttpRequestProcessor b;
  private final Context c;
  private final String d;

  public MediaDownloader(Context paramContext, OrcaHttpRequestProcessor paramOrcaHttpRequestProcessor, String paramString)
  {
    this.c = paramContext;
    this.b = paramOrcaHttpRequestProcessor;
    this.d = paramString;
  }

  private Uri a(Uri paramUri1, Uri paramUri2)
  {
    URI localURI = URI.create(paramUri2.toString());
    return Uri.parse(URI.create(paramUri1.toString()).resolve(localURI).toString());
  }

  private MediaDownloader.DownloadResult b(Uri paramUri)
  {
    Uri localUri1 = Uri.parse(paramUri.toString());
    int i = 0;
    Object localObject = localUri1;
    HttpResponse localHttpResponse;
    int j;
    MediaDownloader.DownloadResult localDownloadResult;
    while (true)
      if (i < 3)
      {
        BLog.a(a, "Fetching " + localObject);
        g((Uri)localObject);
        HttpGet localHttpGet = new HttpGet(((Uri)localObject).toString());
        localHttpResponse = this.b.a(this.d, localHttpGet);
        j = localHttpResponse.getStatusLine().getStatusCode();
        if (j == 302)
        {
          Header[] arrayOfHeader = localHttpResponse.getHeaders("Location");
          if (arrayOfHeader.length >= 1)
          {
            Uri localUri2 = Uri.parse(arrayOfHeader[0].getValue());
            if (!localUri2.isAbsolute())
              localUri2 = a((Uri)localObject, localUri2);
            if (("https".equals(localUri2.getScheme())) && (localUri2.getHost().equals("attachment.fbsbx.com")))
              localUri2 = localUri2.buildUpon().scheme("http").build();
            localHttpGet.abort();
            i++;
            localObject = localUri2;
            continue;
          }
          localDownloadResult = MediaDownloader.DownloadResult.a(MediaDownloader.DownloadResultCode.OTHER);
        }
      }
    while (true)
    {
      return localDownloadResult;
      if (j == 200)
      {
        localDownloadResult = MediaDownloader.DownloadResult.a(localHttpResponse.getEntity());
      }
      else if (j == 404)
      {
        localDownloadResult = MediaDownloader.DownloadResult.a(MediaDownloader.DownloadResultCode.NOT_FOUND);
      }
      else if (j == 403)
      {
        localDownloadResult = MediaDownloader.DownloadResult.a(MediaDownloader.DownloadResultCode.FORBIDDEN);
      }
      else
      {
        localDownloadResult = MediaDownloader.DownloadResult.a(MediaDownloader.DownloadResultCode.OTHER);
        continue;
        localDownloadResult = MediaDownloader.DownloadResult.a(MediaDownloader.DownloadResultCode.OTHER);
      }
    }
  }

  private MediaDownloader.DownloadResult c(Uri paramUri)
  {
    if ("com.android.contacts".equals(paramUri.getAuthority()));
    for (MediaDownloader.DownloadResult localDownloadResult = d(paramUri); ; localDownloadResult = e(paramUri))
      return localDownloadResult;
  }

  private MediaDownloader.DownloadResult d(Uri paramUri)
  {
    BLog.b(a, "Downloading contact photo from: " + paramUri);
    InputStream localInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.c.getContentResolver(), paramUri);
    if (localInputStream == null)
      BLog.b(a, "Contact photo not found: " + paramUri);
    for (MediaDownloader.DownloadResult localDownloadResult = MediaDownloader.DownloadResult.a(MediaDownloader.DownloadResultCode.NOT_FOUND); ; localDownloadResult = MediaDownloader.DownloadResult.a(localInputStream))
      return localDownloadResult;
  }

  private MediaDownloader.DownloadResult e(Uri paramUri)
  {
    BLog.b(a, "Downloading media from generic content resolver: " + paramUri);
    InputStream localInputStream = this.c.getContentResolver().openInputStream(paramUri);
    if (localInputStream == null)
      BLog.b(a, "Media not found: " + paramUri);
    for (MediaDownloader.DownloadResult localDownloadResult = MediaDownloader.DownloadResult.a(MediaDownloader.DownloadResultCode.NOT_FOUND); ; localDownloadResult = MediaDownloader.DownloadResult.a(localInputStream))
      return localDownloadResult;
  }

  private MediaDownloader.DownloadResult f(Uri paramUri)
  {
    return MediaDownloader.DownloadResult.a(new FileInputStream(paramUri.getPath()));
  }

  private void g(Uri paramUri)
  {
    try
    {
      URI.create(paramUri.toString());
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new IOException(localIllegalArgumentException);
    }
  }

  public MediaDownloader.DownloadResult a(Uri paramUri)
  {
    Object localObject;
    try
    {
      if (("http".equals(paramUri.getScheme())) || ("https".equals(paramUri.getScheme())))
      {
        localObject = b(paramUri);
      }
      else if ("content".equals(paramUri.getScheme()))
      {
        localObject = c(paramUri);
      }
      else if ("file".equals(paramUri.getScheme()))
      {
        localObject = f(paramUri);
      }
      else
      {
        BLog.e(a, "Unsupported scheme: %s", new Object[] { paramUri });
        MediaDownloader.DownloadResult localDownloadResult = MediaDownloader.DownloadResult.a(MediaDownloader.DownloadResultCode.UNSUPPORTED_URI);
        localObject = localDownloadResult;
      }
    }
    catch (IOException localIOException)
    {
      BLog.b(a, "IOException downloading " + paramUri, localIOException);
      localObject = MediaDownloader.DownloadResult.a(MediaDownloader.DownloadResultCode.IO_EXCEPTION);
    }
    return localObject;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaDownloader
 * JD-Core Version:    0.6.2
 */