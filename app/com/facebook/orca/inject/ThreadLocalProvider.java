package com.facebook.orca.inject;

import javax.inject.Provider;

public class ThreadLocalProvider<T>
  implements Provider<T>
{
  private static ThreadLocal<Boolean> a = new ThreadLocalProvider.1();
  private final Provider<T> b;
  private ThreadLocal<ThreadLocalProvider<T>.Holder> c = new ThreadLocalProvider.2(this);

  public ThreadLocalProvider(Provider<T> paramProvider)
  {
    this.b = paramProvider;
  }

  public static boolean a()
  {
    return ((Boolean)a.get()).booleanValue();
  }

  public T b()
  {
    monitorenter;
    try
    {
      ThreadLocalProvider.Holder localHolder = (ThreadLocalProvider.Holder)this.c.get();
      boolean bool;
      if (!ThreadLocalProvider.Holder.a(localHolder))
      {
        bool = ((Boolean)a.get()).booleanValue();
        a.set(Boolean.valueOf(true));
      }
      try
      {
        ThreadLocalProvider.Holder.a(localHolder, this.b.b());
        ThreadLocalProvider.Holder.a(localHolder, true);
        a.set(Boolean.valueOf(bool));
        Object localObject2 = ThreadLocalProvider.Holder.b(localHolder);
        monitorexit;
        return localObject2;
      }
      finally
      {
        localObject3 = finally;
        a.set(Boolean.valueOf(bool));
        throw localObject3;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ThreadLocalProvider
 * JD-Core Version:    0.6.0
 */