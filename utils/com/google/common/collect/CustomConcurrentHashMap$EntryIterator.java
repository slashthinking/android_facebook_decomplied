package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

final class CustomConcurrentHashMap$EntryIterator extends CustomConcurrentHashMap<K, V>.HashIterator
  implements Iterator<Map.Entry<K, V>>
{
  CustomConcurrentHashMap$EntryIterator(CustomConcurrentHashMap paramCustomConcurrentHashMap)
  {
    super(paramCustomConcurrentHashMap);
  }

  public Map.Entry<K, V> a()
  {
    return e();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.EntryIterator
 * JD-Core Version:    0.6.2
 */