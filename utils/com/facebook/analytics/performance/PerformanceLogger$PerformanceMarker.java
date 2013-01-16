package com.facebook.analytics.performance;

import com.facebook.debug.Assert;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import java.util.UUID;

class PerformanceLogger$PerformanceMarker
{
  final String a;
  final String b;
  private double c;
  private long d;
  private ImmutableSet<Class<?>> e;
  private boolean f;

  public PerformanceLogger$PerformanceMarker(String paramString)
  {
    this(paramString, UUID.randomUUID().toString(), 0L);
  }

  public PerformanceLogger$PerformanceMarker(String paramString1, String paramString2, long paramLong)
  {
    Assert.a(paramString1);
    Assert.a(paramString2);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong;
  }

  public double a()
  {
    try
    {
      double d1 = this.c;
      return d1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(double paramDouble)
  {
    try
    {
      this.c = paramDouble;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(long paramLong)
  {
    try
    {
      this.d = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Set<Class<?>> paramSet)
  {
    if (paramSet != null);
    try
    {
      for (this.e = ImmutableSet.a(paramSet); ; this.e = null)
        return;
    }
    finally
    {
    }
  }

  public boolean a(Class<?> paramClass)
  {
    try
    {
      if (this.e != null)
      {
        boolean bool2 = this.e.contains(paramClass);
        if (!bool2);
      }
      else
      {
        bool1 = true;
        return bool1;
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  public long b()
  {
    try
    {
      long l = this.d;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c()
  {
    this.f = true;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.performance.PerformanceLogger.PerformanceMarker
 * JD-Core Version:    0.6.2
 */