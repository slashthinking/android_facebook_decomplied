package com.google.common.collect;

final class RegularImmutableSet<E> extends ImmutableSet.ArrayImmutableSet<E>
{
  final transient Object[] b;
  private final transient int d;
  private final transient int e;

  RegularImmutableSet(Object[] paramArrayOfObject1, int paramInt1, Object[] paramArrayOfObject2, int paramInt2)
  {
    super(paramArrayOfObject1);
    this.b = paramArrayOfObject2;
    this.d = paramInt2;
    this.e = paramInt1;
  }

  boolean c()
  {
    return true;
  }

  public boolean contains(Object paramObject)
  {
    boolean bool;
    if (paramObject == null)
    {
      bool = false;
      return bool;
    }
    for (int i = Hashing.a(paramObject.hashCode()); ; i++)
    {
      Object localObject = this.b[(i & this.d)];
      if (localObject == null)
      {
        bool = false;
        break;
      }
      if (localObject.equals(paramObject))
      {
        bool = true;
        break;
      }
    }
  }

  public int hashCode()
  {
    return this.e;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableSet
 * JD-Core Version:    0.6.2
 */