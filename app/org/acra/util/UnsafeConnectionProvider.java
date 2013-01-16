package org.acra.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.acra.ACRA;
import org.acra.reporter.ReportsCrashes;

public class UnsafeConnectionProvider
  implements HttpConnectionProvider
{
  public HttpURLConnection getConnection(URL paramURL)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    if ((localHttpURLConnection instanceof HttpsURLConnection));
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      TrustManager[] arrayOfTrustManager = new TrustManager[1];
      arrayOfTrustManager[0] = new TrustEveryoneTrustManager();
      localSSLContext.init(null, arrayOfTrustManager, null);
      SSLSocketFactory localSSLSocketFactory = localSSLContext.getSocketFactory();
      HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)localHttpURLConnection;
      localHttpsURLConnection.setSSLSocketFactory(localSSLSocketFactory);
      localHttpsURLConnection.setHostnameVerifier(new UnsafeConnectionProvider.1(this));
      label81: return initializeConnectionParameters(localHttpURLConnection);
    }
    catch (KeyManagementException localKeyManagementException)
    {
      break label81;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label81;
    }
  }

  public HttpURLConnection initializeConnectionParameters(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.setConnectTimeout(ACRA.getConfig().socketTimeout());
    paramHttpURLConnection.setReadTimeout(ACRA.getConfig().socketTimeout());
    return paramHttpURLConnection;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.UnsafeConnectionProvider
 * JD-Core Version:    0.6.0
 */