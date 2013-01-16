package com.facebook.orca.common.async;

import com.google.common.collect.Lists;
import java.util.Queue;
import java.util.concurrent.Executor;

public class PrioritySerialExecutorImpl
  implements PrioritySerialExecutor
{
  private static final Class<?> a = PrioritySerialExecutorImpl.class;
  private final Executor b;
  private final Queue<Runnable>[] c;
  private final PrioritySerialExecutorImpl.Worker d = new PrioritySerialExecutorImpl.Worker(this, null);
  private boolean e = false;
  private int f;

  public PrioritySerialExecutorImpl(Executor paramExecutor)
  {
    this.b = paramExecutor;
    int j = PrioritySerialExecutor.Priority.values().length;
    this.c = new Queue[j];
    while (i < j)
    {
      this.c[i] = Lists.b();
      i++;
    }
    this.f = j;
  }

  private Runnable b()
  {
    monitorenter;
    int i = 0;
    try
    {
      while (i < this.f)
      {
        localRunnable = (Runnable)this.c[i].poll();
        if (localRunnable != null)
          return localRunnable;
        i++;
      }
      Runnable localRunnable = null;
    }
    finally
    {
      monitorexit;
    }
  }

  private void c()
  {
    monitorenter;
    try
    {
      if ((!this.e) && (!a()))
      {
        this.e = true;
        this.b.execute(this.d);
      }
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

  public void a(Runnable paramRunnable, PrioritySerialExecutor.Priority paramPriority)
  {
    monitorenter;
    try
    {
      this.c[paramPriority.ordinal()].offer(paramRunnable);
      c();
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
    int i = 0;
    try
    {
      while (i < this.f)
      {
        boolean bool = this.c[i].isEmpty();
        j = 0;
        if (!bool)
          return j;
        i++;
      }
      int j = 1;
    }
    finally
    {
      monitorexit;
    }
  }

  public void execute(Runnable paramRunnable)
  {
    monitorenter;
    try
    {
      a(paramRunnable, PrioritySerialExecutor.Priority.NORMAL);
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
 * Qualified Name:     com.facebook.orca.common.async.PrioritySerialExecutorImpl
 * JD-Core Version:    0.6.0
 */