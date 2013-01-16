package com.facebook.orca.inject;

import javax.inject.Provider;

public class InstanceProvider<T>
  implements Provider<T>
{
  private final T a;

  public InstanceProvider(T paramT)
  {
    this.a = paramT;
  }

  public T b()
  {
    return this.a;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.inject.InstanceProvider
 * JD-Core Version:    0.6.0
 */