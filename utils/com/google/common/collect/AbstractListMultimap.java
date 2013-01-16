package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.Map;

abstract class AbstractListMultimap<K, V> extends AbstractMultimap<K, V>
  implements ListMultimap<K, V>
{
  private static final long serialVersionUID = 6588350623831699109L;

  protected AbstractListMultimap(Map<K, Collection<V>> paramMap)
  {
    super(paramMap);
  }

  abstract List<V> a();

  public List<V> a(K paramK)
  {
    return (List)super.b(paramK);
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
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractListMultimap
 * JD-Core Version:    0.6.2
 */