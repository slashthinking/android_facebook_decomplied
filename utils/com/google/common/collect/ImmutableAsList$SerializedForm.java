package com.google.common.collect;

import java.io.Serializable;

class ImmutableAsList$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID;
  final ImmutableCollection<?> collection;

  ImmutableAsList$SerializedForm(ImmutableCollection<?> paramImmutableCollection)
  {
    this.collection = paramImmutableCollection;
  }

  Object readResolve()
  {
    return this.collection.h();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableAsList.SerializedForm
 * JD-Core Version:    0.6.2
 */