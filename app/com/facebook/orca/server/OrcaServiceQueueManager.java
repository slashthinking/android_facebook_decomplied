package com.facebook.orca.server;

import android.content.Context;
import android.content.Intent;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.server.module.AuthQueue;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OrcaServiceQueueManager
{
  private static final Class<?> a = OrcaServiceQueueManager.class;
  private static final WtfToken b = new WtfToken();
  private final Context c;
  private final OrcaServiceRegistry d;
  private final Set<OrcaServiceQueue> e = Sets.a();
  private boolean f;

  public OrcaServiceQueueManager(Context paramContext, OrcaServiceRegistry paramOrcaServiceRegistry)
  {
    this.c = paramContext;
    this.d = paramOrcaServiceRegistry;
  }

  private boolean c(OrcaServiceQueue paramOrcaServiceQueue)
  {
    if (paramOrcaServiceQueue.a() == AuthQueue.class);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void a()
  {
    monitorenter;
    HashSet localHashSet;
    try
    {
      this.f = true;
      BLog.c(a, "Draining all OrcaService instances with started queues");
      localHashSet = Sets.a();
      Iterator localIterator1 = this.e.iterator();
      while (localIterator1.hasNext())
      {
        Class localClass3 = ((OrcaServiceQueue)localIterator1.next()).a();
        localHashSet.add(this.d.a(localClass3));
      }
    }
    finally
    {
      monitorexit;
    }
    Iterator localIterator2 = localHashSet.iterator();
    while (localIterator2.hasNext())
    {
      Class localClass1 = (Class)localIterator2.next();
      Class localClass2 = a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localClass1.getSimpleName();
      BLog.c(localClass2, "Draining service %s", arrayOfObject);
      Intent localIntent = new Intent(this.c, localClass1);
      localIntent.setAction("Orca.DRAIN");
      this.c.startService(localIntent);
    }
    monitorexit;
  }

  public void a(OrcaServiceQueue paramOrcaServiceQueue)
  {
    monitorenter;
    try
    {
      boolean bool = c(paramOrcaServiceQueue);
      if (bool);
      while (true)
      {
        return;
        this.e.add(paramOrcaServiceQueue);
        notifyAll();
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
    try
    {
      this.f = false;
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

  public void b(OrcaServiceQueue paramOrcaServiceQueue)
  {
    monitorenter;
    try
    {
      boolean bool = c(paramOrcaServiceQueue);
      if (bool);
      while (true)
      {
        return;
        if (!this.e.remove(paramOrcaServiceQueue))
        {
          WtfToken localWtfToken = b;
          Class localClass = a;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = paramOrcaServiceQueue.a();
          BLog.a(localWtfToken, localClass, "Unknown queue [%s]", arrayOfObject);
        }
        notifyAll();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean c()
  {
    monitorenter;
    try
    {
      boolean bool = this.f;
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

  public void d()
  {
    monitorenter;
    try
    {
      Preconditions.checkState(this.f);
      while (!this.e.isEmpty())
      {
        Class localClass = a;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(this.e.size());
        BLog.b(localClass, "Waiting for %d queues to stop", arrayOfObject);
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
        }
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OrcaServiceQueueManager
 * JD-Core Version:    0.6.0
 */