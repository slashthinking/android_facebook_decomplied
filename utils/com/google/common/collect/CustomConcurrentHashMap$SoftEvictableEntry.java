package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

final class CustomConcurrentHashMap$SoftEvictableEntry<K, V> extends CustomConcurrentHashMap.SoftEntry<K, V>
  implements CustomConcurrentHashMap.ReferenceEntry<K, V>
{
  CustomConcurrentHashMap.ReferenceEntry<K, V> d = CustomConcurrentHashMap.h();
  CustomConcurrentHashMap.ReferenceEntry<K, V> e = CustomConcurrentHashMap.h();

  CustomConcurrentHashMap$SoftEvictableEntry(ReferenceQueue<K> paramReferenceQueue, K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    super(paramReferenceQueue, paramK, paramInt, paramReferenceEntry);
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNextEvictable()
  {
    return this.d;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousEvictable()
  {
    return this.e;
  }

  public void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.d = paramReferenceEntry;
  }

  public void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.e = paramReferenceEntry;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.SoftEvictableEntry
 * JD-Core Version:    0.6.2
 */