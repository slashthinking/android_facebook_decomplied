package com.facebook.orca.debug;

import com.facebook.orca.common.util.ObjectPool;
import com.facebook.orca.common.util.ObjectPoolBuilder;
import com.facebook.orca.common.util.SystemClock;

class TraceEvent
{
  private static final ObjectPool<TraceEvent> g = new ObjectPoolBuilder(TraceEvent.class, SystemClock.b()).a(new TraceEvent.1(TraceEvent.class)).a();
  private TraceEvent.Type a;
  private long b;
  private String c;
  private String d;
  private long e;
  private long f;

  static TraceEvent a(TraceEvent.Type paramType, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    TraceEvent localTraceEvent = (TraceEvent)g.a();
    localTraceEvent.a = paramType;
    localTraceEvent.b = paramLong1;
    localTraceEvent.c = paramString1;
    localTraceEvent.d = paramString2;
    localTraceEvent.e = System.currentTimeMillis();
    localTraceEvent.f = paramLong2;
    return localTraceEvent;
  }

  static String a(long paramLong)
  {
    long l = Math.round((float)paramLong);
    String str = "";
    if (l < 10000L)
      str = "_";
    if (l < 1000L)
      str = "__";
    if (l < 100L)
      str = "___";
    if (l < 10L)
      str = "____";
    return str + l;
  }

  static String b(long paramLong)
  {
    long l1 = Math.round((float)paramLong);
    long l2 = Math.max(0L, l1 / 1000L % 60L);
    long l3 = Math.max(l1 % 1000L, 0L);
    return Long.toString(l2 + 100L).substring(1, 3) + '.' + Long.toString(l3 + 1000L).substring(1, 4);
  }

  String a(long paramLong1, long paramLong2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramLong2 == -1L)
    {
      localStringBuilder.append("-----");
      localStringBuilder.append(" ");
      localStringBuilder.append(b(this.e - paramLong1));
      if (this.a != TraceEvent.Type.START)
        break label108;
      localStringBuilder.append(" Start         ");
    }
    while (true)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(toString());
      return localStringBuilder.toString();
      localStringBuilder.append(a(this.e - paramLong2));
      break;
      label108: if (this.a == TraceEvent.Type.STOP)
      {
        localStringBuilder.append(" Done ");
        localStringBuilder.append(a(this.e - this.f));
        localStringBuilder.append(" ms ");
        continue;
      }
      localStringBuilder.append(" Comment       ");
    }
  }

  void a()
  {
    g.a(this);
  }

  public long b()
  {
    return this.b;
  }

  public TraceEvent.Type c()
  {
    return this.a;
  }

  public String d()
  {
    return this.c;
  }

  public String e()
  {
    return this.d;
  }

  public long f()
  {
    return this.e;
  }

  public String toString()
  {
    if (this.d == null);
    for (String str = this.c; ; str = "[" + this.d + "] " + this.c)
      return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.TraceEvent
 * JD-Core Version:    0.6.0
 */