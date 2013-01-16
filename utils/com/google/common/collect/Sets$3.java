package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Set;

final class Sets$3 extends Sets.SetView<E>
{
  Sets$3(Set paramSet1, Predicate paramPredicate, Set paramSet2)
  {
    super(null);
  }

  public boolean contains(Object paramObject)
  {
    if ((this.a.contains(paramObject)) && (!this.c.contains(paramObject)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isEmpty()
  {
    return this.c.containsAll(this.a);
  }

  public Iterator<E> iterator()
  {
    return Iterators.a(this.a.iterator(), this.b);
  }

  public int size()
  {
    return Iterators.b(iterator());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Sets.3
 * JD-Core Version:    0.6.2
 */