package com.facebook.dispose;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractDisposable
  implements Disposable
{
  private boolean a = false;
  private Set<DisposeListener> b = null;

  public final void a()
  {
    monitorenter;
    try
    {
      if (c())
      {
        monitorexit;
        return;
      }
      b();
      this.a = true;
      monitorexit;
      if (this.b == null)
        return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
        ((DisposeListener)localIterator.next()).a(this);
    }
    finally
    {
      monitorexit;
    }
    this.b = null;
  }

  public final void a(DisposeListener paramDisposeListener)
  {
    monitorenter;
    try
    {
      if (c());
      for (int i = 1; ; i = 0)
      {
        monitorexit;
        if (i != 0)
          paramDisposeListener.a(this);
        return;
        if (this.b == null)
          this.b = Sets.a();
        this.b.add(paramDisposeListener);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  protected abstract void b();

  public final boolean c()
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
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.dispose.AbstractDisposable
 * JD-Core Version:    0.6.0
 */