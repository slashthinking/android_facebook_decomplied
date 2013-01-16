package com.facebook.analytics;

import com.facebook.analytics.util.NetworkDataLogUtils;
import com.facebook.orca.common.http.OrcaHttpClientObserver;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.protocol.HttpRequestInterceptorList;
import org.apache.http.protocol.HttpResponseInterceptorList;

public class AnalyticsOrcaHttpClientObserver
  implements OrcaHttpClientObserver
{
  private final NetworkDataLogger a;
  private final NetworkDataLogUtils b;
  private final Map<Long, URI> c;

  public AnalyticsOrcaHttpClientObserver(NetworkDataLogger paramNetworkDataLogger, NetworkDataLogUtils paramNetworkDataLogUtils)
  {
    this.a = paramNetworkDataLogger;
    this.b = paramNetworkDataLogUtils;
    this.c = new ConcurrentHashMap();
  }

  public void a(HttpRequestInterceptorList paramHttpRequestInterceptorList, HttpResponseInterceptorList paramHttpResponseInterceptorList)
  {
    if (this.a == null);
    while (true)
    {
      return;
      paramHttpRequestInterceptorList.addRequestInterceptor(new AnalyticsOrcaHttpClientObserver.MyHttpRequestInterceptor(this, null));
      paramHttpResponseInterceptorList.addResponseInterceptor(new AnalyticsOrcaHttpClientObserver.MyHttpResponseInterceptor(this, null), 0);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsOrcaHttpClientObserver
 * JD-Core Version:    0.6.2
 */