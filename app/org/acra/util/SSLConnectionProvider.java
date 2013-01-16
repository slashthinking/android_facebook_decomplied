package org.acra.util;

import java.net.HttpURLConnection;
import java.net.URL;
import org.acra.ACRA;
import org.acra.reporter.ReportsCrashes;

public class SSLConnectionProvider
  implements HttpConnectionProvider
{
  public HttpURLConnection getConnection(URL paramURL)
  {
    return initializeConnectionParameters((HttpURLConnection)paramURL.openConnection());
  }

  public HttpURLConnection initializeConnectionParameters(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.setConnectTimeout(ACRA.getConfig().socketTimeout());
    paramHttpURLConnection.setReadTimeout(ACRA.getConfig().socketTimeout());
    return paramHttpURLConnection;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.SSLConnectionProvider
 * JD-Core Version:    0.6.0
 */