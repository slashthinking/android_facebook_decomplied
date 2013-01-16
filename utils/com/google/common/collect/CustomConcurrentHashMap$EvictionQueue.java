package com.google.common.collect;

import java.util.AbstractQueue;
import java.util.Iterator;

final class CustomConcurrentHashMap$EvictionQueue<K, V> extends AbstractQueue<CustomConcurrentHashMap.ReferenceEntry<K, V>>
{
  final CustomConcurrentHashMap.ReferenceEntry<K, V> a = new CustomConcurrentHashMap.EvictionQueue.1(this);

  public CustomConcurrentHashMap.ReferenceEntry<K, V> a()
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = this.a.getNextEvictable();
    if (localReferenceEntry == this.a)
      localReferenceEntry = null;
    return localReferenceEntry;
  }

  public boolean a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    CustomConcurrentHashMap.b(paramReferenceEntry.getPreviousEvictable(), paramReferenceEntry.getNextEvictable());
    CustomConcurrentHashMap.b(this.a.getPreviousEvictable(), paramReferenceEntry);
    CustomConcurrentHashMap.b(paramReferenceEntry, this.a);
    return true;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> b()
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = this.a.getNextEvictable();
    if (localReferenceEntry == this.a)
      localReferenceEntry = null;
    while (true)
    {
      return localReferenceEntry;
      remove(localReferenceEntry);
    }
  }

  public void clear()
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry;
    for (Object localObject = this.a.getNextEvictable(); localObject != this.a; localObject = localReferenceEntry)
    {
      localReferenceEntry = ((CustomConcurrentHashMap.ReferenceEntry)localObject).getNextEvictable();
      CustomConcurrentHashMap.e((CustomConcurrentHashMap.ReferenceEntry)localObject);
    }
    this.a.setNextEvictable(this.a);
    this.a.setPreviousEvictable(this.a);
  }

  public boolean contains(Object paramObject)
  {
    if (((CustomConcurrentHashMap.ReferenceEntry)paramObject).getNextEvictable() != CustomConcurrentHashMap.NullEntry.INSTANCE);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isEmpty()
  {
    if (this.a.getNextEvictable() == this.a);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public Iterator<CustomConcurrentHashMap.ReferenceEntry<K, V>> iterator()
  {
    return new CustomConcurrentHashMap.EvictionQueue.2(this, a());
  }

  public boolean remove(Object paramObject)
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)paramObject;
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2 = localReferenceEntry1.getPreviousEvictable();
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry3 = localReferenceEntry1.getNextEvictable();
    CustomConcurrentHashMap.b(localReferenceEntry2, localReferenceEntry3);
    CustomConcurrentHashMap.e(localReferenceEntry1);
    if (localReferenceEntry3 != CustomConcurrentHashMap.NullEntry.INSTANCE);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public int size()
  {
    int i = 0;
    for (CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = this.a.getNextEvictable(); localReferenceEntry != this.a; localReferenceEntry = localReferenceEntry.getNextEvictable())
      i++;
    return i;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.EvictionQueue
 * JD-Core Version:    0.6.2
 */