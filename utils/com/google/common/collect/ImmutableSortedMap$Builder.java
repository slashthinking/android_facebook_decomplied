package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ImmutableSortedMap$Builder<K, V> extends ImmutableMap.Builder<K, V>
{
  private final Comparator<? super K> b;

  public ImmutableSortedMap$Builder(Comparator<? super K> paramComparator)
  {
    this.b = ((Comparator)Preconditions.checkNotNull(paramComparator));
  }

  public Builder<K, V> a(K paramK, V paramV)
  {
    this.a.add(ImmutableMap.b(paramK, paramV));
    return this;
  }

  public Builder<K, V> a(Map<? extends K, ? extends V> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a(localEntry.getKey(), localEntry.getValue());
    }
    return this;
  }

  public ImmutableSortedMap<K, V> a()
  {
    ImmutableSortedMap.a(this.a, this.b);
    ImmutableSortedMap.b(this.a, this.b);
    return new ImmutableSortedMap(ImmutableList.a(this.a), this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedMap.Builder
 * JD-Core Version:    0.6.2
 */