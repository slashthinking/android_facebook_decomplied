package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class Maps$KeySet<K, V> extends AbstractSet<K>
{
  abstract Map<K, V> a();

  public void clear()
  {
    a().clear();
  }

  public boolean contains(Object paramObject)
  {
    return a().containsKey(paramObject);
  }

  public boolean isEmpty()
  {
    return a().isEmpty();
  }

  public Iterator<K> iterator()
  {
    return Iterators.a(a().entrySet().iterator(), new Maps.KeySet.1(this));
  }

  public boolean remove(Object paramObject)
  {
    if (contains(paramObject))
      a().remove(paramObject);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    return super.removeAll((Collection)Preconditions.checkNotNull(paramCollection));
  }

  public int size()
  {
    return a().size();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Maps.KeySet
 * JD-Core Version:    0.6.2
 */