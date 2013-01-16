package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class Lists$ReverseList<T> extends AbstractList<T>
{
  private final List<T> a;

  Lists$ReverseList(List<T> paramList)
  {
    this.a = ((List)Preconditions.checkNotNull(paramList));
  }

  private int a(int paramInt)
  {
    int i = size();
    Preconditions.checkElementIndex(paramInt, i);
    return i - 1 - paramInt;
  }

  private int b(int paramInt)
  {
    int i = size();
    Preconditions.checkPositionIndex(paramInt, i);
    return i - paramInt;
  }

  List<T> a()
  {
    return this.a;
  }

  public void add(int paramInt, T paramT)
  {
    this.a.add(b(paramInt), paramT);
  }

  public void clear()
  {
    this.a.clear();
  }

  public boolean contains(Object paramObject)
  {
    return this.a.contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.a.containsAll(paramCollection);
  }

  public T get(int paramInt)
  {
    return this.a.get(a(paramInt));
  }

  public int indexOf(Object paramObject)
  {
    int i = this.a.lastIndexOf(paramObject);
    if (i >= 0);
    for (int j = a(i); ; j = -1)
      return j;
  }

  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }

  public Iterator<T> iterator()
  {
    return listIterator();
  }

  public int lastIndexOf(Object paramObject)
  {
    int i = this.a.indexOf(paramObject);
    if (i >= 0);
    for (int j = a(i); ; j = -1)
      return j;
  }

  public ListIterator<T> listIterator(int paramInt)
  {
    int i = b(paramInt);
    return new Lists.ReverseList.1(this, this.a.listIterator(i));
  }

  public T remove(int paramInt)
  {
    return this.a.remove(a(paramInt));
  }

  protected void removeRange(int paramInt1, int paramInt2)
  {
    subList(paramInt1, paramInt2).clear();
  }

  public T set(int paramInt, T paramT)
  {
    return this.a.set(a(paramInt), paramT);
  }

  public int size()
  {
    return this.a.size();
  }

  public List<T> subList(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
    return Lists.a(this.a.subList(b(paramInt2), b(paramInt1)));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Lists.ReverseList
 * JD-Core Version:    0.6.2
 */