package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

class LinkedHashMultimap$SetDecorator$1
  implements Iterator<V>
{
  V a;

  LinkedHashMultimap$SetDecorator$1(LinkedHashMultimap.SetDecorator paramSetDecorator, Iterator paramIterator)
  {
  }

  public boolean hasNext()
  {
    return this.b.hasNext();
  }

  public V next()
  {
    this.a = this.b.next();
    return this.a;
  }

  public void remove()
  {
    this.b.remove();
    this.c.c.b.remove(this.c.a(this.a));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.LinkedHashMultimap.SetDecorator.1
 * JD-Core Version:    0.6.2
 */