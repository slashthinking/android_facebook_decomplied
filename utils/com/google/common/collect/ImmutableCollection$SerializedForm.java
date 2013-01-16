package com.google.common.collect;

import java.io.Serializable;

class ImmutableCollection$SerializedForm
  implements Serializable
{
  private static final long serialVersionUID;
  final Object[] elements;

  ImmutableCollection$SerializedForm(Object[] paramArrayOfObject)
  {
    this.elements = paramArrayOfObject;
  }

  Object readResolve()
  {
    if (this.elements.length == 0);
    for (Object localObject = ImmutableCollection.c; ; localObject = new ImmutableCollection.ArrayImmutableCollection(Platform.a(this.elements)))
      return localObject;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableCollection.SerializedForm
 * JD-Core Version:    0.6.2
 */