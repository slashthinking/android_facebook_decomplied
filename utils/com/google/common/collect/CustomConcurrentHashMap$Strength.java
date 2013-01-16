package com.google.common.collect;

import com.google.common.base.Equivalence;

 enum CustomConcurrentHashMap$Strength
{
  static
  {
    SOFT = new CustomConcurrentHashMap.Strength.2("SOFT", 1);
    WEAK = new CustomConcurrentHashMap.Strength.3("WEAK", 2);
    Strength[] arrayOfStrength = new Strength[3];
    arrayOfStrength[0] = STRONG;
    arrayOfStrength[1] = SOFT;
    arrayOfStrength[2] = WEAK;
  }

  abstract Equivalence<Object> defaultEquivalence();

  abstract <K, V> CustomConcurrentHashMap.ValueReference<K, V> referenceValue(CustomConcurrentHashMap.Segment<K, V> paramSegment, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, V paramV);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.Strength
 * JD-Core Version:    0.6.2
 */