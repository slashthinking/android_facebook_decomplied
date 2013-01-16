package org.acra.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class UnsafeConnectionProvider$1
  implements HostnameVerifier
{
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.UnsafeConnectionProvider.1
 * JD-Core Version:    0.6.0
 */