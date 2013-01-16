package com.facebook.common.collect;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapWithSecondaryOrdering<K, V> extends AbstractMap<K, V>
{
  private static Class<?> a = MapWithSecondaryOrdering.class;
  private final Comparator<V> b;
  private final Map<K, V> c;
  private final List<V> d;
  private final Map<K, V> e;
  private final List<V> f;

  public MapWithSecondaryOrdering(Comparator<V> paramComparator)
  {
    this.b = paramComparator;
    this.c = Maps.a();
    this.d = Lists.a();
    this.e = Collections.unmodifiableMap(this.c);
    this.f = Collections.unmodifiableList(this.d);
  }

  public List<V> a()
  {
    return this.f;
  }

  public void clear()
  {
    this.c.clear();
    this.d.clear();
  }

  public boolean containsKey(Object paramObject)
  {
    return this.c.containsKey(paramObject);
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    return this.e.entrySet();
  }

  public V get(Object paramObject)
  {
    return this.c.get(paramObject);
  }

  public V put(K paramK, V paramV)
  {
    Object localObject = remove(paramK);
    int i = Collections.binarySearch(this.d, paramV, this.b);
    if (i < 0)
      i = -(i + 1);
    this.d.add(i, paramV);
    this.c.put(paramK, paramV);
    return localObject;
  }

  public V remove(Object paramObject)
  {
    Object localObject = this.c.remove(paramObject);
    if (localObject != null)
    {
      int i = Collections.binarySearch(this.d, localObject, this.b);
      if (i < 0)
        throw new RuntimeException("The collection is in an invalid state");
      while (true)
      {
        i++;
        if (i >= this.d.size())
          break;
        if (localObject != this.d.get(i))
          continue;
        this.d.remove(i);
      }
    }
    return localObject;
  }

  public int size()
  {
    return this.c.size();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.collect.MapWithSecondaryOrdering
 * JD-Core Version:    0.6.0
 */