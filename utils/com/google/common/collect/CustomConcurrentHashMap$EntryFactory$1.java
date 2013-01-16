package com.google.common.collect;

 enum CustomConcurrentHashMap$EntryFactory$1
{
  CustomConcurrentHashMap$EntryFactory$1()
  {
    super(str, i, null);
  }

  <K, V> CustomConcurrentHashMap.ReferenceEntry<K, V> newEntry(CustomConcurrentHashMap.Segment<K, V> paramSegment, K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return new CustomConcurrentHashMap.StrongEntry(paramK, paramInt, paramReferenceEntry);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.EntryFactory.1
 * JD-Core Version:    0.6.2
 */