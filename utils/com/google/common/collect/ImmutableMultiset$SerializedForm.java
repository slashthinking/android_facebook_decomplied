package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

class ImmutableMultiset$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID;
  final int[] counts;
  final Object[] elements;

  ImmutableMultiset$SerializedForm(Multiset<?> paramMultiset)
  {
    int i = paramMultiset.a().size();
    this.elements = new Object[i];
    this.counts = new int[i];
    Iterator localIterator = paramMultiset.a().iterator();
    for (int j = 0; localIterator.hasNext(); j++)
    {
      Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
      this.elements[j] = localEntry.a();
      this.counts[j] = localEntry.b();
    }
  }

  Object readResolve()
  {
    LinkedHashMultiset localLinkedHashMultiset = LinkedHashMultiset.a(this.elements.length);
    for (int i = 0; i < this.elements.length; i++)
      localLinkedHashMultiset.a(this.elements[i], this.counts[i]);
    return ImmutableMultiset.a(localLinkedHashMultiset);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultiset.SerializedForm
 * JD-Core Version:    0.6.2
 */