package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Sets$SetFromMap<E> extends AbstractSet<E>
  implements Serializable, Set<E>
{
  private static final long serialVersionUID;
  private transient Set<E> a;
  private final Map<E, Boolean> m;

  Sets$SetFromMap(Map<E, Boolean> paramMap)
  {
    Preconditions.checkArgument(paramMap.isEmpty(), "Map is non-empty");
    this.m = paramMap;
    this.a = paramMap.keySet();
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    this.a = this.m.keySet();
  }

  public boolean add(E paramE)
  {
    if (this.m.put(paramE, Boolean.TRUE) == null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void clear()
  {
    this.m.clear();
  }

  public boolean contains(Object paramObject)
  {
    return this.m.containsKey(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.a.containsAll(paramCollection);
  }

  public boolean equals(Object paramObject)
  {
    if ((this == paramObject) || (this.a.equals(paramObject)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public boolean isEmpty()
  {
    return this.m.isEmpty();
  }

  public Iterator<E> iterator()
  {
    return this.a.iterator();
  }

  public boolean remove(Object paramObject)
  {
    if (this.m.remove(paramObject) != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.a.removeAll(paramCollection);
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.a.retainAll(paramCollection);
  }

  public int size()
  {
    return this.m.size();
  }

  public Object[] toArray()
  {
    return this.a.toArray();
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.a.toArray(paramArrayOfT);
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Sets.SetFromMap
 * JD-Core Version:    0.6.2
 */