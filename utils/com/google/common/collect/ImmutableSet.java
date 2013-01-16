package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public abstract class ImmutableSet<E> extends ImmutableCollection<E>
  implements Set<E>
{
  static int a(int paramInt)
  {
    int i;
    if (paramInt < 536870912)
    {
      i = Integer.highestOneBit(paramInt) << 2;
      return i;
    }
    if (paramInt < 1073741824);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "collection too large");
      i = 1073741824;
      break;
    }
  }

  public static <E> ImmutableSet<E> a(E paramE1, E paramE2)
  {
    return b(new Object[] { paramE1, paramE2 });
  }

  public static <E> ImmutableSet<E> a(E paramE1, E paramE2, E paramE3)
  {
    return b(new Object[] { paramE1, paramE2, paramE3 });
  }

  public static <E> ImmutableSet<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }

  public static <E> ImmutableSet<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E[] paramArrayOfE)
  {
    Object[] arrayOfObject = new Object[6 + paramArrayOfE.length];
    arrayOfObject[0] = paramE1;
    arrayOfObject[1] = paramE2;
    arrayOfObject[2] = paramE3;
    arrayOfObject[3] = paramE4;
    arrayOfObject[4] = paramE5;
    arrayOfObject[5] = paramE6;
    for (int i = 6; i < arrayOfObject.length; i++)
      arrayOfObject[i] = paramArrayOfE[(i - 6)];
    return b(arrayOfObject);
  }

  public static <E> ImmutableSet<E> a(Collection<? extends E> paramCollection)
  {
    ImmutableSet localImmutableSet;
    if (((paramCollection instanceof ImmutableSet)) && (!(paramCollection instanceof ImmutableSortedSet)))
    {
      localImmutableSet = (ImmutableSet)paramCollection;
      if (localImmutableSet.l_());
    }
    while (true)
    {
      return localImmutableSet;
      localImmutableSet = b(paramCollection);
    }
  }

  public static <E> ImmutableSet<E> a(E[] paramArrayOfE)
  {
    ImmutableSet localImmutableSet;
    switch (paramArrayOfE.length)
    {
    default:
      localImmutableSet = b((Object[])paramArrayOfE.clone());
    case 0:
    case 1:
    }
    while (true)
    {
      return localImmutableSet;
      localImmutableSet = d();
      continue;
      localImmutableSet = b(paramArrayOfE[0]);
    }
  }

  public static <E> ImmutableSet<E> b(E paramE)
  {
    return new SingletonImmutableSet(paramE);
  }

  private static <E> ImmutableSet<E> b(Collection<? extends E> paramCollection)
  {
    Object[] arrayOfObject = paramCollection.toArray();
    ImmutableSet localImmutableSet;
    switch (arrayOfObject.length)
    {
    default:
      localImmutableSet = b(arrayOfObject);
    case 0:
    case 1:
    }
    while (true)
    {
      return localImmutableSet;
      localImmutableSet = d();
      continue;
      localImmutableSet = b(arrayOfObject[0]);
    }
  }

  private static <E> ImmutableSet<E> b(Object[] paramArrayOfObject)
  {
    int i = a(paramArrayOfObject.length);
    Object[] arrayOfObject = new Object[i];
    int j = i - 1;
    ArrayList localArrayList = null;
    int k = 0;
    int m = 0;
    if (k < paramArrayOfObject.length)
    {
      Object localObject2 = paramArrayOfObject[k];
      int n = localObject2.hashCode();
      label152: for (int i1 = Hashing.a(n); ; i1++)
      {
        int i2 = i1 & j;
        Object localObject3 = arrayOfObject[i2];
        if (localObject3 == null)
        {
          if (localArrayList != null)
            localArrayList.add(localObject2);
          arrayOfObject[i2] = localObject2;
          m += n;
        }
        while (true)
        {
          k++;
          break;
          if (!localObject3.equals(localObject2))
            break label152;
          if (localArrayList == null)
          {
            localArrayList = new ArrayList(paramArrayOfObject.length);
            for (int i3 = 0; i3 < k; i3++)
              localArrayList.add(paramArrayOfObject[i3]);
          }
        }
      }
    }
    Object localObject1;
    if (localArrayList == null)
    {
      if (paramArrayOfObject.length != 1)
        break label195;
      localObject1 = new SingletonImmutableSet(paramArrayOfObject[0], m);
    }
    while (true)
    {
      return localObject1;
      paramArrayOfObject = localArrayList.toArray();
      break;
      label195: if (i > 2 * a(paramArrayOfObject.length))
        localObject1 = b(paramArrayOfObject);
      else
        localObject1 = new RegularImmutableSet(paramArrayOfObject, m, arrayOfObject, j);
    }
  }

  public static <E> ImmutableSet<E> d()
  {
    return EmptyImmutableSet.a;
  }

  public static <E> ImmutableSet.Builder<E> e()
  {
    return new ImmutableSet.Builder();
  }

  public abstract UnmodifiableIterator<E> b();

  boolean c()
  {
    return false;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this)
      bool = true;
    while (true)
    {
      return bool;
      if (((paramObject instanceof ImmutableSet)) && (c()) && (((ImmutableSet)paramObject).c()) && (hashCode() != paramObject.hashCode()))
        bool = false;
      else
        bool = Sets.a(this, paramObject);
    }
  }

  public int hashCode()
  {
    return Sets.a(this);
  }

  Object writeReplace()
  {
    return new ImmutableSet.SerializedForm(toArray());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSet
 * JD-Core Version:    0.6.2
 */