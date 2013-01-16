package com.facebook.analytics.performance;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import java.util.UUID;

public class PerformanceLogger$MarkerConfig
{
  private String a;
  private String b;
  private String c;
  private long d = 0L;
  private long e = -1L;
  private long f = -1L;
  private boolean g;
  private Set<Class<?>> h;

  public PerformanceLogger$MarkerConfig(String paramString)
  {
    this.b = paramString;
    this.a = UUID.randomUUID().toString();
  }

  public MarkerConfig a()
  {
    this.g = true;
    return this;
  }

  public MarkerConfig a(long paramLong)
  {
    this.e = paramLong;
    return this;
  }

  public MarkerConfig a(Class<?>[] paramArrayOfClass)
  {
    this.h = ImmutableSet.a(paramArrayOfClass);
    return this;
  }

  public MarkerConfig b(long paramLong)
  {
    this.f = paramLong;
    return this;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.performance.PerformanceLogger.MarkerConfig
 * JD-Core Version:    0.6.2
 */