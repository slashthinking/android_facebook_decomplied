package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class CustomConcurrentHashMap$WeakValueReference<K, V> extends WeakReference<V>
  implements CustomConcurrentHashMap.ValueReference<K, V>
{
  final CustomConcurrentHashMap.ReferenceEntry<K, V> a;

  CustomConcurrentHashMap$WeakValueReference(ReferenceQueue<V> paramReferenceQueue, V paramV, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    super(paramV, paramReferenceQueue);
    this.a = paramReferenceEntry;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> a()
  {
    return this.a;
  }

  public CustomConcurrentHashMap.ValueReference<K, V> a(ReferenceQueue<V> paramReferenceQueue, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return new WeakValueReference(paramReferenceQueue, get(), paramReferenceEntry);
  }

  public void a(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference)
  {
    clear();
  }

  public boolean b()
  {
    return false;
  }

  public V c()
  {
    return get();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.WeakValueReference
 * JD-Core Version:    0.6.2
 */