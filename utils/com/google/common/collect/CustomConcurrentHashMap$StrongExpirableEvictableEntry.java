package com.google.common.collect;

final class CustomConcurrentHashMap$StrongExpirableEvictableEntry<K, V> extends CustomConcurrentHashMap.StrongEntry<K, V>
  implements CustomConcurrentHashMap.ReferenceEntry<K, V>
{
  volatile long e = 9223372036854775807L;
  CustomConcurrentHashMap.ReferenceEntry<K, V> f = CustomConcurrentHashMap.h();
  CustomConcurrentHashMap.ReferenceEntry<K, V> g = CustomConcurrentHashMap.h();
  CustomConcurrentHashMap.ReferenceEntry<K, V> h = CustomConcurrentHashMap.h();
  CustomConcurrentHashMap.ReferenceEntry<K, V> i = CustomConcurrentHashMap.h();

  CustomConcurrentHashMap$StrongExpirableEvictableEntry(K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    super(paramK, paramInt, paramReferenceEntry);
  }

  public long getExpirationTime()
  {
    return this.e;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNextEvictable()
  {
    return this.h;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNextExpirable()
  {
    return this.f;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousEvictable()
  {
    return this.i;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousExpirable()
  {
    return this.g;
  }

  public void setExpirationTime(long paramLong)
  {
    this.e = paramLong;
  }

  public void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.h = paramReferenceEntry;
  }

  public void setNextExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.f = paramReferenceEntry;
  }

  public void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.i = paramReferenceEntry;
  }

  public void setPreviousExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.g = paramReferenceEntry;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.StrongExpirableEvictableEntry
 * JD-Core Version:    0.6.2
 */