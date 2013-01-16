package com.facebook.orca.debug;

import com.facebook.orca.common.util.StringUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadTrace
{
  private static Class<?> a = ThreadTrace.class;
  private static AtomicLong b = new AtomicLong();
  private long c;
  private List<TraceEvent> d = Lists.a();
  private Map<Long, TraceEvent> e = Maps.a();
  private long f;

  private String a(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localStringBuilder.append((String)localIterator.next());
    return localStringBuilder.toString();
  }

  private void b(long paramLong)
  {
    this.c = paramLong;
    d();
    c();
    this.f = System.currentTimeMillis();
  }

  private void c()
  {
    for (int i = 0; i < this.d.size(); i++)
      ((TraceEvent)this.d.get(i)).a();
    this.d.clear();
  }

  private void d()
  {
    this.e.clear();
  }

  long a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (!paramBoolean)
      paramLong2 = this.c;
    TraceEvent localTraceEvent1 = (TraceEvent)this.e.get(Long.valueOf(paramLong1));
    long l3;
    if (localTraceEvent1 == null)
    {
      l3 = -1L;
      return l3;
    }
    this.e.remove(Long.valueOf(paramLong1));
    long l2 = l1 - localTraceEvent1.f();
    int i;
    if (l2 < paramLong2)
    {
      i = -1 + this.d.size();
      label90: if (i >= 0)
      {
        if ((TraceEvent)this.d.get(i) != localTraceEvent1)
          break label138;
        this.d.remove(i);
        localTraceEvent1.a();
      }
    }
    while (true)
    {
      l3 = l2;
      break;
      label138: i--;
      break label90;
      TraceEvent localTraceEvent2 = TraceEvent.a(TraceEvent.Type.STOP, b.incrementAndGet(), localTraceEvent1.d(), localTraceEvent1.e(), localTraceEvent1.f());
      this.d.add(localTraceEvent2);
    }
  }

  long a(String paramString1, String paramString2)
  {
    int i = this.e.size();
    if (i + this.d.size() > 1000)
    {
      BLog.d(a, "Giant thread trace. Clearing to avoid memory leak.");
      if (this.d.size() > 500)
        c();
      if (i > 500)
        d();
    }
    TraceEvent localTraceEvent = TraceEvent.a(TraceEvent.Type.START, b.incrementAndGet(), paramString1, paramString2, -1L);
    this.d.add(localTraceEvent);
    this.e.put(Long.valueOf(localTraceEvent.b()), localTraceEvent);
    return localTraceEvent.b();
  }

  void a()
  {
    b(0L);
  }

  void a(int paramInt, String paramString)
  {
    String str1;
    if (BLog.b(paramInt))
    {
      str1 = b();
      if (!StringUtil.a(str1))
      {
        if (str1.length() <= 4000)
          break label224;
        String[] arrayOfString = str1.split("\n");
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < arrayOfString.length)
        {
          String str2 = arrayOfString[k];
          if ((i == 0) || (i + str2.length() < 4000))
          {
            localStringBuilder.append(str2);
            localStringBuilder.append("\n");
            i += 1 + str2.length();
            k++;
            continue;
          }
          BLog.a(paramInt, paramString, "Thread trace: (" + j + ")\n" + localStringBuilder.toString());
          localStringBuilder.setLength(0);
          j++;
          i = 0;
        }
        if (i > 0)
          BLog.a(paramInt, paramString, "Thread trace: (" + j + ")\n" + localStringBuilder.toString());
      }
    }
    while (true)
    {
      a();
      return;
      label224: BLog.a(paramInt, paramString, "Thread trace:\n" + str1);
    }
  }

  void a(long paramLong)
  {
    b(paramLong);
  }

  String b()
  {
    return toString();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long l1 = -1L;
    long l2 = System.currentTimeMillis();
    LinkedList localLinkedList = Lists.b();
    int i = 0;
    if (i < this.d.size())
    {
      TraceEvent localTraceEvent2 = (TraceEvent)this.d.get(i);
      if (localTraceEvent2.c() == TraceEvent.Type.STOP)
      {
        if (localLinkedList.size() != 0)
          break label175;
        BLog.e(a, "Trace contains a stop event without a corresponding start: " + this.d);
      }
      while (true)
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(localTraceEvent2.a(this.f, l1, a(localLinkedList)));
        localStringBuilder.append(" ");
        l1 = localTraceEvent2.f();
        localStringBuilder.append("\n");
        if (localTraceEvent2.c() == TraceEvent.Type.START)
          localLinkedList.add("|  ");
        i++;
        break;
        label175: localLinkedList.removeFirst();
      }
    }
    if (this.e.size() != 0)
    {
      localStringBuilder.append(" Unstopped timers:\n");
      Iterator localIterator = this.e.values().iterator();
      while (localIterator.hasNext())
      {
        TraceEvent localTraceEvent1 = (TraceEvent)localIterator.next();
        localStringBuilder.append("  ");
        localStringBuilder.append(localTraceEvent1);
        localStringBuilder.append(" (");
        localStringBuilder.append(l2 - localTraceEvent1.f());
        localStringBuilder.append(" ms, started at ");
        localStringBuilder.append(TraceEvent.b(localTraceEvent1.f()));
        localStringBuilder.append("\n");
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.ThreadTrace
 * JD-Core Version:    0.6.0
 */