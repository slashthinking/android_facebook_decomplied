package com.facebook.orca.common.http;

import com.facebook.orca.annotations.SslSocketFactory;
import com.facebook.orca.config.NetworkConfig;
import com.facebook.orca.config.NetworkConfigUpdater;
import com.facebook.orca.inject.AbstractProvider;
import org.apache.http.conn.scheme.SocketFactory;

class OrcaHttpModule$NetworkConfigUpdaterProvider extends AbstractProvider<NetworkConfigUpdater>
{
  private OrcaHttpModule$NetworkConfigUpdaterProvider(OrcaHttpModule paramOrcaHttpModule)
  {
  }

  public NetworkConfigUpdater a()
  {
    return new NetworkConfigUpdater((OrcaHttpClient)b(OrcaHttpClient.class), a(SocketFactory.class, SslSocketFactory.class), (NetworkConfig)b(NetworkConfig.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.NetworkConfigUpdaterProvider
 * JD-Core Version:    0.6.2
 */