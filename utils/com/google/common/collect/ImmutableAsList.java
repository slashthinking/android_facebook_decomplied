package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

final class ImmutableAsList<E> extends RegularImmutableList<E>
{
  private final transient ImmutableCollection<E> a;

  ImmutableAsList(Object[] paramArrayOfObject, ImmutableCollection<E> paramImmutableCollection)
  {
    super(paramArrayOfObject, 0, paramArrayOfObject.length);
    this.a = paramImmutableCollection;
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("Use SerializedForm");
  }

  public boolean contains(Object paramObject)
  {
    return this.a.contains(paramObject);
  }

  Object writeReplace()
  {
    return new ImmutableAsList.SerializedForm(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableAsList
 * JD-Core Version:    0.6.2
 */