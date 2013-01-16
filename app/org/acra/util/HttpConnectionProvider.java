package org.acra.util;

import java.net.HttpURLConnection;
import java.net.URL;

public abstract interface HttpConnectionProvider
{
  public abstract HttpURLConnection getConnection(URL paramURL);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.HttpConnectionProvider
 * JD-Core Version:    0.6.0
 */