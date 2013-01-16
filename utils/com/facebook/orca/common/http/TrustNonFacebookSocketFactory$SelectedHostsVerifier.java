package com.facebook.orca.common.http;

import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.X509HostnameVerifier;

class TrustNonFacebookSocketFactory$SelectedHostsVerifier
  implements X509HostnameVerifier
{
  private final Set<String> a = new HashSet();
  private final X509HostnameVerifier b;

  public TrustNonFacebookSocketFactory$SelectedHostsVerifier(String[] paramArrayOfString, X509HostnameVerifier paramX509HostnameVerifier)
  {
    if (paramArrayOfString != null)
    {
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        this.a.add(str);
      }
    }
    this.b = paramX509HostnameVerifier;
  }

  private boolean a(String paramString)
  {
    int i = paramString.indexOf('.');
    if (i == -1);
    while (true)
    {
      return this.a.contains(paramString);
      paramString = paramString.substring(i + 1);
    }
  }

  public final String toString()
  {
    return "SELECTED_HOSTS_VERIFIER";
  }

  public void verify(String paramString, X509Certificate paramX509Certificate)
  {
    if (a(paramString))
      this.b.verify(paramString, paramX509Certificate);
  }

  public void verify(String paramString, SSLSocket paramSSLSocket)
  {
    if (a(paramString))
      this.b.verify(paramString, paramSSLSocket);
  }

  public void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (a(paramString))
      this.b.verify(paramString, paramArrayOfString1, paramArrayOfString2);
  }

  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    if (a(paramString));
    for (boolean bool = this.b.verify(paramString, paramSSLSession); ; bool = true)
      return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.TrustNonFacebookSocketFactory.SelectedHostsVerifier
 * JD-Core Version:    0.6.2
 */