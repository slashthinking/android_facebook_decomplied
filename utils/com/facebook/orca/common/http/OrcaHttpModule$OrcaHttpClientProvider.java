package com.facebook.orca.common.http;

import com.facebook.orca.inject.AbstractProvider;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;

class OrcaHttpModule$OrcaHttpClientProvider extends AbstractProvider<OrcaHttpClient>
{
  private OrcaHttpModule$OrcaHttpClientProvider(OrcaHttpModule paramOrcaHttpModule)
  {
  }

  public OrcaHttpClient a()
  {
    return new OrcaHttpClientImpl((ClientConnectionManager)b(ClientConnectionManager.class), (HttpParams)b(HttpParams.class), (OrcaCookieStore)b(OrcaCookieStore.class), c(OrcaHttpClientObserver.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.OrcaHttpClientProvider
 * JD-Core Version:    0.6.2
 */