package com.facebook.orca.debug;

import com.facebook.debug.LogPrefixer;
import com.facebook.orca.common.util.ObjectPool;
import com.facebook.orca.common.util.ObjectPoolBuilder;
import com.facebook.orca.common.util.SystemClock;

public class Tracer
{
  private static final ThreadLocal<ThreadTrace> a = new ThreadLocal();
  private static final ObjectPool<Tracer> e = new ObjectPoolBuilder(Tracer.class, SystemClock.b()).a(new Tracer.1(Tracer.class)).a();
  private ThreadTrace b = null;
  private long c = -1L;
  private long d = 0L;

  private long a(long paramLong, boolean paramBoolean)
  {
    long l;
    if (this.b != null)
      l = this.b.a(this.c, paramLong, paramBoolean);
    while (true)
    {
      e.a(this);
      return l;
      l = System.currentTimeMillis() - this.d;
    }
  }

  public static Tracer a(String paramString)
  {
    return a(paramString, null);
  }

  public static Tracer a(String paramString1, String paramString2)
  {
    Tracer localTracer = (Tracer)e.a();
    localTracer.b = ((ThreadTrace)a.get());
    if (localTracer.b != null)
      localTracer.c = localTracer.b.a(paramString1, paramString2);
    for (localTracer.d = 0L; ; localTracer.d = System.currentTimeMillis())
    {
      return localTracer;
      localTracer.c = -1L;
    }
  }

  public static void a(int paramInt, String paramString)
  {
    ThreadTrace localThreadTrace = (ThreadTrace)a.get();
    if (localThreadTrace != null)
    {
      localThreadTrace.a(paramInt, paramString);
      a.set(null);
    }
  }

  public static void a(Class<?> paramClass)
  {
    b(LogPrefixer.a(paramClass));
  }

  public static void b()
  {
    ThreadTrace localThreadTrace = (ThreadTrace)a.get();
    if (localThreadTrace != null)
    {
      localThreadTrace.a();
      a.set(null);
    }
  }

  public static void b(long paramLong)
  {
    ThreadTrace localThreadTrace = (ThreadTrace)a.get();
    if (localThreadTrace == null)
    {
      localThreadTrace = new ThreadTrace();
      a.set(localThreadTrace);
    }
    localThreadTrace.a(paramLong);
  }

  public static void b(String paramString)
  {
    a(3, paramString);
  }

  public static String c()
  {
    ThreadTrace localThreadTrace = (ThreadTrace)a.get();
    if (localThreadTrace != null);
    for (String str = localThreadTrace.b(); ; str = "")
      return str;
  }

  public long a()
  {
    return a(0L, false);
  }

  public long a(long paramLong)
  {
    return a(paramLong, true);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.Tracer
 * JD-Core Version:    0.6.0
 */