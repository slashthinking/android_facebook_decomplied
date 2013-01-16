package com.google.common.collect;

 enum CustomConcurrentHashMap$NullEntry
  implements CustomConcurrentHashMap.ReferenceEntry<Object, Object>
{
  static
  {
    NullEntry[] arrayOfNullEntry = new NullEntry[1];
    arrayOfNullEntry[0] = INSTANCE;
  }

  public long getExpirationTime()
  {
    return 0L;
  }

  public int getHash()
  {
    return 0;
  }

  public Object getKey()
  {
    return null;
  }

  public CustomConcurrentHashMap.ReferenceEntry<Object, Object> getNext()
  {
    return null;
  }

  public CustomConcurrentHashMap.ReferenceEntry<Object, Object> getNextEvictable()
  {
    return this;
  }

  public CustomConcurrentHashMap.ReferenceEntry<Object, Object> getNextExpirable()
  {
    return this;
  }

  public CustomConcurrentHashMap.ReferenceEntry<Object, Object> getPreviousEvictable()
  {
    return this;
  }

  public CustomConcurrentHashMap.ReferenceEntry<Object, Object> getPreviousExpirable()
  {
    return this;
  }

  public CustomConcurrentHashMap.ValueReference<Object, Object> getValueReference()
  {
    return null;
  }

  public void setExpirationTime(long paramLong)
  {
  }

  public void setNextEvictable(CustomConcurrentHashMap.ReferenceEntry<Object, Object> paramReferenceEntry)
  {
  }

  public void setNextExpirable(CustomConcurrentHashMap.ReferenceEntry<Object, Object> paramReferenceEntry)
  {
  }

  public void setPreviousEvictable(CustomConcurrentHashMap.ReferenceEntry<Object, Object> paramReferenceEntry)
  {
  }

  public void setPreviousExpirable(CustomConcurrentHashMap.ReferenceEntry<Object, Object> paramReferenceEntry)
  {
  }

  public void setValueReference(CustomConcurrentHashMap.ValueReference<Object, Object> paramValueReference)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.NullEntry
 * JD-Core Version:    0.6.2
 */