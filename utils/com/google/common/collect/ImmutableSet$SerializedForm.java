package com.google.common.collect;

import java.io.Serializable;

class ImmutableSet$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID;
  final Object[] elements;

  ImmutableSet$SerializedForm(Object[] paramArrayOfObject)
  {
    this.elements = paramArrayOfObject;
  }

  Object readResolve()
  {
    return ImmutableSet.a(this.elements);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableSet.SerializedForm
 * JD-Core Version:    0.6.2
 */