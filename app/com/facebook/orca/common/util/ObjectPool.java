package com.facebook.orca.common.util;

import java.lang.reflect.Array;

public class ObjectPool<T>
{
  private final Class<T> a;
  private final int b;
  private final int c;
  private final int d;
  private final ObjectPool.Allocator<T> e;
  private final Clock f;
  private final long g;
  private long h;
  private T[] i;
  private int j;

  public ObjectPool(Class<T> paramClass, int paramInt1, int paramInt2, int paramInt3, long paramLong, ObjectPool.Allocator<T> paramAllocator, Clock paramClock)
  {
    this.a = paramClass;
    this.b = Math.max(paramInt1, 0);
    this.c = Math.max(this.b, paramInt2);
    this.d = Math.max(paramInt3, 1);
    this.g = paramLong;
    this.e = paramAllocator;
    this.e.a(this);
    this.f = paramClock;
    this.i = ((Object[])(Object[])Array.newInstance(this.a, this.b));
  }

  private void a(int paramInt)
  {
    for (int k = paramInt; k < this.j; k++)
      this.e.c(this.i[k]);
    Object[] arrayOfObject = (Object[])(Object[])Array.newInstance(this.a, paramInt);
    System.arraycopy(this.i, 0, arrayOfObject, 0, Math.min(this.i.length, paramInt));
    this.i = arrayOfObject;
    this.j = Math.min(this.j, paramInt);
  }

  public T a()
  {
    monitorenter;
    try
    {
      Object localObject3;
      if (this.j > 0)
      {
        this.j = (-1 + this.j);
        localObject3 = this.i[this.j];
        this.i[this.j] = null;
      }
      while (true)
      {
        this.e.a(localObject3);
        return localObject3;
        Object localObject2 = this.e.a();
        localObject3 = localObject2;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public void a(T paramT)
  {
    monitorenter;
    try
    {
      b();
      this.e.b(paramT);
      if (this.j < this.c)
      {
        if (1 + this.j > this.i.length)
          a(Math.min(this.c, this.i.length + this.d));
        Object[] arrayOfObject = this.i;
        int k = this.j;
        this.j = (k + 1);
        arrayOfObject[k] = paramT;
      }
      while (true)
      {
        return;
        this.e.c(paramT);
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
      if (this.j < 2 * this.d)
        this.h = this.f.a();
      if (this.f.a() - this.h > this.g)
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

  public void c()
  {
    monitorenter;
    try
    {
      int k = Math.max(this.i.length - this.d, this.b);
      if (k != this.i.length)
        a(k);
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
 * Qualified Name:     com.facebook.orca.common.util.ObjectPool
 * JD-Core Version:    0.6.0
 */