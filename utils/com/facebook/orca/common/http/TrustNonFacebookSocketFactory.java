package com.facebook.orca.common.http;

import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class TrustNonFacebookSocketFactory extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private static final String[] a = { "facebook.com", "beta.facebook.com", "latest.facebook.com" };
  private static final X509HostnameVerifier b = new TrustNonFacebookSocketFactory.SelectedHostsVerifier(a, BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
  private static TrustManager d = new TrustNonFacebookSocketFactory.1();
  private SSLContext c = SSLContext.getInstance("TLS");

  private TrustNonFacebookSocketFactory(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    SSLContext localSSLContext = this.c;
    TrustManager[] arrayOfTrustManager = new TrustManager[1];
    arrayOfTrustManager[0] = d;
    localSSLContext.init(null, arrayOfTrustManager, new SecureRandom());
  }

  public static org.apache.http.conn.ssl.SSLSocketFactory a()
  {
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      localKeyStore.load(null, null);
      localTrustNonFacebookSocketFactory = new TrustNonFacebookSocketFactory(localKeyStore);
      localTrustNonFacebookSocketFactory.setHostnameVerifier(b);
      return localTrustNonFacebookSocketFactory;
    }
    catch (Exception localException)
    {
      while (true)
        TrustNonFacebookSocketFactory localTrustNonFacebookSocketFactory = null;
    }
  }

  public Socket createSocket()
  {
    return this.c.getSocketFactory().createSocket();
  }

  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    SSLSocket localSSLSocket = (SSLSocket)this.c.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    getHostnameVerifier().verify(paramString, localSSLSocket);
    return localSSLSocket;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.TrustNonFacebookSocketFactory
 * JD-Core Version:    0.6.2
 */