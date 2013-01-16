package com.facebook.orca.common.http;

import com.facebook.orca.annotations.SslSocketFactory;
import com.facebook.orca.inject.AbstractProvider;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

class OrcaHttpModule$ClientConnectionManagerProvider extends AbstractProvider<ClientConnectionManager>
{
  private OrcaHttpModule$ClientConnectionManagerProvider(OrcaHttpModule paramOrcaHttpModule)
  {
  }

  public ClientConnectionManager a()
  {
    HttpParams localHttpParams = (HttpParams)b(HttpParams.class);
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", (SocketFactory)b(SocketFactory.class, SslSocketFactory.class), 443));
    return new ThreadSafeClientConnManager(localHttpParams, localSchemeRegistry);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.ClientConnectionManagerProvider
 * JD-Core Version:    0.6.2
 */