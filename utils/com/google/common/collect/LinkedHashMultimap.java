package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;

public final class LinkedHashMultimap<K, V> extends AbstractSetMultimap<K, V>
{
  private static final long serialVersionUID;
  transient int a = 8;
  transient Collection<Map.Entry<K, V>> b = Sets.b();

  private LinkedHashMultimap()
  {
    super(new LinkedHashMap());
  }

  public static <K, V> LinkedHashMultimap<K, V> m()
  {
    return new LinkedHashMultimap();
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    this.a = paramObjectInputStream.readInt();
    int i = Serialization.a(paramObjectInputStream);
    a(new LinkedHashMap(Maps.b(i)));
    this.b = new LinkedHashSet(i * this.a);
    Serialization.a(this, paramObjectInputStream, i);
    this.b.clear();
    for (int j = 0; j < d(); j++)
    {
      Object localObject1 = paramObjectInputStream.readObject();
      Object localObject2 = paramObjectInputStream.readObject();
      this.b.add(Maps.a(localObject1, localObject2));
    }
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(this.a);
    Serialization.a(this, paramObjectOutputStream);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }

  Set<V> a()
  {
    return new LinkedHashSet(Maps.b(this.a));
  }

  Collection<V> c(K paramK)
  {
    return new LinkedHashMultimap.SetDecorator(this, paramK, a());
  }

  Iterator<Map.Entry<K, V>> k()
  {
    return new LinkedHashMultimap.1(this, this.b.iterator());
  }

  public Set<Map.Entry<K, V>> l()
  {
    return super.l();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.LinkedHashMultimap
 * JD-Core Version:    0.6.2
 */