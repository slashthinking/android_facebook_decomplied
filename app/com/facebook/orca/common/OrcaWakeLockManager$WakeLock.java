package com.facebook.orca.common;

import android.os.PowerManager.WakeLock;

public class OrcaWakeLockManager$WakeLock
{
  private final PowerManager.WakeLock b;
  private final String c;
  private int d;
  private long e;
  private long f;
  private int g;
  private boolean h;

  OrcaWakeLockManager$WakeLock(OrcaWakeLockManager paramOrcaWakeLockManager, PowerManager.WakeLock paramWakeLock, String paramString)
  {
    this.b = paramWakeLock;
    this.c = paramString;
  }

  public void a()
  {
    monitorenter;
    try
    {
      a(-1L);
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

  public void a(long paramLong)
  {
    monitorenter;
    try
    {
      c();
      if (paramLong < 0L)
        this.b.acquire();
      while (true)
      {
        this.d = (1 + this.d);
        if (this.d == 1)
          this.e = System.currentTimeMillis();
        return;
        this.b.acquire(paramLong);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void b()
  {
    monitorenter;
    while (true)
    {
      try
      {
        boolean bool = this.h;
        if (bool)
          return;
        if (this.d == 0)
        {
          this.g = (1 + this.g);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      this.b.release();
      this.d = (-1 + this.d);
      if (this.d != 0)
        continue;
      this.f += System.currentTimeMillis() - this.e;
    }
  }

  public void c()
  {
    if (this.h)
      throw new RuntimeException("Wake lock already disposed");
  }

  public boolean d()
  {
    monitorenter;
    try
    {
      int i = this.d;
      if (i > 0)
      {
        j = 1;
        return j;
      }
      int j = 0;
    }
    finally
    {
      monitorexit;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.OrcaWakeLockManager.WakeLock
 * JD-Core Version:    0.6.0
 */