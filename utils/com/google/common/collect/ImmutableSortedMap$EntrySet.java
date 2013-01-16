package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableSortedMap$EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>>
{
  final transient ImmutableSortedMap<K, V> a;

  ImmutableSortedMap$EntrySet(ImmutableSortedMap<K, V> paramImmutableSortedMap)
  {
    this.a = paramImmutableSortedMap;
  }

  public UnmodifiableIterator<Map.Entry<K, V>> b()
  {
    return this.a.a.b();
  }

  public boolean contains(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    if (bool1)
    {
      Map.Entry localEntry = (Map.Entry)paramObject;
      Object localObject = this.a.get(localEntry.getKey());
      bool2 = false;
      if (localObject != null)
      {
        boolean bool3 = localObject.equals(localEntry.getValue());
        bool2 = false;
        if (bool3)
          bool2 = true;
      }
    }
    return bool2;
  }

  boolean l_()
  {
    return this.a.d();
  }

  public int size()
  {
    return this.a.size();
  }

  Object writeReplace()
  {
    return new ImmutableSortedMap.EntrySetSerializedForm(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.EntrySet
 * JD-Core Version:    0.6.2
 */