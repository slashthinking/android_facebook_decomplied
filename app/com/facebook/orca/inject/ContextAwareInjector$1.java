package com.facebook.orca.inject;

import javax.inject.Provider;

class ContextAwareInjector$1
  implements Provider<T>
{
  public T b()
  {
    ContextAwareInjector.b(this.b).a(ContextAwareInjector.a(this.b));
    try
    {
      Object localObject2 = this.a.b();
      return localObject2;
    }
    finally
    {
      ContextAwareInjector.b(this.b).a();
    }
    throw localObject1;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.ContextAwareInjector.1
 * JD-Core Version:    0.6.0
 */