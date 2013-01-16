package com.facebook.orca.common.util;

import java.util.HashMap;

public class ObjectPoolManager
{
  private final HashMap<Class, ObjectPool> a = new HashMap();
  private final Clock b;

  public ObjectPoolManager(Clock paramClock)
  {
    this.b = paramClock;
  }

  public <T> ObjectPoolBuilder<T> a(Class<T> paramClass)
  {
    return new ObjectPoolBuilder(this, paramClass, this.b);
  }

  <T> void a(Class<T> paramClass, ObjectPool<T> paramObjectPool)
  {
    this.a.put(paramClass, paramObjectPool);
  }

  public <T> ObjectPool<T> b(Class<T> paramClass)
  {
    return (ObjectPool)this.a.get(paramClass);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.ObjectPoolManager
 * JD-Core Version:    0.6.0
 */