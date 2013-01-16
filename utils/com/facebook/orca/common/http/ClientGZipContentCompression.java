package com.facebook.orca.common.http;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;

public class ClientGZipContentCompression
{
  public static HttpRequestInterceptor a()
  {
    return new ClientGZipContentCompression.MyHttpRequestInterceptor(null);
  }

  public static HttpResponseInterceptor b()
  {
    return new ClientGZipContentCompression.MyHttpResponseInterceptor(null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.ClientGZipContentCompression
 * JD-Core Version:    0.6.2
 */