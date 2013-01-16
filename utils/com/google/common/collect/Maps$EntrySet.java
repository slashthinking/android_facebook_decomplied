package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class Maps$EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>>
{
  abstract Map<K, V> a();

  public void clear()
  {
    a().clear();
  }

  public boolean contains(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    if (bool1)
    {
      Map.Entry localEntry = (Map.Entry)paramObject;
      Object localObject1 = localEntry.getKey();
      Object localObject2 = a().get(localObject1);
      boolean bool3 = Objects.equal(localObject2, localEntry.getValue());
      bool2 = false;
      if (bool3)
        if (localObject2 == null)
        {
          boolean bool4 = a().containsKey(localObject1);
          bool2 = false;
          if (!bool4);
        }
        else
        {
          bool2 = true;
        }
    }
    return bool2;
  }

  public boolean isEmpty()
  {
    return a().isEmpty();
  }

  public boolean remove(Object paramObject)
  {
    Map.Entry localEntry;
    if (contains(paramObject))
      localEntry = (Map.Entry)paramObject;
    for (boolean bool = a().keySet().remove(localEntry.getKey()); ; bool = false)
      return bool;
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool1;
    Iterator localIterator;
    try
    {
      boolean bool2 = super.removeAll((Collection)Preconditions.checkNotNull(paramCollection));
      bool1 = bool2;
      return bool1;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      bool1 = true;
      localIterator = paramCollection.iterator();
    }
    while (localIterator.hasNext())
      bool1 |= remove(localIterator.next());
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    try
    {
      boolean bool2 = super.retainAll((Collection)Preconditions.checkNotNull(paramCollection));
      bool1 = bool2;
      return bool1;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      while (true)
      {
        HashSet localHashSet = Sets.a(paramCollection.size());
        Iterator localIterator = paramCollection.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          if (contains(localObject))
            localHashSet.add(((Map.Entry)localObject).getKey());
        }
        boolean bool1 = a().keySet().retainAll(localHashSet);
      }
    }
  }

  public int size()
  {
    return a().size();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Maps.EntrySet
 * JD-Core Version:    0.6.2
 */