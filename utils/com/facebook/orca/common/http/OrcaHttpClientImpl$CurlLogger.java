package com.facebook.orca.common.http;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class OrcaHttpClientImpl$CurlLogger
  implements HttpRequestInterceptor
{
  private OrcaHttpClientImpl$CurlLogger(OrcaHttpClientImpl paramOrcaHttpClientImpl)
  {
  }

  public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    OrcaHttpClientImpl.LoggingConfiguration localLoggingConfiguration = OrcaHttpClientImpl.b(this.a);
    if ((localLoggingConfiguration != null) && (OrcaHttpClientImpl.LoggingConfiguration.a(localLoggingConfiguration)) && ((paramHttpRequest instanceof HttpUriRequest)))
      OrcaHttpClientImpl.LoggingConfiguration.a(localLoggingConfiguration, OrcaHttpClientImpl.a((HttpUriRequest)paramHttpRequest, false));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpClientImpl.CurlLogger
 * JD-Core Version:    0.6.2
 */