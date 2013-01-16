package com.facebook.orca.common.util;

public class ObjectPoolBuilder<T>
{
  private Class<T> a;
  private int b = 16;
  private int c = 1024;
  private int d = 16;
  private long e = 60000L;
  private ObjectPool.Allocator<T> f;
  private Clock g;
  private final ObjectPoolManager h;

  ObjectPoolBuilder(ObjectPoolManager paramObjectPoolManager, Class<T> paramClass, Clock paramClock)
  {
    this.h = paramObjectPoolManager;
    this.a = paramClass;
    this.g = paramClock;
  }

  public ObjectPoolBuilder(Class<T> paramClass, Clock paramClock)
  {
    this(null, paramClass, paramClock);
  }

  public ObjectPool<T> a()
  {
    if (this.g == null)
      throw new IllegalArgumentException("Must add a clock to the object pool builder");
    Object localObject = this.f;
    if (localObject == null)
      localObject = new ObjectPool.BasicAllocator(this.a);
    ObjectPool localObjectPool = new ObjectPool(this.a, this.b, this.c, this.d, this.e, (ObjectPool.Allocator)localObject, this.g);
    if (this.h != null)
      this.h.a(this.a, localObjectPool);
    return (ObjectPool<T>)localObjectPool;
  }

  public ObjectPoolBuilder<T> a(ObjectPool.Allocator<T> paramAllocator)
  {
    this.f = paramAllocator;
    return this;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.ObjectPoolBuilder
 * JD-Core Version:    0.6.0
 */