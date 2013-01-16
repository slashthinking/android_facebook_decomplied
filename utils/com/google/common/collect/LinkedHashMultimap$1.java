package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class LinkedHashMultimap$1
  implements Iterator<Map.Entry<K, V>>
{
  Map.Entry<K, V> a;

  LinkedHashMultimap$1(LinkedHashMultimap paramLinkedHashMultimap, Iterator paramIterator)
  {
  }

  public Map.Entry<K, V> a()
  {
    this.a = ((Map.Entry)this.b.next());
    return this.a;
  }

  public boolean hasNext()
  {
    return this.b.hasNext();
  }

  public void remove()
  {
    this.b.remove();
    this.c.c(this.a.getKey(), this.a.getValue());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.LinkedHashMultimap.1
 * JD-Core Version:    0.6.2
 */