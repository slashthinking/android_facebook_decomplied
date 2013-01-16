package com.facebook.orca.app;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

public class AppInitLock
{
  private final AndroidThreadUtil a;
  private Set<AppInitLock.Listener> b = Sets.a();
  private boolean c;

  public AppInitLock(AndroidThreadUtil paramAndroidThreadUtil)
  {
    this.a = paramAndroidThreadUtil;
  }

  private void d()
  {
    this.a.b(new AppInitLock.1(this));
  }

  private void e()
  {
    monitorenter;
    try
    {
      Set localSet = this.b;
      this.b = Sets.a();
      monitorexit;
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
        ((AppInitLock.Listener)localIterator.next()).a();
    }
    finally
    {
      monitorexit;
    }
  }

  protected void a()
  {
    monitorenter;
    try
    {
      this.c = true;
      notifyAll();
      monitorexit;
      d();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(AppInitLock.Listener paramListener)
  {
    this.a.a();
    monitorenter;
    try
    {
      this.b.add(paramListener);
      boolean bool = this.c;
      monitorexit;
      if (bool)
        d();
      return;
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
    try
    {
      while (true)
      {
        boolean bool = this.c;
        if (!bool)
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new RuntimeException(localInterruptedException);
          }
      }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public boolean c()
  {
    monitorenter;
    try
    {
      boolean bool = this.c;
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
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.AppInitLock
 * JD-Core Version:    0.6.0
 */