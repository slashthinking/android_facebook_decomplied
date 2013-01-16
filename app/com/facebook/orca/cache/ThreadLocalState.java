package com.facebook.orca.cache;

import android.location.Location;

class ThreadLocalState
{
  private final String a;
  private long b = -1L;
  private long c = -1L;
  private boolean d;
  private Location e;
  private long f;
  private long g;

  ThreadLocalState(String paramString)
  {
    this.a = paramString;
  }

  public void a(long paramLong)
  {
    this.b = paramLong;
    if (paramLong > this.c)
      this.c = -1L;
  }

  public void a(Location paramLocation, long paramLong)
  {
    this.e = paramLocation;
    this.f = paramLong;
  }

  public boolean a()
  {
    return this.d;
  }

  public void b()
  {
    this.d = true;
  }

  public void b(long paramLong)
  {
    if (paramLong <= this.b);
    for (this.c = -1L; ; this.c = paramLong)
      return;
  }

  public void c()
  {
    this.d = false;
  }

  public void c(long paramLong)
  {
    this.g = paramLong;
  }

  public long d()
  {
    return this.b;
  }

  public long e()
  {
    return this.c;
  }

  public long f()
  {
    long l;
    if (this.c > -1L)
      l = this.c;
    while (true)
    {
      return l;
      l = this.b;
    }
  }

  public long g()
  {
    return this.g;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.ThreadLocalState
 * JD-Core Version:    0.6.0
 */