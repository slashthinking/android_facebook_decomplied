package com.karmascience.gifts;

import java.util.HashMap;
import java.util.Map;

public class AnalyticsWrapper$MetricsEvent
{
  private final String a;
  private final AnalyticsWrapper b;
  private final Map<String, String> c;

  private AnalyticsWrapper$MetricsEvent(String paramString, AnalyticsWrapper paramAnalyticsWrapper)
  {
    this.a = paramString;
    this.b = paramAnalyticsWrapper;
    this.c = new HashMap();
  }

  public MetricsEvent a(String paramString1, String paramString2)
  {
    this.c.put(paramString1, paramString2);
    return this;
  }

  public MetricsEvent a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
      this.c.putAll(paramMap);
    return this;
  }

  public void a()
  {
    AnalyticsWrapper.a(this.b, this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.AnalyticsWrapper.MetricsEvent
 * JD-Core Version:    0.6.0
 */