package com.facebook.orca.common.http;

import com.facebook.orca.debug.BLog;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

public class OrcaHttpRequestRetryHandler
  implements HttpRequestRetryHandler
{
  private static final Class<?> a = OrcaHttpRequestRetryHandler.class;
  private final int b = 3;

  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    boolean bool = false;
    if (paramIOException == null)
      throw new IllegalArgumentException("Exception parameter may not be null");
    if (paramHttpContext == null)
      throw new IllegalArgumentException("HTTP context may not be null");
    BLog.a(a, "Exception", paramIOException);
    if (paramInt > this.b)
      BLog.b(a, "Hit retry limit");
    while (true)
    {
      return bool;
      if ((paramIOException instanceof NoHttpResponseException))
      {
        BLog.b(a, "[NoHttpResponseException] Retrying");
        bool = true;
      }
      else if ((paramIOException instanceof InterruptedIOException))
      {
        BLog.b(a, "[InterruptedIOException] Not Retrying");
        bool = false;
      }
      else if ((paramIOException instanceof UnknownHostException))
      {
        BLog.b(a, "[UnknownHostException] Not Retrying");
        bool = false;
      }
      else if ((paramIOException instanceof ConnectException))
      {
        BLog.b(a, "[ConnectException] Not Retrying");
        bool = false;
      }
      else if ((paramIOException instanceof SSLHandshakeException))
      {
        BLog.b(a, "[SSLHandshakeException] Not Retrying");
        bool = false;
      }
      else
      {
        BLog.b(a, "[Default] Retrying");
        bool = true;
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpRequestRetryHandler
 * JD-Core Version:    0.6.2
 */