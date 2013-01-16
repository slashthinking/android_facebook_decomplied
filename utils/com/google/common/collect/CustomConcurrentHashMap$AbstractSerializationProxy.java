package com.google.common.collect;

import com.google.common.base.Equivalence;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

abstract class CustomConcurrentHashMap$AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 3L;
  transient ConcurrentMap<K, V> a;
  final int concurrencyLevel;
  final long expireAfterAccessNanos;
  final long expireAfterWriteNanos;
  final Equivalence<Object> keyEquivalence;
  final CustomConcurrentHashMap.Strength keyStrength;
  final int maximumSize;
  final MapMaker.RemovalListener<? super K, ? super V> removalListener;
  final Equivalence<Object> valueEquivalence;
  final CustomConcurrentHashMap.Strength valueStrength;

  CustomConcurrentHashMap$AbstractSerializationProxy(CustomConcurrentHashMap.Strength paramStrength1, CustomConcurrentHashMap.Strength paramStrength2, Equivalence<Object> paramEquivalence1, Equivalence<Object> paramEquivalence2, long paramLong1, long paramLong2, int paramInt1, int paramInt2, MapMaker.RemovalListener<? super K, ? super V> paramRemovalListener, ConcurrentMap<K, V> paramConcurrentMap)
  {
    this.keyStrength = paramStrength1;
    this.valueStrength = paramStrength2;
    this.keyEquivalence = paramEquivalence1;
    this.valueEquivalence = paramEquivalence2;
    this.expireAfterWriteNanos = paramLong1;
    this.expireAfterAccessNanos = paramLong2;
    this.maximumSize = paramInt1;
    this.concurrencyLevel = paramInt2;
    this.removalListener = paramRemovalListener;
    this.a = paramConcurrentMap;
  }

  MapMaker a(ObjectInputStream paramObjectInputStream)
  {
    int i = paramObjectInputStream.readInt();
    MapMaker localMapMaker = new MapMaker().a(i).a(this.keyStrength).b(this.valueStrength).a(this.keyEquivalence).b(this.valueEquivalence).c(this.concurrencyLevel);
    localMapMaker.a(this.removalListener);
    if (this.expireAfterWriteNanos > 0L)
      localMapMaker.b(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
    if (this.expireAfterAccessNanos > 0L)
      localMapMaker.c(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
    if (this.maximumSize != -1)
      localMapMaker.b(this.maximumSize);
    return localMapMaker;
  }

  protected ConcurrentMap<K, V> a()
  {
    return this.a;
  }

  void a(ObjectOutputStream paramObjectOutputStream)
  {
    paramObjectOutputStream.writeInt(this.a.size());
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
    paramObjectOutputStream.writeObject(null);
  }

  void b(ObjectInputStream paramObjectInputStream)
  {
    while (true)
    {
      Object localObject1 = paramObjectInputStream.readObject();
      if (localObject1 == null)
        return;
      Object localObject2 = paramObjectInputStream.readObject();
      this.a.put(localObject1, localObject2);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.AbstractSerializationProxy
 * JD-Core Version:    0.6.2
 */