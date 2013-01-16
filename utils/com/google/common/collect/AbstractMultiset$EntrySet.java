package com.google.common.collect;

import java.util.Iterator;

class AbstractMultiset$EntrySet extends Multisets.EntrySet<E>
{
  AbstractMultiset$EntrySet(AbstractMultiset paramAbstractMultiset)
  {
  }

  Multiset<E> a()
  {
    return this.a;
  }

  public Iterator<Multiset.Entry<E>> iterator()
  {
    return this.a.b();
  }

  public int size()
  {
    return this.a.c();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractMultiset.EntrySet
 * JD-Core Version:    0.6.2
 */