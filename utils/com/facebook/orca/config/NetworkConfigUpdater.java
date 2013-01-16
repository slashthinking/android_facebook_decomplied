package com.facebook.orca.config;

import com.facebook.orca.common.http.OrcaHttpClient;
import javax.inject.Provider;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

public class NetworkConfigUpdater
{
  private final OrcaHttpClient a;
  private final Provider<SocketFactory> b;
  private final NetworkConfig c;

  public NetworkConfigUpdater(OrcaHttpClient paramOrcaHttpClient, Provider<SocketFactory> paramProvider, NetworkConfig paramNetworkConfig)
  {
    this.a = paramOrcaHttpClient;
    this.b = paramProvider;
    this.c = paramNetworkConfig;
    this.c.a(new NetworkConfigUpdater.1(this));
  }

  private void a()
  {
    this.a.getConnectionManager().getSchemeRegistry().register(new Scheme("https", (SocketFactory)this.b.b(), 443));
    this.a.getParams().setParameter("http.route.default-proxy", this.c.a());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.config.NetworkConfigUpdater
 * JD-Core Version:    0.6.2
 */