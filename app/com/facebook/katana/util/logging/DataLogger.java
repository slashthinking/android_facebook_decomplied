package com.facebook.katana.util.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticCounters;
import com.facebook.analytics.NetworkDataLogger;
import java.net.URI;

public class DataLogger
  implements NetworkDataLogger
{
  private final AnalyticCounters a;

  public DataLogger(Context paramContext, AnalyticCounters paramAnalyticCounters)
  {
    this.a = paramAnalyticCounters;
    DataCounterNames.a(paramContext);
  }

  public void a(URI paramURI, long paramLong)
  {
    String str = DataCounterNames.a(paramURI);
    this.a.a(str, paramLong);
  }

  public void a(URI paramURI, String paramString, long paramLong)
  {
    String str = DataCounterNames.a(paramURI, paramString);
    this.a.a(str, paramLong);
  }

  public void a(URI paramURI, String paramString, long paramLong1, long paramLong2)
  {
    String str = DataCounterNames.a(paramURI, paramString);
    if (paramLong2 >= 0L)
      paramLong1 += paramLong2;
    this.a.a(str, paramLong1);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.DataLogger
 * JD-Core Version:    0.6.0
 */