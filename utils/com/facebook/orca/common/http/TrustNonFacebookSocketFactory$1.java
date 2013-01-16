package com.facebook.orca.common.http;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class TrustNonFacebookSocketFactory$1
  implements X509TrustManager
{
  X509Certificate[] a = new X509Certificate[0];

  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
  }

  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
  }

  public X509Certificate[] getAcceptedIssuers()
  {
    return this.a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.TrustNonFacebookSocketFactory.1
 * JD-Core Version:    0.6.2
 */