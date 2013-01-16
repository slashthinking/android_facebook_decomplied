package com.google.common.collect;

class CustomConcurrentHashMap$ExpirationQueue$1 extends CustomConcurrentHashMap.AbstractReferenceEntry<K, V>
{
  CustomConcurrentHashMap.ReferenceEntry<K, V> a = this;
  CustomConcurrentHashMap.ReferenceEntry<K, V> b = this;

  CustomConcurrentHashMap$ExpirationQueue$1(CustomConcurrentHashMap.ExpirationQueue paramExpirationQueue)
  {
  }

  public long getExpirationTime()
  {
    return 9223372036854775807L;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNextExpirable()
  {
    return this.a;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousExpirable()
  {
    return this.b;
  }

  public void setExpirationTime(long paramLong)
  {
  }

  public void setNextExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.a = paramReferenceEntry;
  }

  public void setPreviousExpirable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.b = paramReferenceEntry;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.ExpirationQueue.1
 * JD-Core Version:    0.6.2
 */