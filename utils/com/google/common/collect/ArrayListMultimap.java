package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ArrayListMultimap<K, V> extends AbstractListMultimap<K, V>
{
  private static final long serialVersionUID;
  transient int a = 10;

  private ArrayListMultimap()
  {
    super(new HashMap());
  }

  public static <K, V> ArrayListMultimap<K, V> l()
  {
    return new ArrayListMultimap();
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

  List<V> a()
  {
    return new ArrayList(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ArrayListMultimap
 * JD-Core Version:    0.6.2
 */