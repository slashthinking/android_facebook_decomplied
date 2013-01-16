package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Iterator;

final class CustomConcurrentHashMap$Values extends AbstractCollection<V>
{
  CustomConcurrentHashMap$Values(CustomConcurrentHashMap paramCustomConcurrentHashMap)
  {
  }

  public void clear()
  {
    this.a.clear();
  }

  public boolean contains(Object paramObject)
  {
    return this.a.containsValue(paramObject);
  }

  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }

  public Iterator<V> iterator()
  {
    return new CustomConcurrentHashMap.ValueIterator(this.a);
  }

  public int size()
  {
    return this.a.size();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.Values
 * JD-Core Version:    0.6.2
 */