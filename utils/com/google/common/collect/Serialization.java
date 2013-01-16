package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class Serialization
{
  static int a(ObjectInputStream paramObjectInputStream)
  {
    return paramObjectInputStream.readInt();
  }

  static <T> Serialization.FieldSetter<T> a(Class<T> paramClass, String paramString)
  {
    try
    {
      Serialization.FieldSetter localFieldSetter = new Serialization.FieldSetter(paramClass.getDeclaredField(paramString), null);
      return localFieldSetter;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new AssertionError(localNoSuchFieldException);
    }
  }

  static <K, V> void a(Multimap<K, V> paramMultimap, ObjectInputStream paramObjectInputStream, int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
    {
      Collection localCollection = paramMultimap.b(paramObjectInputStream.readObject());
      int j = paramObjectInputStream.readInt();
      for (int k = 0; k < j; k++)
        localCollection.add(paramObjectInputStream.readObject());
    }
  }

  static <K, V> void a(Multimap<K, V> paramMultimap, ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeInt(paramMultimap.b().size());
    Iterator localIterator1 = paramMultimap.b().entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeInt(((Collection)localEntry.getValue()).size());
      Iterator localIterator2 = ((Collection)localEntry.getValue()).iterator();
      while (localIterator2.hasNext())
        paramObjectOutputStream.writeObject(localIterator2.next());
    }
  }

  static <E> void a(Multiset<E> paramMultiset, ObjectInputStream paramObjectInputStream, int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
      paramMultiset.a(paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
  }

  static <E> void a(Multiset<E> paramMultiset, ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeInt(paramMultiset.a().size());
    Iterator localIterator = paramMultiset.a().iterator();
    while (localIterator.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.a());
      paramObjectOutputStream.writeInt(localEntry.b());
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Serialization
 * JD-Core Version:    0.6.2
 */