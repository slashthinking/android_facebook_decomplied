package com.facebook.orca.common.util;

import com.facebook.common.util.Log;

public class ObjectPool$BasicAllocator<T>
  implements ObjectPool.Allocator<T>
{
  Class<T> a;

  public ObjectPool$BasicAllocator(Class<T> paramClass)
  {
    this.a = paramClass;
  }

  public T a()
  {
    try
    {
      Object localObject2 = this.a.newInstance();
      localObject1 = localObject2;
      return localObject1;
    }
    catch (InstantiationException localInstantiationException)
    {
      while (true)
      {
        Log.a(localInstantiationException.toString());
        Object localObject1 = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        Log.a(localIllegalAccessException.toString());
    }
  }

  public void a(ObjectPool<T> paramObjectPool)
  {
  }

  public void a(T paramT)
  {
  }

  public void b(T paramT)
  {
  }

  public void c(T paramT)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.ObjectPool.BasicAllocator
 * JD-Core Version:    0.6.0
 */