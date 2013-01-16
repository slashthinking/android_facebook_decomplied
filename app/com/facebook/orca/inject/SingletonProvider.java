package com.facebook.orca.inject;

import javax.inject.Provider;

public class SingletonProvider<T>
  implements Provider<T>
{
  private static ThreadLocal<Boolean> a = new SingletonProvider.1();
  private final Provider<T> b;
  private T c;
  private boolean d;

  public SingletonProvider(Provider<T> paramProvider)
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
      boolean bool;
      if (!this.d)
      {
        bool = ((Boolean)a.get()).booleanValue();
        a.set(Boolean.valueOf(true));
      }
      try
      {
        this.c = this.b.b();
        this.d = true;
        a.set(Boolean.valueOf(bool));
        Object localObject2 = this.c;
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
 * Qualified Name:     com.facebook.orca.inject.SingletonProvider
 * JD-Core Version:    0.6.0
 */