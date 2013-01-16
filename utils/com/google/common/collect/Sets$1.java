package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

final class Sets$1 extends Sets.SetView<E>
{
  public boolean contains(Object paramObject)
  {
    if ((this.a.contains(paramObject)) || (this.c.contains(paramObject)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isEmpty()
  {
    if ((this.a.isEmpty()) && (this.c.isEmpty()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public Iterator<E> iterator()
  {
    return Iterators.a(Iterators.b(this.a.iterator(), this.b.iterator()));
  }

  public int size()
  {
    return this.a.size() + this.b.size();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Sets.1
 * JD-Core Version:    0.6.2
 */