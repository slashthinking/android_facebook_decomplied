package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

final class CustomConcurrentHashMap$StrongValueReference<K, V>
  implements CustomConcurrentHashMap.ValueReference<K, V>
{
  final V a;

  CustomConcurrentHashMap$StrongValueReference(V paramV)
  {
    this.a = paramV;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> a()
  {
    return null;
  }

  public CustomConcurrentHashMap.ValueReference<K, V> a(ReferenceQueue<V> paramReferenceQueue, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return this;
  }

  public void a(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference)
  {
  }

  public boolean b()
  {
    return false;
  }

  public V c()
  {
    return get();
  }

  public V get()
  {
    return this.a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.StrongValueReference
 * JD-Core Version:    0.6.2
 */