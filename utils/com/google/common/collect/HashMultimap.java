package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

public final class HashMultimap<K, V> extends AbstractSetMultimap<K, V>
{
  private static final long serialVersionUID;
  transient int a = 8;

  private HashMultimap()
  {
    super(new HashMap());
  }

  public static <K, V> HashMultimap<K, V> m()
  {
    return new HashMultimap();
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    this.a = paramObjectInputStream.readInt();
    int i = Serialization.a(paramObjectInputStream);
    a(Maps.a(i));
    Serialization.a(this, paramObjectInputStream, i);
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(this.a);
    Serialization.a(this, paramObjectOutputStream);
  }

  Set<V> a()
  {
    return Sets.a(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.HashMultimap
 * JD-Core Version:    0.6.2
 */