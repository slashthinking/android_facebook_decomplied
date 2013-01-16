package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E>
  implements Serializable
{
  private static final long serialVersionUID = -2250766705698539974L;
  private transient Map<E, Count> a;
  private transient long b;

  protected AbstractMapBasedMultiset(Map<E, Count> paramMap)
  {
    this.a = ((Map)Preconditions.checkNotNull(paramMap));
    this.b = super.size();
  }

  private int a(Object paramObject, Map<E, Count> paramMap)
  {
    Count localCount = (Count)paramMap.remove(paramObject);
    int i;
    if (localCount == null)
      i = 0;
    while (true)
    {
      return i;
      i = localCount.d(0);
      this.b -= i;
    }
  }

  public int a(Object paramObject)
  {
    int j;
    try
    {
      Count localCount = (Count)this.a.get(paramObject);
      if (localCount == null)
      {
        j = 0;
      }
      else
      {
        int k = localCount.a();
        j = k;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      i = 0;
      break label56;
    }
    catch (NullPointerException localNullPointerException)
    {
      i = 0;
      break label56;
    }
    int i = j;
    label56: return i;
  }

  public int a(E paramE, int paramInt)
  {
    int i = 0;
    if (paramInt == 0)
    {
      i = a(paramE);
      return i;
    }
    if (paramInt > 0);
    Count localCount;
    for (boolean bool1 = true; ; bool1 = false)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(paramInt);
      Preconditions.checkArgument(bool1, "occurrences cannot be negative: %s", arrayOfObject1);
      localCount = (Count)this.a.get(paramE);
      if (localCount != null)
        break label103;
      this.a.put(paramE, new Count(paramInt));
      this.b += paramInt;
      break;
    }
    label103: int j = localCount.a();
    long l = j + paramInt;
    if (l <= 2147483647L);
    for (boolean bool2 = true; ; bool2 = false)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Long.valueOf(l);
      Preconditions.checkArgument(bool2, "too many occurrences: %s", arrayOfObject2);
      localCount.a(paramInt);
      i = j;
      break;
    }
  }

  public Set<Multiset.Entry<E>> a()
  {
    return super.a();
  }

  void a(Map<E, Count> paramMap)
  {
    this.a = paramMap;
  }

  public int b(Object paramObject, int paramInt)
  {
    int i;
    if (paramInt == 0)
      i = a(paramObject);
    boolean bool;
    label20: Count localCount;
    do
    {
      return i;
      if (paramInt <= 0)
        break;
      bool = true;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      Preconditions.checkArgument(bool, "occurrences cannot be negative: %s", arrayOfObject);
      localCount = (Count)this.a.get(paramObject);
      i = 0;
    }
    while (localCount == null);
    int j = localCount.a();
    if (j > paramInt);
    while (true)
    {
      localCount.b(-paramInt);
      this.b -= paramInt;
      i = j;
      break;
      bool = false;
      break label20;
      this.a.remove(paramObject);
      paramInt = j;
    }
  }

  Iterator<Multiset.Entry<E>> b()
  {
    return new AbstractMapBasedMultiset.1(this, this.a.entrySet().iterator());
  }

  int c()
  {
    return this.a.size();
  }

  public void clear()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
      ((Count)localIterator.next()).c(0);
    this.a.clear();
    this.b = 0L;
  }

  Set<E> d()
  {
    return new AbstractMapBasedMultiset.MapBasedElementSet(this, this.a);
  }

  public Iterator<E> iterator()
  {
    return new AbstractMapBasedMultiset.MapBasedMultisetIterator(this);
  }

  public int size()
  {
    return Ints.b(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMapBasedMultiset
 * JD-Core Version:    0.6.2
 */