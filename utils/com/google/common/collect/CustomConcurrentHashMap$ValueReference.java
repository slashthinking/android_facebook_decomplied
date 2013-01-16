package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

abstract interface CustomConcurrentHashMap$ValueReference<K, V>
{
  public abstract CustomConcurrentHashMap.ReferenceEntry<K, V> a();

  public abstract ValueReference<K, V> a(ReferenceQueue<V> paramReferenceQueue, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);

  public abstract void a(ValueReference<K, V> paramValueReference);

  public abstract boolean b();

  public abstract V c();

  public abstract V get();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.ValueReference
 * JD-Core Version:    0.6.2
 */