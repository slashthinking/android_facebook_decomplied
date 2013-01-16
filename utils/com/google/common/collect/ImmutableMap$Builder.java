package com.google.common.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ImmutableMap$Builder<K, V>
{
  final ArrayList<Map.Entry<K, V>> a = Lists.a();

  private static <K, V> ImmutableMap<K, V> a(List<Map.Entry<K, V>> paramList)
  {
    Object localObject;
    switch (paramList.size())
    {
    default:
      localObject = new RegularImmutableMap((Map.Entry[])paramList.toArray(new Map.Entry[paramList.size()]));
    case 0:
    case 1:
    }
    while (true)
    {
      return localObject;
      localObject = ImmutableMap.j();
      continue;
      localObject = new SingletonImmutableMap((Map.Entry)Iterables.b(paramList));
    }
  }

  public Builder<K, V> b(K paramK, V paramV)
  {
    this.a.add(ImmutableMap.b(paramK, paramV));
    return this;
  }

  public Builder<K, V> b(Map<? extends K, ? extends V> paramMap)
  {
    this.a.ensureCapacity(this.a.size() + paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      b(localEntry.getKey(), localEntry.getValue());
    }
    return this;
  }

  public ImmutableMap<K, V> b()
  {
    return a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMap.Builder
 * JD-Core Version:    0.6.2
 */