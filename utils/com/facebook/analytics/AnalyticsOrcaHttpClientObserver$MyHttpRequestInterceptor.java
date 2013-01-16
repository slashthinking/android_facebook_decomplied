package com.facebook.analytics;

import com.facebook.analytics.util.NetworkDataLogUtils;
import com.facebook.orca.debug.BLog;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

final class AnalyticsOrcaHttpClientObserver$MyHttpRequestInterceptor
  implements HttpRequestInterceptor
{
  private final Class<?> b = MyHttpRequestInterceptor.class;

  private AnalyticsOrcaHttpClientObserver$MyHttpRequestInterceptor(AnalyticsOrcaHttpClientObserver paramAnalyticsOrcaHttpClientObserver)
  {
  }

  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    HttpUriRequest localHttpUriRequest;
    URI localURI1;
    HttpHost localHttpHost;
    if ((paramHttpRequest instanceof HttpUriRequest))
    {
      localHttpUriRequest = (HttpUriRequest)paramHttpRequest;
      localURI1 = localHttpUriRequest.getURI();
      if ((localURI1 == null) || (localURI1.getHost() != null))
        break label141;
      localHttpHost = (HttpHost)paramHttpContext.getAttribute("http.target_host");
      if (localHttpHost == null)
        break label141;
    }
    while (true)
    {
      try
      {
        URI localURI3 = new URI(localHttpHost.toURI()).resolve(localURI1);
        localURI2 = localURI3;
        AnalyticsOrcaHttpClientObserver.a(this.a).put(Long.valueOf(Thread.currentThread().getId()), localURI2);
        long l = AnalyticsOrcaHttpClientObserver.b(this.a).a(localHttpUriRequest);
        AnalyticsOrcaHttpClientObserver.c(this.a).a(localURI2, l);
        return;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        BLog.e(this.b, "Invalid URI", localURISyntaxException);
      }
      label141: URI localURI2 = localURI1;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsOrcaHttpClientObserver.MyHttpRequestInterceptor
 * JD-Core Version:    0.6.2
 */