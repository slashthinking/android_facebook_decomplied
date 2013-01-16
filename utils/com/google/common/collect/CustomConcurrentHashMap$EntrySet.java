package com.google.common.collect;

import com.google.common.base.Equivalence;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class CustomConcurrentHashMap$EntrySet extends AbstractSet<Map.Entry<K, V>>
{
  CustomConcurrentHashMap$EntrySet(CustomConcurrentHashMap paramCustomConcurrentHashMap)
  {
  }

  public void clear()
  {
    this.a.clear();
  }

  public boolean contains(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    if (!bool1);
    while (true)
    {
      return bool2;
      Map.Entry localEntry = (Map.Entry)paramObject;
      Object localObject1 = localEntry.getKey();
      bool2 = false;
      if (localObject1 != null)
      {
        Object localObject2 = this.a.get(localObject1);
        bool2 = false;
        if (localObject2 != null)
        {
          boolean bool3 = this.a.valueEquivalence.equivalent(localEntry.getValue(), localObject2);
          bool2 = false;
          if (bool3)
            bool2 = true;
        }
      }
    }
  }

  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }

  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new CustomConcurrentHashMap.EntryIterator(this.a);
  }

  public boolean remove(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    if (!bool1);
    while (true)
    {
      return bool2;
      Map.Entry localEntry = (Map.Entry)paramObject;
      Object localObject = localEntry.getKey();
      bool2 = false;
      if (localObject != null)
      {
        boolean bool3 = this.a.remove(localObject, localEntry.getValue());
        bool2 = false;
        if (bool3)
          bool2 = true;
      }
    }
  }

  public int size()
  {
    return this.a.size();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.EntrySet
 * JD-Core Version:    0.6.2
 */