package com.facebook.orca.common.http;

import com.facebook.orca.annotations.UserAgentString;
import com.facebook.orca.config.NetworkConfig;
import com.facebook.orca.inject.AbstractProvider;
import org.apache.http.HttpHost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class OrcaHttpModule$HttpParamsProvider extends AbstractProvider<HttpParams>
{
  private OrcaHttpModule$HttpParamsProvider(OrcaHttpModule paramOrcaHttpModule)
  {
  }

  public HttpParams a()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 60000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 60000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpClientParams.setRedirecting(localBasicHttpParams, false);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, (String)b(String.class, UserAgentString.class));
    HttpHost localHttpHost = ((NetworkConfig)b(NetworkConfig.class)).a();
    if (localHttpHost != null)
      localBasicHttpParams.setParameter("http.route.default-proxy", localHttpHost);
    return localBasicHttpParams;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.HttpParamsProvider
 * JD-Core Version:    0.6.2
 */