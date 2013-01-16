package com.facebook.analytics;

import com.facebook.orca.common.util.StringUtil;
import java.util.ArrayList;
import java.util.UUID;

public class TimeSpentAnalyticsClientEvent
{
  private long a;
  private long b;
  private long c;
  private long d = 0L;
  private int e = 0;
  private String f = UUID.randomUUID().toString();
  private ArrayList<Long> g = new ArrayList(10);

  public TimeSpentAnalyticsClientEvent(long paramLong)
  {
    this.c = paramLong;
    this.b = paramLong;
    this.a = paramLong;
  }

  private boolean c(long paramLong)
  {
    int i = 1;
    if (this.g.size() < i)
    {
      this.g.add(Long.valueOf(this.c));
      this.g.add(Long.valueOf(this.b - this.c));
      this.a = this.b;
      this.d += this.b - this.c;
      this.b = paramLong;
      this.c = paramLong;
      if (this.g.size() < 10)
        break label141;
    }
    while (true)
    {
      return i;
      this.g.add(Long.valueOf(this.c - this.a));
      this.g.add(Long.valueOf(this.b - this.c));
      break;
      label141: int j = 0;
    }
  }

  private void d()
  {
    this.e = (1 + this.e);
    this.g.clear();
  }

  public void a()
  {
    this.d = 0L;
    this.e = 0;
    this.f = UUID.randomUUID().toString();
  }

  public boolean a(long paramLong)
  {
    if (paramLong - this.b > 10000L);
    for (boolean bool = c(paramLong); ; bool = false)
    {
      return bool;
      this.b = paramLong;
    }
  }

  public HoneyClientEvent b()
  {
    HoneyClientEvent localHoneyClientEvent;
    if (this.g.size() > 0)
    {
      localHoneyClientEvent = new HoneyClientEvent("time_spent").b("tos_array", StringUtil.a(this.g.toString(), new Object[0])).a("tos_sum", this.d).a("tos_seq", this.e).b("tos_id", this.f);
      d();
    }
    while (true)
    {
      return localHoneyClientEvent;
      localHoneyClientEvent = null;
    }
  }

  public void b(long paramLong)
  {
    c(paramLong);
  }

  public void c()
  {
    if (this.b != this.a)
      c(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.TimeSpentAnalyticsClientEvent
 * JD-Core Version:    0.6.2
 */