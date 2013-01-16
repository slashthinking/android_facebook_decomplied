package com.google.common.collect;

 enum CustomConcurrentHashMap$EntryFactory$4
{
  CustomConcurrentHashMap$EntryFactory$4()
  {
    super(str, i, null);
  }

  <K, V> CustomConcurrentHashMap.ReferenceEntry<K, V> copyEntry(CustomConcurrentHashMap.Segment<K, V> paramSegment, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry1, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry2)
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = super.copyEntry(paramSegment, paramReferenceEntry1, paramReferenceEntry2);
    copyExpirableEntry(paramReferenceEntry1, localReferenceEntry);
    copyEvictableEntry(paramReferenceEntry1, localReferenceEntry);
    return localReferenceEntry;
  }

  <K, V> CustomConcurrentHashMap.ReferenceEntry<K, V> newEntry(CustomConcurrentHashMap.Segment<K, V> paramSegment, K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return new CustomConcurrentHashMap.StrongExpirableEvictableEntry(paramK, paramInt, paramReferenceEntry);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.EntryFactory.4
 * JD-Core Version:    0.6.2
 */