package com.google.common.collect;

 enum CustomConcurrentHashMap$EntryFactory$10
{
  CustomConcurrentHashMap$EntryFactory$10()
  {
    super(str, i, null);
  }

  <K, V> CustomConcurrentHashMap.ReferenceEntry<K, V> copyEntry(CustomConcurrentHashMap.Segment<K, V> paramSegment, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry1, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry2)
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = super.copyEntry(paramSegment, paramReferenceEntry1, paramReferenceEntry2);
    copyExpirableEntry(paramReferenceEntry1, localReferenceEntry);
    return localReferenceEntry;
  }

  <K, V> CustomConcurrentHashMap.ReferenceEntry<K, V> newEntry(CustomConcurrentHashMap.Segment<K, V> paramSegment, K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return new CustomConcurrentHashMap.WeakExpirableEntry(paramSegment.keyReferenceQueue, paramK, paramInt, paramReferenceEntry);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.EntryFactory.10
 * JD-Core Version:    0.6.2
 */