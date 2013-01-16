package com.facebook.analytics;

import com.facebook.analytics.util.NetworkDataLogUtils;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

final class AnalyticsOrcaHttpClientObserver$MyHttpResponseInterceptor
  implements HttpResponseInterceptor
{
  private AnalyticsOrcaHttpClientObserver$MyHttpResponseInterceptor(AnalyticsOrcaHttpClientObserver paramAnalyticsOrcaHttpClientObserver)
  {
  }

  public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    String str = AnalyticsOrcaHttpClientObserver.b(this.a).a(paramHttpResponse);
    long l1 = AnalyticsOrcaHttpClientObserver.b(this.a).a(paramHttpResponse);
    long l2 = AnalyticsOrcaHttpClientObserver.b(this.a).b(paramHttpResponse);
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    if (l2 < 0L)
      l2 = localHttpEntity.getContentLength();
    Long localLong = Long.valueOf(Thread.currentThread().getId());
    URI localURI = (URI)AnalyticsOrcaHttpClientObserver.a(this.a).remove(localLong);
    AnalyticsOrcaHttpClientObserver.c(this.a).a(localURI, str, l1, l2);
    if (l2 < 0L)
      paramHttpResponse.setEntity(new AnalyticsOrcaHttpClientObserver.BytesCountingEntity(this.a, localHttpEntity, localURI, str));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsOrcaHttpClientObserver.MyHttpResponseInterceptor
 * JD-Core Version:    0.6.2
 */