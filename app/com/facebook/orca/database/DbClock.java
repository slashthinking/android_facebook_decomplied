package com.facebook.orca.database;

import com.facebook.orca.common.util.Clock;

public class DbClock
  implements Clock
{
  private long a;

  public long a()
  {
    monitorenter;
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.a;
      if (l1 > l2);
      while (true)
      {
        return l1;
        this.a = (1L + this.a);
        l1 = this.a;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  void a(long paramLong)
  {
    monitorenter;
    try
    {
      this.a = Math.max(paramLong, this.a);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.database.DbClock
 * JD-Core Version:    0.6.0
 */