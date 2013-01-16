package com.facebook.analytics;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;

public abstract class HoneyAnalyticsEvent
  implements AnalyticsEvent
{
  protected final String a;
  private long b = -1L;
  private String c = "AUTO_SET";
  private boolean d;
  private final Map<String, String> e;

  public HoneyAnalyticsEvent(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.e = Maps.a();
    this.c = paramString2;
  }

  protected HoneyAnalyticsEvent a(long paramLong)
  {
    this.b = paramLong;
    return this;
  }

  public <T extends HoneyAnalyticsEvent> T a(String paramString1, String paramString2)
  {
    this.e.put(paramString1, paramString2);
    return this;
  }

  HoneyAnalyticsEvent a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }

  public String a()
  {
    return this.a;
  }

  public boolean a(String paramString)
  {
    return this.e.containsKey(paramString);
  }

  public long b()
  {
    return this.b;
  }

  public String b(String paramString)
  {
    return (String)this.e.get(paramString);
  }

  HoneyAnalyticsEvent c(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public String c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.d;
  }

  public abstract JsonNode e();

  Set<String> f()
  {
    return this.e.keySet();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.analytics.HoneyAnalyticsEvent
 * JD-Core Version:    0.6.0
 */