package com.google.common.collect;

class CustomConcurrentHashMap$EvictionQueue$1 extends CustomConcurrentHashMap.AbstractReferenceEntry<K, V>
{
  CustomConcurrentHashMap.ReferenceEntry<K, V> a = this;
  CustomConcurrentHashMap.ReferenceEntry<K, V> b = this;

  CustomConcurrentHashMap$EvictionQueue$1(CustomConcurrentHashMap.EvictionQueue paramEvictionQueue)
  {
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getNextEvictable()
  {
    return this.a;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> getPreviousEvictable()
  {
    return this.b;
  }

  public void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.a = paramReferenceEntry;
  }

  public void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.b = paramReferenceEntry;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.EvictionQueue.1
 * JD-Core Version:    0.6.2
 */