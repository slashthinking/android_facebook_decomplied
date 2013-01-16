package com.google.common.collect;

import java.lang.ref.ReferenceQueue;

final class CustomConcurrentHashMap$SoftExpirableEntry<K, V> extends CustomConcurrentHashMap.SoftEntry<K, V>
  implements CustomConcurrentHashMap.ReferenceEntry<K, V>
{
  volatile long d = 9223372036854775807L;
  CustomConcurrentHashMap.ReferenceEntry<K, V> e = CustomConcurrentHashMap.h();
  CustomConcurrentHashMap.ReferenceEntry<K, V> f = CustomConcurrentHashMap.h();

  CustomConcurrentHashMap$SoftExpirableEntry(ReferenceQueue<K> paramReferenceQueue, K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    super(paramReferenceQueue, paramK, paramInt, paramReferenceEntry);
  }

  public long getExpirationTime()
  {
    return this.d;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNextExpirable()
  {
    return this.e;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousExpirable()
  {
    return this.f;
  }

  public void setExpirationTime(long paramLong)
  {
    this.d = paramLong;
  }

  public void setNextExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.e = paramReferenceEntry;
  }

  public void setPreviousExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.f = paramReferenceEntry;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.SoftExpirableEntry
 * JD-Core Version:    0.6.2
 */