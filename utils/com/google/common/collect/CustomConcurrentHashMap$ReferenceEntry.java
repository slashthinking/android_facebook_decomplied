package com.google.common.collect;

abstract interface CustomConcurrentHashMap$ReferenceEntry<K, V>
{
  public abstract long getExpirationTime();

  public abstract int getHash();

  public abstract K getKey();

  public abstract ReferenceEntry<K, V> getNext();

  public abstract ReferenceEntry<K, V> getNextEvictable();

  public abstract ReferenceEntry<K, V> getNextExpirable();

  public abstract ReferenceEntry<K, V> getPreviousEvictable();

  public abstract ReferenceEntry<K, V> getPreviousExpirable();

  public abstract CustomConcurrentHashMap.ValueReference<K, V> getValueReference();

  public abstract void setExpirationTime(long paramLong);

  public abstract void setNextEvictable(ReferenceEntry<K, V> paramReferenceEntry);

  public abstract void setNextExpirable(ReferenceEntry<K, V> paramReferenceEntry);

  public abstract void setPreviousEvictable(ReferenceEntry<K, V> paramReferenceEntry);

  public abstract void setPreviousExpirable(ReferenceEntry<K, V> paramReferenceEntry);

  public abstract void setValueReference(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.ReferenceEntry
 * JD-Core Version:    0.6.2
 */