package com.google.common.collect;

class CustomConcurrentHashMap$StrongEntry<K, V>
  implements CustomConcurrentHashMap.ReferenceEntry<K, V>
{
  final K a;
  final int b;
  final CustomConcurrentHashMap.ReferenceEntry<K, V> c;
  volatile CustomConcurrentHashMap.ValueReference<K, V> d = CustomConcurrentHashMap.g();

  CustomConcurrentHashMap$StrongEntry(K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.a = paramK;
    this.b = paramInt;
    this.c = paramReferenceEntry;
  }

  public long getExpirationTime()
  {
    throw new UnsupportedOperationException();
  }

  public int getHash()
  {
    return this.b;
  }

  public K getKey()
  {
    return this.a;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNext()
  {
    return this.c;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNextEvictable()
  {
    throw new UnsupportedOperationException();
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNextExpirable()
  {
    throw new UnsupportedOperationException();
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousEvictable()
  {
    throw new UnsupportedOperationException();
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousExpirable()
  {
    throw new UnsupportedOperationException();
  }

  public CustomConcurrentHashMap.ValueReference<K, V> getValueReference()
  {
    return this.d;
  }

  public void setExpirationTime(long paramLong)
  {
    throw new UnsupportedOperationException();
  }

  public void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    throw new UnsupportedOperationException();
  }

  public void setNextExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    throw new UnsupportedOperationException();
  }

  public void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    throw new UnsupportedOperationException();
  }

  public void setPreviousExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    throw new UnsupportedOperationException();
  }

  public void setValueReference(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference)
  {
    CustomConcurrentHashMap.ValueReference localValueReference = this.d;
    this.d = paramValueReference;
    localValueReference.a(paramValueReference);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.StrongEntry
 * JD-Core Version:    0.6.2
 */