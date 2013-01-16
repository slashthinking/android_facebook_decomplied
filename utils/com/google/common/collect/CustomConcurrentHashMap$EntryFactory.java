package com.google.common.collect;

 enum CustomConcurrentHashMap$EntryFactory
{
  static final int EVICTABLE_MASK = 2;
  static final int EXPIRABLE_MASK = 1;
  static final EntryFactory[][] factories = arrayOfEntryFactory;;

  static
  {
    STRONG_EVICTABLE = new CustomConcurrentHashMap.EntryFactory.3("STRONG_EVICTABLE", 2);
    STRONG_EXPIRABLE_EVICTABLE = new CustomConcurrentHashMap.EntryFactory.4("STRONG_EXPIRABLE_EVICTABLE", 3);
    SOFT = new CustomConcurrentHashMap.EntryFactory.5("SOFT", 4);
    SOFT_EXPIRABLE = new CustomConcurrentHashMap.EntryFactory.6("SOFT_EXPIRABLE", 5);
    SOFT_EVICTABLE = new CustomConcurrentHashMap.EntryFactory.7("SOFT_EVICTABLE", 6);
    SOFT_EXPIRABLE_EVICTABLE = new CustomConcurrentHashMap.EntryFactory.8("SOFT_EXPIRABLE_EVICTABLE", 7);
    WEAK = new CustomConcurrentHashMap.EntryFactory.9("WEAK", 8);
    WEAK_EXPIRABLE = new CustomConcurrentHashMap.EntryFactory.10("WEAK_EXPIRABLE", 9);
    WEAK_EVICTABLE = new CustomConcurrentHashMap.EntryFactory.11("WEAK_EVICTABLE", 10);
    WEAK_EXPIRABLE_EVICTABLE = new CustomConcurrentHashMap.EntryFactory.12("WEAK_EXPIRABLE_EVICTABLE", 11);
    EntryFactory[] arrayOfEntryFactory1 = new EntryFactory[12];
    arrayOfEntryFactory1[0] = STRONG;
    arrayOfEntryFactory1[1] = STRONG_EXPIRABLE;
    arrayOfEntryFactory1[2] = STRONG_EVICTABLE;
    arrayOfEntryFactory1[3] = STRONG_EXPIRABLE_EVICTABLE;
    arrayOfEntryFactory1[4] = SOFT;
    arrayOfEntryFactory1[5] = SOFT_EXPIRABLE;
    arrayOfEntryFactory1[6] = SOFT_EVICTABLE;
    arrayOfEntryFactory1[7] = SOFT_EXPIRABLE_EVICTABLE;
    arrayOfEntryFactory1[8] = WEAK;
    arrayOfEntryFactory1[9] = WEAK_EXPIRABLE;
    arrayOfEntryFactory1[10] = WEAK_EVICTABLE;
    arrayOfEntryFactory1[11] = WEAK_EXPIRABLE_EVICTABLE;
    $VALUES = arrayOfEntryFactory1;
    EntryFactory[][] arrayOfEntryFactory; = new EntryFactory[3][];
    EntryFactory[] arrayOfEntryFactory2 = new EntryFactory[4];
    arrayOfEntryFactory2[0] = STRONG;
    arrayOfEntryFactory2[1] = STRONG_EXPIRABLE;
    arrayOfEntryFactory2[2] = STRONG_EVICTABLE;
    arrayOfEntryFactory2[3] = STRONG_EXPIRABLE_EVICTABLE;
    arrayOfEntryFactory;[0] = arrayOfEntryFactory2;
    EntryFactory[] arrayOfEntryFactory3 = new EntryFactory[4];
    arrayOfEntryFactory3[0] = SOFT;
    arrayOfEntryFactory3[1] = SOFT_EXPIRABLE;
    arrayOfEntryFactory3[2] = SOFT_EVICTABLE;
    arrayOfEntryFactory3[3] = SOFT_EXPIRABLE_EVICTABLE;
    arrayOfEntryFactory;[1] = arrayOfEntryFactory3;
    EntryFactory[] arrayOfEntryFactory4 = new EntryFactory[4];
    arrayOfEntryFactory4[0] = WEAK;
    arrayOfEntryFactory4[1] = WEAK_EXPIRABLE;
    arrayOfEntryFactory4[2] = WEAK_EVICTABLE;
    arrayOfEntryFactory4[3] = WEAK_EXPIRABLE_EVICTABLE;
    arrayOfEntryFactory;[2] = arrayOfEntryFactory4;
  }

  static EntryFactory getFactory(CustomConcurrentHashMap.Strength paramStrength, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1);
    for (int i = 1; ; i = 0)
    {
      int j = 0;
      if (paramBoolean2)
        j = 2;
      int k = j | i;
      return factories[paramStrength.ordinal()][k];
    }
  }

  <K, V> CustomConcurrentHashMap.ReferenceEntry<K, V> copyEntry(CustomConcurrentHashMap.Segment<K, V> paramSegment, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry1, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry2)
  {
    return newEntry(paramSegment, paramReferenceEntry1.getKey(), paramReferenceEntry1.getHash(), paramReferenceEntry2);
  }

  <K, V> void copyEvictableEntry(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry1, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry2)
  {
    CustomConcurrentHashMap.b(paramReferenceEntry1.getPreviousEvictable(), paramReferenceEntry2);
    CustomConcurrentHashMap.b(paramReferenceEntry2, paramReferenceEntry1.getNextEvictable());
    CustomConcurrentHashMap.e(paramReferenceEntry1);
  }

  <K, V> void copyExpirableEntry(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry1, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry2)
  {
    paramReferenceEntry2.setExpirationTime(paramReferenceEntry1.getExpirationTime());
    CustomConcurrentHashMap.a(paramReferenceEntry1.getPreviousExpirable(), paramReferenceEntry2);
    CustomConcurrentHashMap.a(paramReferenceEntry2, paramReferenceEntry1.getNextExpirable());
    CustomConcurrentHashMap.d(paramReferenceEntry1);
  }

  abstract <K, V> CustomConcurrentHashMap.ReferenceEntry<K, V> newEntry(CustomConcurrentHashMap.Segment<K, V> paramSegment, K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.EntryFactory
 * JD-Core Version:    0.6.2
 */