package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Iterator;

final class CustomConcurrentHashMap$KeySet extends AbstractSet<K>
{
  CustomConcurrentHashMap$KeySet(CustomConcurrentHashMap paramCustomConcurrentHashMap)
  {
  }

  public void clear()
  {
    this.a.clear();
  }

  public boolean contains(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }

  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }

  public Iterator<K> iterator()
  {
    return new CustomConcurrentHashMap.KeyIterator(this.a);
  }

  public boolean remove(Object paramObject)
  {
    if (this.a.remove(paramObject) != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int size()
  {
    return this.a.size();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.KeySet
 * JD-Core Version:    0.6.2
 */