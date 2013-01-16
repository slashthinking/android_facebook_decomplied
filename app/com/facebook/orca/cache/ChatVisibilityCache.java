package com.facebook.orca.cache;

import android.os.SystemClock;

public class ChatVisibilityCache
{
  private boolean a = false;
  private long b = 0L;

  public void a(boolean paramBoolean)
  {
    monitorenter;
    try
    {
      this.a = paramBoolean;
      this.b = SystemClock.elapsedRealtime();
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

  public boolean a()
  {
    monitorenter;
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = this.b;
      if (l1 - l2 < 300000L)
      {
        i = 1;
        return i;
      }
      int i = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public boolean b()
  {
    monitorenter;
    try
    {
      boolean bool = this.a;
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void c()
  {
    monitorenter;
    try
    {
      this.b = 0L;
      this.a = false;
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
 * Qualified Name:     com.facebook.orca.cache.ChatVisibilityCache
 * JD-Core Version:    0.6.0
 */