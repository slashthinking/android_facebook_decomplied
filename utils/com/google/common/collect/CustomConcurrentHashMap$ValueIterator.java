package com.google.common.collect;

import java.util.Iterator;

final class CustomConcurrentHashMap$ValueIterator extends CustomConcurrentHashMap<K, V>.HashIterator
  implements Iterator<V>
{
  CustomConcurrentHashMap$ValueIterator(CustomConcurrentHashMap paramCustomConcurrentHashMap)
  {
    super(paramCustomConcurrentHashMap);
  }

  public V next()
  {
    return e().getValue();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.ValueIterator
 * JD-Core Version:    0.6.2
 */