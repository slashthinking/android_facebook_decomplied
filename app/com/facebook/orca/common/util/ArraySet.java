package com.facebook.orca.common.util;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ArraySet<T>
  implements Set<T>
{
  private ArrayList<T> a = new ArrayList();
  private HashMap<T, Integer> b = new HashMap();

  public T a(int paramInt)
  {
    return this.a.get(paramInt);
  }

  public boolean add(T paramT)
  {
    if ((Integer)this.b.get(paramT) != null);
    for (int i = 0; ; i = 1)
    {
      return i;
      this.a.add(paramT);
      this.b.put(paramT, Integer.valueOf(-1 + this.a.size()));
    }
  }

  public boolean addAll(Collection<? extends T> paramCollection)
  {
    boolean bool = false;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      bool |= add(localIterator.next());
    return bool;
  }

  public void clear()
  {
    this.a.clear();
    this.b.clear();
  }

  public boolean contains(Object paramObject)
  {
    if (this.b.get(paramObject) != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (contains(localIterator.next()));
    for (int i = 0; ; i = 1)
      return i;
  }

  public boolean isEmpty()
  {
    if (this.a.size() == 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public Iterator<T> iterator()
  {
    return new ArraySet.1(this);
  }

  public boolean remove(Object paramObject)
  {
    Integer localInteger = (Integer)this.b.get(paramObject);
    int i = 0;
    if (localInteger == null);
    while (true)
    {
      return i;
      Object localObject1 = this.a.get(localInteger.intValue());
      boolean bool1;
      if ((localObject1 != null) || (paramObject != null))
      {
        bool1 = false;
        if (localObject1 != null)
        {
          boolean bool2 = localObject1.equals(paramObject);
          bool1 = false;
          if (!bool2);
        }
      }
      else
      {
        bool1 = true;
      }
      Preconditions.checkState(bool1);
      int j = -1 + this.a.size();
      if (localInteger.intValue() < j)
      {
        Object localObject2 = this.a.get(j);
        this.a.set(localInteger.intValue(), localObject2);
        this.b.put(localObject2, localInteger);
      }
      this.b.remove(paramObject);
      this.a.remove(j);
      i = 1;
    }
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      bool |= remove(localIterator.next());
    return bool;
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException("Operation not supported by this set");
  }

  public int size()
  {
    return this.a.size();
  }

  public Object[] toArray()
  {
    return this.a.toArray();
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.a.toArray(paramArrayOfT);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.util.ArraySet
 * JD-Core Version:    0.6.0
 */