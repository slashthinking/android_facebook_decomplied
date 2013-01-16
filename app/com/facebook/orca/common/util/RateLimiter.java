package com.facebook.orca.common.util;

public class RateLimiter
{
  private final Clock a;
  private final int b;
  private final long c;
  private double d;
  private long e;

  public RateLimiter(Clock paramClock, int paramInt, long paramLong)
  {
    this.a = paramClock;
    this.b = paramInt;
    this.c = paramLong;
    this.d = paramInt;
  }

  public boolean a()
  {
    monitorenter;
    try
    {
      long l1 = this.a.a();
      long l2 = l1 - this.e;
      this.e = l1;
      this.d += l2 * (this.b / this.c);
      if (this.d > this.b)
        this.d = this.b;
      double d1 = this.d;
      if (d1 < 1.0D);
      for (int i = 0; ; i = 1)
      {
        return i;
        this.d -= 1.0D;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.RateLimiter
 * JD-Core Version:    0.6.0
 */