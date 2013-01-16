package com.facebook.orca.common.http;

import android.os.Build.VERSION;
import com.facebook.orca.annotations.UserAgentString;
import com.facebook.orca.config.NetworkConfig;
import com.facebook.orca.inject.AbstractProvider;
import org.apache.http.conn.scheme.SocketFactory;

class OrcaHttpModule$SslSocketFactoryProvider extends AbstractProvider<SocketFactory>
{
  private OrcaHttpModule$SslSocketFactoryProvider(OrcaHttpModule paramOrcaHttpModule)
  {
  }

  public SocketFactory a()
  {
    String str = (String)b(String.class, UserAgentString.class);
    Object localObject;
    if (!((NetworkConfig)b(NetworkConfig.class)).b())
      localObject = TrustNonFacebookSocketFactory.a();
    while (true)
    {
      return localObject;
      if (Build.VERSION.SDK_INT >= 8)
        localObject = OrcaHttpModule.a(OrcaHttpModule.a(this.a), str);
      else
        localObject = OrcaHttpModule.a(str);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.SslSocketFactoryProvider
 * JD-Core Version:    0.6.2
 */