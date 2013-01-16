package com.google.common.collect;

import java.util.Iterator;

final class CustomConcurrentHashMap$KeyIterator extends CustomConcurrentHashMap<K, V>.HashIterator
  implements Iterator<K>
{
  CustomConcurrentHashMap$KeyIterator(CustomConcurrentHashMap paramCustomConcurrentHashMap)
  {
    super(paramCustomConcurrentHashMap);
  }

  public K next()
  {
    return e().getKey();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.KeyIterator
 * JD-Core Version:    0.6.2
 */