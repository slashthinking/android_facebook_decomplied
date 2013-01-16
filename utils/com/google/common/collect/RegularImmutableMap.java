package com.google.common.collect;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.util.Map.Entry;

final class RegularImmutableMap<K, V> extends ImmutableMap<K, V>
{
  private static final long serialVersionUID;
  private final transient RegularImmutableMap.LinkedEntry<K, V>[] a;
  private final transient RegularImmutableMap.LinkedEntry<K, V>[] b;
  private final transient int c;
  private final transient int d;
  private transient ImmutableSet<Map.Entry<K, V>> e;
  private transient ImmutableSet<K> f;
  private transient ImmutableCollection<V> g;

  RegularImmutableMap(Map.Entry<?, ?>[] paramArrayOfEntry)
  {
    int i = paramArrayOfEntry.length;
    this.a = b(i);
    int j = a(i);
    this.b = b(j);
    this.c = (j - 1);
    int k = 0;
    int i1;
    for (int m = 0; k < i; m = i1)
    {
      Map.Entry<?, ?> localEntry = paramArrayOfEntry[k];
      Object localObject = localEntry.getKey();
      int n = localObject.hashCode();
      i1 = m + n;
      int i2 = Hashing.a(n) & this.c;
      RegularImmutableMap.LinkedEntry localLinkedEntry1 = this.b[i2];
      RegularImmutableMap.LinkedEntry localLinkedEntry2 = a(localObject, localEntry.getValue(), localLinkedEntry1);
      this.b[i2] = localLinkedEntry2;
      this.a[k] = localLinkedEntry2;
      RegularImmutableMap.LinkedEntry localLinkedEntry3 = localLinkedEntry1;
      if (localLinkedEntry3 != null)
      {
        if (!localObject.equals(localLinkedEntry3.getKey()));
        for (boolean bool = true; ; bool = false)
        {
          Preconditions.checkArgument(bool, "duplicate key: %s", new Object[] { localObject });
          localLinkedEntry3 = localLinkedEntry3.a();
          break;
        }
      }
      k++;
    }
    this.d = m;
  }

  private static int a(int paramInt)
  {
    int i = Integer.highestOneBit(paramInt) << 1;
    if (i > 0);
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      Preconditions.checkArgument(bool, "table too large: %s", arrayOfObject);
      return i;
    }
  }

  private static <K, V> RegularImmutableMap.LinkedEntry<K, V> a(K paramK, V paramV, RegularImmutableMap.LinkedEntry<K, V> paramLinkedEntry)
  {
    if (paramLinkedEntry == null);
    for (Object localObject = new RegularImmutableMap.TerminalEntry(paramK, paramV); ; localObject = new RegularImmutableMap.NonTerminalEntry(paramK, paramV, paramLinkedEntry))
      return (RegularImmutableMap.LinkedEntry)localObject;
  }

  private RegularImmutableMap.LinkedEntry<K, V>[] b(int paramInt)
  {
    return new RegularImmutableMap.LinkedEntry[paramInt];
  }

  public ImmutableSet<Map.Entry<K, V>> a()
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      localObject = new RegularImmutableMap.EntrySet(this);
      this.e = ((ImmutableSet)localObject);
    }
    return localObject;
  }

  public ImmutableSet<K> b()
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      localObject = new RegularImmutableMap.KeySet(this);
      this.f = ((ImmutableSet)localObject);
    }
    return localObject;
  }

  public ImmutableCollection<V> c()
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      localObject = new RegularImmutableMap.Values(this);
      this.g = ((ImmutableCollection)localObject);
    }
    return localObject;
  }

  public boolean containsValue(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null)
      return bool;
    RegularImmutableMap.LinkedEntry[] arrayOfLinkedEntry = this.a;
    int i = arrayOfLinkedEntry.length;
    for (int j = 0; ; j++)
    {
      bool = false;
      if (j >= i)
        break;
      if (arrayOfLinkedEntry[j].getValue().equals(paramObject))
      {
        bool = true;
        break;
      }
    }
  }

  boolean d()
  {
    return false;
  }

  public V get(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null)
      return localObject;
    int i = Hashing.a(paramObject.hashCode()) & this.c;
    for (RegularImmutableMap.LinkedEntry localLinkedEntry = this.b[i]; ; localLinkedEntry = localLinkedEntry.a())
    {
      localObject = null;
      if (localLinkedEntry == null)
        break;
      if (paramObject.equals(localLinkedEntry.getKey()))
      {
        localObject = localLinkedEntry.getValue();
        break;
      }
    }
  }

  public boolean isEmpty()
  {
    return false;
  }

  public int size()
  {
    return this.a.length;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = Collections2.a(size()).append('{');
    Collections2.a.appendTo(localStringBuilder, this.a);
    return '}';
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableMap
 * JD-Core Version:    0.6.2
 */