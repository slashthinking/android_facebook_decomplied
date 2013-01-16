package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Equivalences;

 enum CustomConcurrentHashMap$Strength$2
{
  CustomConcurrentHashMap$Strength$2()
  {
    super(str, i, null);
  }

  Equivalence<Object> defaultEquivalence()
  {
    return Equivalences.identity();
  }

  <K, V> CustomConcurrentHashMap.ValueReference<K, V> referenceValue(CustomConcurrentHashMap.Segment<K, V> paramSegment, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, V paramV)
  {
    return new CustomConcurrentHashMap.SoftValueReference(paramSegment.valueReferenceQueue, paramV, paramReferenceEntry);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.Strength.2
 * JD-Core Version:    0.6.2
 */