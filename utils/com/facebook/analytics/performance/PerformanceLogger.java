package com.facebook.analytics.performance;

import android.app.Activity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.debug.BLog;
import com.google.common.collect.MapMaker;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class PerformanceLogger
{
  private static final Class<?> a = PerformanceLogger.class;
  private final AnalyticsLogger b;
  private final ConcurrentMap<String, PerformanceLogger.PerformanceMarker> c;
  private final String d;
  private boolean e = true;
  private long f = 0L;
  private long g = 0L;
  private Boolean h;

  public PerformanceLogger(AnalyticsLogger paramAnalyticsLogger)
  {
    this.b = paramAnalyticsLogger;
    this.c = new MapMaker().a(25).a(300L, TimeUnit.SECONDS).n();
    this.d = System.getProperty("scenario", null);
  }

  private String a(PerformanceLogger.PerformanceMarker paramPerformanceMarker, String paramString)
  {
    return d(paramPerformanceMarker.a, paramString);
  }

  private void a(PerformanceLogger.PerformanceMarker paramPerformanceMarker, MarkerType paramMarkerType)
  {
    try
    {
      a(paramPerformanceMarker, paramMarkerType, -1L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(PerformanceLogger.PerformanceMarker paramPerformanceMarker, MarkerType paramMarkerType, long paramLong)
  {
    if (paramPerformanceMarker == null);
    while (true)
    {
      return;
      try
      {
        HoneyPerformanceEvent localHoneyPerformanceEvent1 = new HoneyPerformanceEvent(paramPerformanceMarker.a, paramPerformanceMarker.b, paramMarkerType.toString(), paramPerformanceMarker.a(), paramLong, this.d);
        this.b.a(localHoneyPerformanceEvent1);
        long l1 = localHoneyPerformanceEvent1.b();
        if (paramPerformanceMarker.b() == 0L)
          paramPerformanceMarker.a(l1);
        long l2 = l1 - paramPerformanceMarker.b();
        paramPerformanceMarker.a(l1);
        if ((l2 > 0L) && (paramMarkerType == MarkerType.STOP))
        {
          HoneyPerformanceEvent localHoneyPerformanceEvent2 = new HoneyPerformanceEvent(paramPerformanceMarker.a, paramPerformanceMarker.b, MarkerType.CLIENT_TTI.toString(), l2, paramLong, this.d);
          this.b.a(localHoneyPerformanceEvent2);
        }
        if ((!b()) || (!BLog.b(3)))
          continue;
        Class localClass = a;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = paramPerformanceMarker.a;
        arrayOfObject[1] = Long.valueOf(l1);
        arrayOfObject[2] = Long.valueOf(l2);
        BLog.b(localClass, "Name: %s; Timestamp (ms): %d; Elapsed (ms): %d", arrayOfObject);
      }
      finally
      {
      }
    }
  }

  private void a(PerformanceLogger.PerformanceMarker paramPerformanceMarker, String paramString, long paramLong)
  {
    try
    {
      String str = a(paramPerformanceMarker, paramString);
      if (!this.c.containsKey(str))
      {
        this.c.put(str, paramPerformanceMarker);
        a(paramPerformanceMarker, MarkerType.START, paramLong);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private String d(String paramString1, String paramString2)
  {
    if (paramString2 == null);
    while (true)
    {
      return paramString1;
      paramString1 = paramString2 + ":" + paramString1;
    }
  }

  private boolean d()
  {
    boolean bool1 = true;
    while (true)
    {
      try
      {
        long l1 = this.f;
        if (l1 == 0L)
          return bool1;
        if (this.h != null)
          break label95;
        if (this.g > 0L)
        {
          l2 = this.g;
          if (l2 - this.f <= 2000L)
            break label110;
          if ((!bool1) && (this.g <= 0L))
            continue;
          this.h = Boolean.valueOf(bool1);
          continue;
        }
      }
      finally
      {
      }
      long l2 = SystemClock.b().a();
      continue;
      label95: boolean bool2 = this.h.booleanValue();
      bool1 = bool2;
      continue;
      label110: bool1 = false;
    }
  }

  void a()
  {
    try
    {
      if (this.g == 0L)
        this.g = SystemClock.b().a();
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
    if (this.f == 0L)
      this.f = paramLong;
  }

  void a(Activity paramActivity)
  {
    new PerformanceLogger.1(this, paramActivity).start();
  }

  public void a(PerformanceLogger.MarkerConfig paramMarkerConfig)
  {
    PerformanceLogger.PerformanceMarker localPerformanceMarker = new PerformanceLogger.PerformanceMarker(PerformanceLogger.MarkerConfig.a(paramMarkerConfig), PerformanceLogger.MarkerConfig.b(paramMarkerConfig), PerformanceLogger.MarkerConfig.c(paramMarkerConfig));
    localPerformanceMarker.a(PerformanceLogger.MarkerConfig.d(paramMarkerConfig));
    if (PerformanceLogger.MarkerConfig.e(paramMarkerConfig))
      localPerformanceMarker.c();
    a(localPerformanceMarker, PerformanceLogger.MarkerConfig.f(paramMarkerConfig), PerformanceLogger.MarkerConfig.g(paramMarkerConfig));
  }

  public void a(String paramString)
  {
    a(paramString, null);
  }

  public void a(String paramString, double paramDouble)
  {
    try
    {
      a(paramString, null, paramDouble);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(String paramString, MarkerType paramMarkerType)
  {
    a(paramString, null, paramMarkerType);
  }

  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, -1L);
  }

  public void a(String paramString1, String paramString2, double paramDouble)
  {
    try
    {
      String str = d(paramString1, paramString2);
      PerformanceLogger.PerformanceMarker localPerformanceMarker = (PerformanceLogger.PerformanceMarker)this.c.get(str);
      if (localPerformanceMarker != null)
      {
        localPerformanceMarker.a(paramDouble);
        a(localPerformanceMarker, MarkerType.VALUE);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(String paramString1, String paramString2, long paramLong)
  {
    a(new PerformanceLogger.PerformanceMarker(paramString1), paramString2, paramLong);
  }

  public void a(String paramString1, String paramString2, MarkerType paramMarkerType)
  {
    try
    {
      String str = d(paramString1, paramString2);
      a((PerformanceLogger.PerformanceMarker)this.c.get(str), paramMarkerType);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      this.e = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(PerformanceLogger.MarkerConfig paramMarkerConfig)
  {
    b(PerformanceLogger.MarkerConfig.a(paramMarkerConfig), PerformanceLogger.MarkerConfig.f(paramMarkerConfig), PerformanceLogger.MarkerConfig.h(paramMarkerConfig));
  }

  public void b(String paramString)
  {
    b(paramString, null);
  }

  public void b(String paramString1, String paramString2)
  {
    try
    {
      b(paramString1, paramString2, -1L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      String str = d(paramString1, paramString2);
      PerformanceLogger.PerformanceMarker localPerformanceMarker = (PerformanceLogger.PerformanceMarker)this.c.get(str);
      if (localPerformanceMarker != null)
      {
        if ((!PerformanceLogger.PerformanceMarker.a(localPerformanceMarker)) || (!d()))
          break label61;
        this.c.remove(str);
      }
      while (true)
      {
        return;
        label61: a(localPerformanceMarker, MarkerType.STOP, paramLong);
        this.c.remove(str);
      }
    }
    finally
    {
    }
  }

  public boolean b()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c()
  {
    try
    {
      this.c.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c(String paramString)
  {
    c(paramString, null);
  }

  public void c(String paramString1, String paramString2)
  {
    try
    {
      String str = d(paramString1, paramString2);
      if ((PerformanceLogger.PerformanceMarker)this.c.get(str) != null)
        this.c.remove(str);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.performance.PerformanceLogger
 * JD-Core Version:    0.6.2
 */