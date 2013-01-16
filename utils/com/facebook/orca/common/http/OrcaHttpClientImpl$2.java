package com.facebook.orca.common.http;

import java.util.Iterator;
import java.util.Set;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

class OrcaHttpClientImpl$2 extends DefaultHttpClient
{
  OrcaHttpClientImpl$2(OrcaHttpClientImpl paramOrcaHttpClientImpl, ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams, Set paramSet)
  {
    super(paramClientConnectionManager, paramHttpParams);
  }

  protected HttpContext createHttpContext()
  {
    BasicHttpContext localBasicHttpContext = new BasicHttpContext();
    localBasicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
    localBasicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
    localBasicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
    localBasicHttpContext.setAttribute("http.cookie-store", OrcaHttpClientImpl.a(this.b));
    return localBasicHttpContext;
  }

  protected BasicHttpProcessor createHttpProcessor()
  {
    BasicHttpProcessor localBasicHttpProcessor = super.createHttpProcessor();
    localBasicHttpProcessor.addRequestInterceptor(OrcaHttpClientImpl.b());
    localBasicHttpProcessor.addRequestInterceptor(new OrcaHttpClientImpl.CurlLogger(this.b, null));
    localBasicHttpProcessor.addRequestInterceptor(ClientGZipContentCompression.a());
    localBasicHttpProcessor.addResponseInterceptor(ClientGZipContentCompression.b());
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((OrcaHttpClientObserver)localIterator.next()).a(localBasicHttpProcessor, localBasicHttpProcessor);
    return localBasicHttpProcessor;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpClientImpl.2
 * JD-Core Version:    0.6.2
 */