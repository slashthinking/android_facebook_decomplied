package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class AbstractSetMultimap<K, V> extends AbstractMultimap<K, V>
  implements SetMultimap<K, V>
{
  private static final long serialVersionUID = 7431625294878419160L;

  protected AbstractSetMultimap(Map<K, Collection<V>> paramMap)
  {
    super(paramMap);
  }

  abstract Set<V> a();

  public Set<V> a(K paramK)
  {
    return (Set)super.b(paramK);
  }

  public boolean a(K paramK, V paramV)
  {
    return super.a(paramK, paramV);
  }

  public Map<K, Collection<V>> b()
  {
    return super.b();
  }

  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }

  public Set<Map.Entry<K, V>> l()
  {
    return (Set)super.i();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractSetMultimap
 * JD-Core Version:    0.6.2
 */