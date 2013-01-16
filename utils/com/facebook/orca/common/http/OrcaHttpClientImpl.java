package com.facebook.orca.common.http;

import android.net.http.AndroidHttpClient;
import com.facebook.orca.debug.BLog;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

final class OrcaHttpClientImpl
  implements OrcaHttpClient
{
  private static final Class<?> a = AndroidHttpClient.class;
  private static final HttpRequestInterceptor b = new OrcaHttpClientImpl.1();
  private final DefaultHttpClient c;
  private final OrcaCookieStore d;
  private RuntimeException e = new IllegalStateException("AndroidHttpClient created and never closed");
  private volatile OrcaHttpClientImpl.LoggingConfiguration f;

  OrcaHttpClientImpl(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams, OrcaCookieStore paramOrcaCookieStore, Set<OrcaHttpClientObserver> paramSet)
  {
    this.d = paramOrcaCookieStore;
    this.c = new OrcaHttpClientImpl.2(this, paramClientConnectionManager, paramHttpParams, paramSet);
    this.c.setHttpRequestRetryHandler(new OrcaHttpRequestRetryHandler());
  }

  private static String b(HttpUriRequest paramHttpUriRequest, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("curl ");
    Header[] arrayOfHeader = paramHttpUriRequest.getAllHeaders();
    int i = arrayOfHeader.length;
    int j = 0;
    if (j < i)
    {
      Header localHeader = arrayOfHeader[j];
      if ((!paramBoolean) && ((localHeader.getName().equals("Authorization")) || (localHeader.getName().equals("Cookie"))));
      while (true)
      {
        j++;
        break;
        localStringBuilder.append("--header \"");
        localStringBuilder.append(localHeader.toString().trim());
        localStringBuilder.append("\" ");
      }
    }
    URI localURI1 = paramHttpUriRequest.getURI();
    HttpRequest localHttpRequest;
    if ((paramHttpUriRequest instanceof RequestWrapper))
    {
      localHttpRequest = ((RequestWrapper)paramHttpUriRequest).getOriginal();
      if (!(localHttpRequest instanceof HttpUriRequest));
    }
    for (URI localURI2 = ((HttpUriRequest)localHttpRequest).getURI(); ; localURI2 = localURI1)
    {
      localStringBuilder.append("\"");
      localStringBuilder.append(localURI2);
      localStringBuilder.append("\"");
      if ((paramHttpUriRequest instanceof HttpEntityEnclosingRequest))
      {
        HttpEntity localHttpEntity = ((HttpEntityEnclosingRequest)paramHttpUriRequest).getEntity();
        if ((localHttpEntity != null) && (localHttpEntity.isRepeatable()))
        {
          if (localHttpEntity.getContentLength() >= 1024L)
            break label274;
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          localHttpEntity.writeTo(localByteArrayOutputStream);
          String str = localByteArrayOutputStream.toString();
          localStringBuilder.append(" --data-ascii \"").append(str).append("\"");
        }
      }
      while (true)
      {
        return localStringBuilder.toString();
        label274: localStringBuilder.append(" [TOO MUCH DATA TO INCLUDE]");
      }
    }
  }

  public CookieStore a()
  {
    return this.d;
  }

  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    return this.c.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
  }

  public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    return this.c.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
  }

  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
  {
    return this.c.execute(paramHttpUriRequest, paramResponseHandler);
  }

  public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
  {
    return this.c.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
  }

  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
  {
    return this.c.execute(paramHttpHost, paramHttpRequest);
  }

  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    return this.c.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
  }

  public HttpResponse execute(HttpUriRequest paramHttpUriRequest)
  {
    return this.c.execute(paramHttpUriRequest);
  }

  public HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
  {
    return this.c.execute(paramHttpUriRequest, paramHttpContext);
  }

  protected void finalize()
  {
    super.finalize();
    if (this.e != null)
    {
      BLog.e(a, "Leak found", this.e);
      this.e = null;
    }
  }

  public ClientConnectionManager getConnectionManager()
  {
    return this.c.getConnectionManager();
  }

  public HttpParams getParams()
  {
    return this.c.getParams();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpClientImpl
 * JD-Core Version:    0.6.2
 */