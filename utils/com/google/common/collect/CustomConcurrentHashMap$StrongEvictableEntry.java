package com.google.common.collect;

final class CustomConcurrentHashMap$StrongEvictableEntry<K, V> extends CustomConcurrentHashMap.StrongEntry<K, V>
  implements CustomConcurrentHashMap.ReferenceEntry<K, V>
{
  CustomConcurrentHashMap.ReferenceEntry<K, V> e = CustomConcurrentHashMap.h();
  CustomConcurrentHashMap.ReferenceEntry<K, V> f = CustomConcurrentHashMap.h();

  CustomConcurrentHashMap$StrongEvictableEntry(K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    super(paramK, paramInt, paramReferenceEntry);
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNextEvictable()
  {
    return this.e;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousEvictable()
  {
    return this.f;
  }

  public void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.e = paramReferenceEntry;
  }

  public void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.f = paramReferenceEntry;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.StrongEvictableEntry
 * JD-Core Version:    0.6.2
 */