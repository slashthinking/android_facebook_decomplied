package com.google.common.collect;

import java.io.Serializable;

class ImmutableMultiset$EntrySet$EntrySetSerializedForm<E>
  implements Serializable
{
  final ImmutableMultiset<E> multiset;

  ImmutableMultiset$EntrySet$EntrySetSerializedForm(ImmutableMultiset<E> paramImmutableMultiset)
  {
    this.multiset = paramImmutableMultiset;
  }

  Object readResolve()
  {
    return this.multiset.a();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultiset.EntrySet.EntrySetSerializedForm
 * JD-Core Version:    0.6.2
 */