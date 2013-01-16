package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public abstract class ImmutableList<E> extends ImmutableCollection<E>
  implements List<E>, RandomAccess
{
  public static <E> ImmutableList<E> a(Iterable<? extends E> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    if ((paramIterable instanceof Collection));
    for (ImmutableList localImmutableList = a(Collections2.a(paramIterable)); ; localImmutableList = a(paramIterable.iterator()))
      return localImmutableList;
  }

  public static <E> ImmutableList<E> a(E paramE)
  {
    return new SingletonImmutableList(paramE);
  }

  public static <E> ImmutableList<E> a(E paramE1, E paramE2)
  {
    return b(new Object[] { paramE1, paramE2 });
  }

  public static <E> ImmutableList<E> a(E paramE1, E paramE2, E paramE3)
  {
    return b(new Object[] { paramE1, paramE2, paramE3 });
  }

  public static <E> ImmutableList<E> a(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return b(new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }

  public static <E> ImmutableList<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }

  public static <E> ImmutableList<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8)
  {
    return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8 });
  }

  public static <E> ImmutableList<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9)
  {
    return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9 });
  }

  public static <E> ImmutableList<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10)
  {
    return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9, paramE10 });
  }

  public static <E> ImmutableList<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10, E paramE11, E paramE12, E[] paramArrayOfE)
  {
    Object[] arrayOfObject = new Object[12 + paramArrayOfE.length];
    arrayOfObject[0] = paramE1;
    arrayOfObject[1] = paramE2;
    arrayOfObject[2] = paramE3;
    arrayOfObject[3] = paramE4;
    arrayOfObject[4] = paramE5;
    arrayOfObject[5] = paramE6;
    arrayOfObject[6] = paramE7;
    arrayOfObject[7] = paramE8;
    arrayOfObject[8] = paramE9;
    arrayOfObject[9] = paramE10;
    arrayOfObject[10] = paramE11;
    arrayOfObject[11] = paramE12;
    System.arraycopy(paramArrayOfE, 0, arrayOfObject, 12, paramArrayOfE.length);
    return b(arrayOfObject);
  }

  public static <E> ImmutableList<E> a(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof ImmutableCollection))
    {
      localImmutableList = ((ImmutableCollection)paramCollection).h();
      if (!localImmutableList.l_());
    }
    for (ImmutableList localImmutableList = b(localImmutableList); ; localImmutableList = b(paramCollection))
      return localImmutableList;
  }

  public static <E> ImmutableList<E> a(Iterator<? extends E> paramIterator)
  {
    return b(Lists.a(paramIterator));
  }

  public static <E> ImmutableList<E> a(E[] paramArrayOfE)
  {
    Object localObject;
    switch (paramArrayOfE.length)
    {
    default:
      localObject = b((Object[])paramArrayOfE.clone());
    case 0:
    case 1:
    }
    while (true)
    {
      return localObject;
      localObject = d();
      continue;
      localObject = new SingletonImmutableList(paramArrayOfE[0]);
    }
  }

  private static Object a(Object paramObject, int paramInt)
  {
    if (paramObject == null)
      throw new NullPointerException("at index " + paramInt);
    return paramObject;
  }

  private static <E> ImmutableList<E> b(Collection<? extends E> paramCollection)
  {
    Object[] arrayOfObject = paramCollection.toArray();
    Object localObject;
    switch (arrayOfObject.length)
    {
    default:
      localObject = b(arrayOfObject);
    case 0:
    case 1:
    }
    while (true)
    {
      return localObject;
      localObject = d();
      continue;
      localObject = new SingletonImmutableList(arrayOfObject[0]);
    }
  }

  private static <E> ImmutableList<E> b(Object[] paramArrayOfObject)
  {
    for (int i = 0; i < paramArrayOfObject.length; i++)
      a(paramArrayOfObject[i], i);
    return new RegularImmutableList(paramArrayOfObject);
  }

  public static <E> ImmutableList<E> d()
  {
    return EmptyImmutableList.a;
  }

  public static <E> ImmutableList.Builder<E> e()
  {
    return new ImmutableList.Builder();
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("Use SerializedForm");
  }

  public abstract ImmutableList<E> a(int paramInt1, int paramInt2);

  public abstract UnmodifiableListIterator<E> a(int paramInt);

  public final void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public UnmodifiableIterator<E> b()
  {
    return c();
  }

  public UnmodifiableListIterator<E> c()
  {
    return a(0);
  }

  public boolean equals(Object paramObject)
  {
    return Lists.a(this, paramObject);
  }

  public ImmutableList<E> h()
  {
    return this;
  }

  public int hashCode()
  {
    return Lists.b(this);
  }

  public abstract int indexOf(Object paramObject);

  public final E remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public final E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }

  Object writeReplace()
  {
    return new ImmutableList.SerializedForm(toArray());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableList
 * JD-Core Version:    0.6.2
 */