package org.acra.util;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest
{
  public static final String POST_CONTENT_TYPE = "application/x-www-form-urlencoded";
  private HttpConnectionProvider mConnectionProvider;

  public HttpRequest(HttpConnectionProvider paramHttpConnectionProvider)
  {
    this.mConnectionProvider = paramHttpConnectionProvider;
  }

  public void sendPost(URL paramURL, String paramString, ACRAResponse paramACRAResponse)
  {
    HttpURLConnection localHttpURLConnection = this.mConnectionProvider.getConnection(paramURL);
    localHttpURLConnection.setRequestMethod("POST");
    localHttpURLConnection.setRequestProperty("User-Agent", "Android");
    localHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    localHttpURLConnection.setDoOutput(true);
    localHttpURLConnection.setFixedLengthStreamingMode(paramString.length());
    try
    {
      OutputStream localOutputStream = localHttpURLConnection.getOutputStream();
      localOutputStream.write(paramString.getBytes());
      localOutputStream.close();
      paramACRAResponse.setStatusCode(localHttpURLConnection.getResponseCode());
      return;
    }
    finally
    {
      localHttpURLConnection.disconnect();
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.HttpRequest
 * JD-Core Version:    0.6.0
 */