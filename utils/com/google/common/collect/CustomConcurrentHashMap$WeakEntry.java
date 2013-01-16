package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class CustomConcurrentHashMap$WeakEntry<K, V> extends WeakReference<K>
  implements CustomConcurrentHashMap.ReferenceEntry<K, V>
{
  final int a;
  final CustomConcurrentHashMap.ReferenceEntry<K, V> b;
  volatile CustomConcurrentHashMap.ValueReference<K, V> c = CustomConcurrentHashMap.g();

  CustomConcurrentHashMap$WeakEntry(ReferenceQueue<K> paramReferenceQueue, K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    super(paramK, paramReferenceQueue);
    this.a = paramInt;
    this.b = paramReferenceEntry;
  }

  public long getExpirationTime()
  {
    throw new UnsupportedOperationException();
  }

  public int getHash()
  {
    return this.a;
  }

  public K getKey()
  {
    return get();
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNext()
  {
    return this.b;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNextEvictable()
  {
    throw new UnsupportedOperationException();
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNextExpirable()
  {
    throw new UnsupportedOperationException();
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousEvictable()
  {
    throw new UnsupportedOperationException();
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousExpirable()
  {
    throw new UnsupportedOperationException();
  }

  public CustomConcurrentHashMap.ValueReference<K, V> getValueReference()
  {
    return this.c;
  }

  public void setExpirationTime(long paramLong)
  {
    throw new UnsupportedOperationException();
  }

  public void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    throw new UnsupportedOperationException();
  }

  public void setNextExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    throw new UnsupportedOperationException();
  }

  public void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    throw new UnsupportedOperationException();
  }

  public void setPreviousExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    throw new UnsupportedOperationException();
  }

  public void setValueReference(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference)
  {
    CustomConcurrentHashMap.ValueReference localValueReference = this.c;
    this.c = paramValueReference;
    localValueReference.a(paramValueReference);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.WeakEntry
 * JD-Core Version:    0.6.2
 */