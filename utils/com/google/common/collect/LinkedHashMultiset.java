package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;

public final class LinkedHashMultiset<E> extends AbstractMapBasedMultiset<E>
{
  private static final long serialVersionUID;

  private LinkedHashMultiset()
  {
    super(new LinkedHashMap());
  }

  private LinkedHashMultiset(int paramInt)
  {
    super(new LinkedHashMap(Maps.b(paramInt)));
  }

  public static <E> LinkedHashMultiset<E> a(int paramInt)
  {
    return new LinkedHashMultiset(paramInt);
  }

  public static <E> LinkedHashMultiset<E> a(Iterable<? extends E> paramIterable)
  {
    LinkedHashMultiset localLinkedHashMultiset = a(Multisets.a(paramIterable));
    Iterables.a(localLinkedHashMultiset, paramIterable);
    return localLinkedHashMultiset;
  }

  public static <E> LinkedHashMultiset<E> e()
  {
    return new LinkedHashMultiset();
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    int i = Serialization.a(paramObjectInputStream);
    a(new LinkedHashMap(Maps.b(i)));
    Serialization.a(this, paramObjectInputStream, i);
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.a(this, paramObjectOutputStream);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.LinkedHashMultiset
 * JD-Core Version:    0.6.2
 */