package org.acra.util;

import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.acra.ACRA;
import org.acra.reporter.ReportsCrashes;

public class HttpUtils
{
  public static void doPost(Map<?, ?> paramMap, URL paramURL)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (localStringBuilder.length() != 0)
        localStringBuilder.append('&');
      Object localObject3 = paramMap.get(localObject2);
      if (localObject3 == null)
        localObject3 = "";
      localStringBuilder.append(URLEncoder.encode(localObject2.toString(), "UTF-8")).append('=').append(URLEncoder.encode(localObject3.toString(), "UTF-8"));
    }
    if (ACRA.getConfig().checkSSLCertsOnCrashReport());
    for (Object localObject1 = new SSLConnectionProvider(); ; localObject1 = new UnsafeConnectionProvider())
    {
      new HttpRequest((HttpConnectionProvider)localObject1).sendPost(paramURL, localStringBuilder.toString(), new ACRAResponse());
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     org.acra.util.HttpUtils
 * JD-Core Version:    0.6.0
 */