package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Ticker;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

class CustomConcurrentHashMap$Segment<K, V> extends ReentrantLock
{
  volatile int count;
  final Queue<CustomConcurrentHashMap.ReferenceEntry<K, V>> evictionQueue;
  final Queue<CustomConcurrentHashMap.ReferenceEntry<K, V>> expirationQueue;
  final ReferenceQueue<K> keyReferenceQueue;
  final CustomConcurrentHashMap<K, V> map;
  final int maxSegmentSize;
  int modCount;
  final AtomicInteger readCount = new AtomicInteger();
  final Queue<CustomConcurrentHashMap.ReferenceEntry<K, V>> recencyQueue;
  volatile AtomicReferenceArray<CustomConcurrentHashMap.ReferenceEntry<K, V>> table;
  int threshold;
  final ReferenceQueue<V> valueReferenceQueue;

  CustomConcurrentHashMap$Segment(CustomConcurrentHashMap<K, V> paramCustomConcurrentHashMap, int paramInt1, int paramInt2)
  {
    this.map = paramCustomConcurrentHashMap;
    this.maxSegmentSize = paramInt2;
    a(a(paramInt1));
    ReferenceQueue localReferenceQueue1;
    Object localObject1;
    label108: Object localObject2;
    if (paramCustomConcurrentHashMap.e())
    {
      localReferenceQueue1 = new ReferenceQueue();
      this.keyReferenceQueue = localReferenceQueue1;
      boolean bool = paramCustomConcurrentHashMap.f();
      ReferenceQueue localReferenceQueue2 = null;
      if (bool)
        localReferenceQueue2 = new ReferenceQueue();
      this.valueReferenceQueue = localReferenceQueue2;
      if ((!paramCustomConcurrentHashMap.a()) && (!paramCustomConcurrentHashMap.d()))
        break label165;
      localObject1 = new ConcurrentLinkedQueue();
      this.recencyQueue = ((Queue)localObject1);
      if (!paramCustomConcurrentHashMap.a())
        break label173;
      localObject2 = new CustomConcurrentHashMap.EvictionQueue();
      label130: this.evictionQueue = ((Queue)localObject2);
      if (!paramCustomConcurrentHashMap.b())
        break label181;
    }
    label165: label173: label181: for (Object localObject3 = new CustomConcurrentHashMap.ExpirationQueue(); ; localObject3 = CustomConcurrentHashMap.i())
    {
      this.expirationQueue = ((Queue)localObject3);
      return;
      localReferenceQueue1 = null;
      break;
      localObject1 = CustomConcurrentHashMap.i();
      break label108;
      localObject2 = CustomConcurrentHashMap.i();
      break label130;
    }
  }

  CustomConcurrentHashMap.ReferenceEntry<K, V> a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry1, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry2)
  {
    CustomConcurrentHashMap.ValueReference localValueReference = paramReferenceEntry1.getValueReference();
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = this.map.d.copyEntry(this, paramReferenceEntry1, paramReferenceEntry2);
    localReferenceEntry.setValueReference(localValueReference.a(this.valueReferenceQueue, localReferenceEntry));
    return localReferenceEntry;
  }

  CustomConcurrentHashMap.ReferenceEntry<K, V> a(Object paramObject, int paramInt)
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry;
    if (this.count != 0)
    {
      localReferenceEntry = b(paramInt);
      if (localReferenceEntry != null)
      {
        if (localReferenceEntry.getHash() != paramInt);
        Object localObject;
        label57: 
        do
          while (true)
          {
            localReferenceEntry = localReferenceEntry.getNext();
            break;
            localObject = localReferenceEntry.getKey();
            if (localObject != null)
              break label57;
            a();
          }
        while (!this.map.keyEquivalence.equivalent(paramObject, localObject));
      }
    }
    while (true)
    {
      return localReferenceEntry;
      localReferenceEntry = null;
    }
  }

  CustomConcurrentHashMap.ReferenceEntry<K, V> a(K paramK, int paramInt, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return this.map.d.newEntry(this, paramK, paramInt, paramReferenceEntry);
  }

  V a(K paramK, int paramInt, V paramV)
  {
    lock();
    try
    {
      o();
      AtomicReferenceArray localAtomicReferenceArray = this.table;
      int i = paramInt & -1 + localAtomicReferenceArray.length();
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(i);
      Object localObject2 = localReferenceEntry1;
      Object localObject5;
      Object localObject3;
      if (localObject2 != null)
      {
        Object localObject4 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getKey();
        if ((((CustomConcurrentHashMap.ReferenceEntry)localObject2).getHash() == paramInt) && (localObject4 != null) && (this.map.keyEquivalence.equivalent(paramK, localObject4)))
        {
          CustomConcurrentHashMap.ValueReference localValueReference = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getValueReference();
          localObject5 = localValueReference.get();
          if (localObject5 == null)
          {
            if (a(localValueReference))
            {
              (-1 + this.count);
              this.modCount = (1 + this.modCount);
              a(localObject4, paramInt, localObject5, MapMaker.RemovalCause.COLLECTED);
              CustomConcurrentHashMap.ReferenceEntry localReferenceEntry3 = b(localReferenceEntry1, (CustomConcurrentHashMap.ReferenceEntry)localObject2);
              int j = -1 + this.count;
              localAtomicReferenceArray.set(i, localReferenceEntry3);
              this.count = j;
            }
            unlock();
            p();
            localObject3 = null;
          }
        }
      }
      while (true)
      {
        return localObject3;
        this.modCount = (1 + this.modCount);
        a(paramK, paramInt, localObject5, MapMaker.RemovalCause.REPLACED);
        a((CustomConcurrentHashMap.ReferenceEntry)localObject2, paramV);
        unlock();
        p();
        localObject3 = localObject5;
        continue;
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getNext();
        localObject2 = localReferenceEntry2;
        break;
        unlock();
        p();
        localObject3 = null;
      }
    }
    finally
    {
      unlock();
      p();
    }
  }

  V a(K paramK, int paramInt, V paramV, boolean paramBoolean)
  {
    lock();
    while (true)
    {
      int i;
      try
      {
        o();
        i = 1 + this.count;
        if (i > this.threshold)
        {
          l();
          i = 1 + this.count;
        }
        AtomicReferenceArray localAtomicReferenceArray = this.table;
        int j = paramInt & -1 + localAtomicReferenceArray.length();
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(j);
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2 = localReferenceEntry1;
        Object localObject2;
        if (localReferenceEntry2 != null)
        {
          Object localObject3 = localReferenceEntry2.getKey();
          if ((localReferenceEntry2.getHash() == paramInt) && (localObject3 != null) && (this.map.keyEquivalence.equivalent(paramK, localObject3)))
          {
            CustomConcurrentHashMap.ValueReference localValueReference = localReferenceEntry2.getValueReference();
            localObject2 = localValueReference.get();
            if (localObject2 == null)
            {
              this.modCount = (1 + this.modCount);
              a(localReferenceEntry2, paramV);
              if (!localValueReference.b())
              {
                a(paramK, paramInt, localObject2, MapMaker.RemovalCause.COLLECTED);
                i = this.count;
                this.count = i;
                unlock();
                p();
                localObject2 = null;
                return localObject2;
              }
              if (!k())
                continue;
              i = 1 + this.count;
              continue;
            }
            if (paramBoolean)
            {
              b(localReferenceEntry2);
              unlock();
              p();
              continue;
            }
            this.modCount = (1 + this.modCount);
            a(paramK, paramInt, localObject2, MapMaker.RemovalCause.REPLACED);
            a(localReferenceEntry2, paramV);
            unlock();
            p();
            continue;
          }
          localReferenceEntry2 = localReferenceEntry2.getNext();
          continue;
        }
        this.modCount = (1 + this.modCount);
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry3 = a(paramK, paramInt, localReferenceEntry1);
        a(localReferenceEntry3, paramV);
        localAtomicReferenceArray.set(j, localReferenceEntry3);
        if (k())
        {
          k = 1 + this.count;
          this.count = k;
          unlock();
          p();
          localObject2 = null;
          continue;
        }
      }
      finally
      {
        unlock();
        p();
      }
      int k = i;
    }
  }

  AtomicReferenceArray<CustomConcurrentHashMap.ReferenceEntry<K, V>> a(int paramInt)
  {
    return new AtomicReferenceArray(paramInt);
  }

  void a()
  {
    if (tryLock());
    try
    {
      b();
      return;
    }
    finally
    {
      unlock();
    }
  }

  void a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    if (this.map.d())
      a(paramReferenceEntry, this.map.expireAfterAccessNanos);
    this.recencyQueue.add(paramReferenceEntry);
  }

  void a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, long paramLong)
  {
    paramReferenceEntry.setExpirationTime(paramLong + this.map.ticker.read());
  }

  void a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, MapMaker.RemovalCause paramRemovalCause)
  {
    a(paramReferenceEntry.getKey(), paramReferenceEntry.getHash(), paramReferenceEntry.getValueReference().get(), paramRemovalCause);
  }

  void a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, V paramV)
  {
    paramReferenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, paramReferenceEntry, paramV));
    c(paramReferenceEntry);
  }

  void a(K paramK, int paramInt, V paramV, MapMaker.RemovalCause paramRemovalCause)
  {
    if (this.map.removalNotificationQueue != CustomConcurrentHashMap.f)
    {
      MapMaker.RemovalNotification localRemovalNotification = new MapMaker.RemovalNotification(paramK, paramV, paramRemovalCause);
      this.map.removalNotificationQueue.offer(localRemovalNotification);
    }
  }

  void a(AtomicReferenceArray<CustomConcurrentHashMap.ReferenceEntry<K, V>> paramAtomicReferenceArray)
  {
    this.threshold = (3 * paramAtomicReferenceArray.length() / 4);
    if (this.threshold == this.maxSegmentSize)
      this.threshold = (1 + this.threshold);
    this.table = paramAtomicReferenceArray;
  }

  boolean a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, int paramInt)
  {
    lock();
    try
    {
      (-1 + this.count);
      AtomicReferenceArray localAtomicReferenceArray = this.table;
      int i = paramInt & -1 + localAtomicReferenceArray.length();
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(i);
      Object localObject2 = localReferenceEntry1;
      if (localObject2 != null)
        if (localObject2 == paramReferenceEntry)
        {
          this.modCount = (1 + this.modCount);
          a(((CustomConcurrentHashMap.ReferenceEntry)localObject2).getKey(), paramInt, ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getValueReference().get(), MapMaker.RemovalCause.COLLECTED);
          CustomConcurrentHashMap.ReferenceEntry localReferenceEntry3 = b(localReferenceEntry1, (CustomConcurrentHashMap.ReferenceEntry)localObject2);
          int j = -1 + this.count;
          localAtomicReferenceArray.set(i, localReferenceEntry3);
          this.count = j;
        }
      for (boolean bool = true; ; bool = false)
      {
        return bool;
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getNext();
        localObject2 = localReferenceEntry2;
        break;
        unlock();
        p();
      }
    }
    finally
    {
      unlock();
      p();
    }
  }

  boolean a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, int paramInt, MapMaker.RemovalCause paramRemovalCause)
  {
    (-1 + this.count);
    AtomicReferenceArray localAtomicReferenceArray = this.table;
    int i = paramInt & -1 + localAtomicReferenceArray.length();
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(i);
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2 = localReferenceEntry1;
    if (localReferenceEntry2 != null)
      if (localReferenceEntry2 == paramReferenceEntry)
      {
        this.modCount = (1 + this.modCount);
        a(localReferenceEntry2.getKey(), paramInt, localReferenceEntry2.getValueReference().get(), paramRemovalCause);
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry3 = b(localReferenceEntry1, localReferenceEntry2);
        int j = -1 + this.count;
        localAtomicReferenceArray.set(i, localReferenceEntry3);
        this.count = j;
      }
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      localReferenceEntry2 = localReferenceEntry2.getNext();
      break;
    }
  }

  boolean a(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference)
  {
    boolean bool1 = paramValueReference.b();
    boolean bool2 = false;
    if (bool1);
    while (true)
    {
      return bool2;
      Object localObject = paramValueReference.get();
      bool2 = false;
      if (localObject == null)
        bool2 = true;
    }
  }

  boolean a(K paramK, int paramInt, CustomConcurrentHashMap.ValueReference<K, V> paramValueReference)
  {
    lock();
    try
    {
      (-1 + this.count);
      AtomicReferenceArray localAtomicReferenceArray = this.table;
      int i = paramInt & -1 + localAtomicReferenceArray.length();
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(i);
      Object localObject2 = localReferenceEntry1;
      boolean bool;
      if (localObject2 != null)
      {
        Object localObject3 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getKey();
        if ((((CustomConcurrentHashMap.ReferenceEntry)localObject2).getHash() == paramInt) && (localObject3 != null) && (this.map.keyEquivalence.equivalent(paramK, localObject3)))
          if (((CustomConcurrentHashMap.ReferenceEntry)localObject2).getValueReference() == paramValueReference)
          {
            this.modCount = (1 + this.modCount);
            a(paramK, paramInt, paramValueReference.get(), MapMaker.RemovalCause.COLLECTED);
            CustomConcurrentHashMap.ReferenceEntry localReferenceEntry3 = b(localReferenceEntry1, (CustomConcurrentHashMap.ReferenceEntry)localObject2);
            int j = -1 + this.count;
            localAtomicReferenceArray.set(i, localReferenceEntry3);
            this.count = j;
            bool = true;
          }
      }
      while (true)
      {
        return bool;
        unlock();
        if (!isHeldByCurrentThread())
          p();
        bool = false;
        continue;
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getNext();
        localObject2 = localReferenceEntry2;
        break;
        unlock();
        if (!isHeldByCurrentThread())
          p();
        bool = false;
      }
    }
    finally
    {
      unlock();
      if (!isHeldByCurrentThread())
        p();
    }
  }

  boolean a(K paramK, int paramInt, V paramV1, V paramV2)
  {
    lock();
    try
    {
      o();
      AtomicReferenceArray localAtomicReferenceArray = this.table;
      int i = paramInt & -1 + localAtomicReferenceArray.length();
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(i);
      Object localObject2 = localReferenceEntry1;
      Object localObject4;
      boolean bool;
      if (localObject2 != null)
      {
        Object localObject3 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getKey();
        if ((((CustomConcurrentHashMap.ReferenceEntry)localObject2).getHash() == paramInt) && (localObject3 != null) && (this.map.keyEquivalence.equivalent(paramK, localObject3)))
        {
          CustomConcurrentHashMap.ValueReference localValueReference = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getValueReference();
          localObject4 = localValueReference.get();
          if (localObject4 == null)
          {
            if (a(localValueReference))
            {
              (-1 + this.count);
              this.modCount = (1 + this.modCount);
              a(localObject3, paramInt, localObject4, MapMaker.RemovalCause.COLLECTED);
              CustomConcurrentHashMap.ReferenceEntry localReferenceEntry3 = b(localReferenceEntry1, (CustomConcurrentHashMap.ReferenceEntry)localObject2);
              int j = -1 + this.count;
              localAtomicReferenceArray.set(i, localReferenceEntry3);
              this.count = j;
            }
            unlock();
            p();
            bool = false;
          }
        }
      }
      while (true)
      {
        return bool;
        if (this.map.valueEquivalence.equivalent(paramV1, localObject4))
        {
          this.modCount = (1 + this.modCount);
          a(paramK, paramInt, localObject4, MapMaker.RemovalCause.REPLACED);
          a((CustomConcurrentHashMap.ReferenceEntry)localObject2, paramV2);
          bool = true;
          unlock();
          p();
        }
        else
        {
          b((CustomConcurrentHashMap.ReferenceEntry)localObject2);
          unlock();
          p();
          bool = false;
          continue;
          CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getNext();
          localObject2 = localReferenceEntry2;
          break;
          unlock();
          p();
          bool = false;
        }
      }
    }
    finally
    {
      unlock();
      p();
    }
  }

  CustomConcurrentHashMap.ReferenceEntry<K, V> b(int paramInt)
  {
    AtomicReferenceArray localAtomicReferenceArray = this.table;
    return (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(paramInt & -1 + localAtomicReferenceArray.length());
  }

  CustomConcurrentHashMap.ReferenceEntry<K, V> b(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry1, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry2)
  {
    this.evictionQueue.remove(paramReferenceEntry2);
    this.expirationQueue.remove(paramReferenceEntry2);
    int i = this.count;
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = paramReferenceEntry2.getNext();
    if (paramReferenceEntry1 != paramReferenceEntry2)
    {
      if (e(paramReferenceEntry1))
      {
        d(paramReferenceEntry1);
        i--;
      }
      while (true)
      {
        paramReferenceEntry1 = paramReferenceEntry1.getNext();
        break;
        localReferenceEntry = a(paramReferenceEntry1, localReferenceEntry);
      }
    }
    this.count = i;
    return localReferenceEntry;
  }

  CustomConcurrentHashMap.ReferenceEntry<K, V> b(Object paramObject, int paramInt)
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = a(paramObject, paramInt);
    Object localObject = null;
    if (localReferenceEntry == null);
    while (true)
    {
      return localObject;
      if ((this.map.b()) && (this.map.c(localReferenceEntry)))
      {
        i();
        localObject = null;
      }
      else
      {
        localObject = localReferenceEntry;
      }
    }
  }

  void b()
  {
    if (this.map.e())
      c();
    if (this.map.f())
      d();
  }

  void b(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.evictionQueue.add(paramReferenceEntry);
    if (this.map.d())
    {
      a(paramReferenceEntry, this.map.expireAfterAccessNanos);
      this.expirationQueue.add(paramReferenceEntry);
    }
  }

  boolean b(K paramK, int paramInt, CustomConcurrentHashMap.ValueReference<K, V> paramValueReference)
  {
    lock();
    try
    {
      AtomicReferenceArray localAtomicReferenceArray = this.table;
      int i = paramInt & -1 + localAtomicReferenceArray.length();
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(i);
      Object localObject2 = localReferenceEntry1;
      boolean bool;
      if (localObject2 != null)
      {
        Object localObject3 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getKey();
        if ((((CustomConcurrentHashMap.ReferenceEntry)localObject2).getHash() == paramInt) && (localObject3 != null) && (this.map.keyEquivalence.equivalent(paramK, localObject3)))
          if (((CustomConcurrentHashMap.ReferenceEntry)localObject2).getValueReference() == paramValueReference)
          {
            localAtomicReferenceArray.set(i, b(localReferenceEntry1, (CustomConcurrentHashMap.ReferenceEntry)localObject2));
            bool = true;
          }
      }
      while (true)
      {
        return bool;
        unlock();
        p();
        bool = false;
        continue;
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getNext();
        localObject2 = localReferenceEntry2;
        break;
        unlock();
        p();
        bool = false;
      }
    }
    finally
    {
      unlock();
      p();
    }
  }

  boolean b(Object paramObject1, int paramInt, Object paramObject2)
  {
    lock();
    try
    {
      o();
      (-1 + this.count);
      AtomicReferenceArray localAtomicReferenceArray = this.table;
      int i = paramInt & -1 + localAtomicReferenceArray.length();
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(i);
      Object localObject2 = localReferenceEntry1;
      CustomConcurrentHashMap.ValueReference localValueReference;
      MapMaker.RemovalCause localRemovalCause1;
      label133: boolean bool2;
      label202: boolean bool1;
      if (localObject2 != null)
      {
        Object localObject3 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getKey();
        if ((((CustomConcurrentHashMap.ReferenceEntry)localObject2).getHash() == paramInt) && (localObject3 != null) && (this.map.keyEquivalence.equivalent(paramObject1, localObject3)))
        {
          localValueReference = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getValueReference();
          Object localObject4 = localValueReference.get();
          if (this.map.valueEquivalence.equivalent(paramObject2, localObject4))
          {
            localRemovalCause1 = MapMaker.RemovalCause.EXPLICIT;
            this.modCount = (1 + this.modCount);
            a(localObject3, paramInt, localObject4, localRemovalCause1);
            CustomConcurrentHashMap.ReferenceEntry localReferenceEntry3 = b(localReferenceEntry1, (CustomConcurrentHashMap.ReferenceEntry)localObject2);
            int j = -1 + this.count;
            localAtomicReferenceArray.set(i, localReferenceEntry3);
            this.count = j;
            MapMaker.RemovalCause localRemovalCause2 = MapMaker.RemovalCause.EXPLICIT;
            if (localRemovalCause1 != localRemovalCause2)
              break label248;
            bool2 = true;
            unlock();
            p();
            bool1 = bool2;
          }
        }
      }
      while (true)
      {
        return bool1;
        if (a(localValueReference))
        {
          localRemovalCause1 = MapMaker.RemovalCause.COLLECTED;
          break label133;
        }
        unlock();
        p();
        bool1 = false;
        continue;
        label248: bool2 = false;
        break label202;
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getNext();
        localObject2 = localReferenceEntry2;
        break;
        unlock();
        p();
        bool1 = false;
      }
    }
    finally
    {
      unlock();
      p();
    }
  }

  V c(Object paramObject, int paramInt)
  {
    try
    {
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = b(paramObject, paramInt);
      if (localReferenceEntry == null)
      {
        localObject2 = null;
        return localObject2;
      }
      Object localObject2 = localReferenceEntry.getValueReference().get();
      if (localObject2 != null)
        a(localReferenceEntry);
      while (true)
      {
        n();
        break;
        a();
      }
    }
    finally
    {
      n();
    }
  }

  void c()
  {
    int j;
    for (int i = 0; ; i = j)
    {
      Reference localReference = this.keyReferenceQueue.poll();
      if (localReference != null)
      {
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = (CustomConcurrentHashMap.ReferenceEntry)localReference;
        this.map.a(localReferenceEntry);
        j = i + 1;
        if (j != 16);
      }
      else
      {
        return;
      }
    }
  }

  void c(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    h();
    this.evictionQueue.add(paramReferenceEntry);
    if (this.map.b())
      if (!this.map.d())
        break label61;
    label61: for (long l = this.map.expireAfterAccessNanos; ; l = this.map.expireAfterWriteNanos)
    {
      a(paramReferenceEntry, l);
      this.expirationQueue.add(paramReferenceEntry);
      return;
    }
  }

  void d()
  {
    int j;
    for (int i = 0; ; i = j)
    {
      Reference localReference = this.valueReferenceQueue.poll();
      if (localReference != null)
      {
        CustomConcurrentHashMap.ValueReference localValueReference = (CustomConcurrentHashMap.ValueReference)localReference;
        this.map.a(localValueReference);
        j = i + 1;
        if (j != 16);
      }
      else
      {
        return;
      }
    }
  }

  void d(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    a(paramReferenceEntry, MapMaker.RemovalCause.COLLECTED);
    this.evictionQueue.remove(paramReferenceEntry);
    this.expirationQueue.remove(paramReferenceEntry);
  }

  boolean d(Object paramObject, int paramInt)
  {
    boolean bool = false;
    try
    {
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry;
      if (this.count != 0)
      {
        localReferenceEntry = b(paramObject, paramInt);
        if (localReferenceEntry != null);
      }
      while (true)
      {
        return bool;
        Object localObject2 = localReferenceEntry.getValueReference().get();
        bool = false;
        if (localObject2 != null)
          bool = true;
        n();
        continue;
        n();
        bool = false;
      }
    }
    finally
    {
      n();
    }
  }

  V e(Object paramObject, int paramInt)
  {
    lock();
    try
    {
      o();
      (-1 + this.count);
      AtomicReferenceArray localAtomicReferenceArray = this.table;
      int i = paramInt & -1 + localAtomicReferenceArray.length();
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(i);
      Object localObject2 = localReferenceEntry1;
      CustomConcurrentHashMap.ValueReference localValueReference;
      MapMaker.RemovalCause localRemovalCause;
      label122: Object localObject3;
      if (localObject2 != null)
      {
        Object localObject4 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getKey();
        if ((((CustomConcurrentHashMap.ReferenceEntry)localObject2).getHash() == paramInt) && (localObject4 != null) && (this.map.keyEquivalence.equivalent(paramObject, localObject4)))
        {
          localValueReference = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getValueReference();
          Object localObject5 = localValueReference.get();
          if (localObject5 != null)
          {
            localRemovalCause = MapMaker.RemovalCause.EXPLICIT;
            this.modCount = (1 + this.modCount);
            a(localObject4, paramInt, localObject5, localRemovalCause);
            CustomConcurrentHashMap.ReferenceEntry localReferenceEntry3 = b(localReferenceEntry1, (CustomConcurrentHashMap.ReferenceEntry)localObject2);
            int j = -1 + this.count;
            localAtomicReferenceArray.set(i, localReferenceEntry3);
            this.count = j;
            unlock();
            p();
            localObject3 = localObject5;
          }
        }
      }
      while (true)
      {
        return localObject3;
        if (a(localValueReference))
        {
          localRemovalCause = MapMaker.RemovalCause.COLLECTED;
          break label122;
        }
        unlock();
        p();
        localObject3 = null;
        continue;
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2 = ((CustomConcurrentHashMap.ReferenceEntry)localObject2).getNext();
        localObject2 = localReferenceEntry2;
        break;
        unlock();
        p();
        localObject3 = null;
      }
    }
    finally
    {
      unlock();
      p();
    }
  }

  void e()
  {
    if (this.map.e())
      f();
    if (this.map.f())
      g();
  }

  boolean e(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    if (paramReferenceEntry.getKey() == null);
    for (boolean bool = true; ; bool = a(paramReferenceEntry.getValueReference()))
      return bool;
  }

  V f(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    Object localObject1 = null;
    if (paramReferenceEntry.getKey() == null)
      a();
    while (true)
    {
      return localObject1;
      Object localObject2 = paramReferenceEntry.getValueReference().get();
      if (localObject2 == null)
      {
        a();
        localObject1 = null;
      }
      else if ((this.map.b()) && (this.map.c(paramReferenceEntry)))
      {
        i();
        localObject1 = null;
      }
      else
      {
        localObject1 = localObject2;
      }
    }
  }

  void f()
  {
    while (this.keyReferenceQueue.poll() != null);
  }

  void g()
  {
    while (this.valueReferenceQueue.poll() != null);
  }

  void h()
  {
    while (true)
    {
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = (CustomConcurrentHashMap.ReferenceEntry)this.recencyQueue.poll();
      if (localReferenceEntry == null)
        break;
      if (this.evictionQueue.contains(localReferenceEntry))
        this.evictionQueue.add(localReferenceEntry);
      if ((this.map.d()) && (this.expirationQueue.contains(localReferenceEntry)))
        this.expirationQueue.add(localReferenceEntry);
    }
  }

  void i()
  {
    if (tryLock());
    try
    {
      j();
      return;
    }
    finally
    {
      unlock();
    }
  }

  void j()
  {
    h();
    if (this.expirationQueue.isEmpty())
      return;
    long l = this.map.ticker.read();
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry;
    do
    {
      localReferenceEntry = (CustomConcurrentHashMap.ReferenceEntry)this.expirationQueue.peek();
      if ((localReferenceEntry == null) || (!this.map.a(localReferenceEntry, l)))
        break;
    }
    while (a(localReferenceEntry, localReferenceEntry.getHash(), MapMaker.RemovalCause.EXPIRED));
    throw new AssertionError();
  }

  boolean k()
  {
    if ((this.map.a()) && (this.count >= this.maxSegmentSize))
    {
      h();
      CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = (CustomConcurrentHashMap.ReferenceEntry)this.evictionQueue.remove();
      if (!a(localReferenceEntry, localReferenceEntry.getHash(), MapMaker.RemovalCause.SIZE))
        throw new AssertionError();
    }
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  void l()
  {
    AtomicReferenceArray localAtomicReferenceArray1 = this.table;
    int i = localAtomicReferenceArray1.length();
    if (i >= 1073741824)
      return;
    int j = this.count;
    AtomicReferenceArray localAtomicReferenceArray2 = a(i << 1);
    this.threshold = (3 * localAtomicReferenceArray2.length() / 4);
    int k = -1 + localAtomicReferenceArray2.length();
    int m = 0;
    label57: CustomConcurrentHashMap.ReferenceEntry localReferenceEntry1;
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry2;
    int i1;
    int n;
    if (m < i)
    {
      localReferenceEntry1 = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray1.get(m);
      if (localReferenceEntry1 == null)
        break label305;
      localReferenceEntry2 = localReferenceEntry1.getNext();
      i1 = k & localReferenceEntry1.getHash();
      if (localReferenceEntry2 == null)
      {
        localAtomicReferenceArray2.set(i1, localReferenceEntry1);
        n = j;
      }
    }
    while (true)
    {
      m++;
      j = n;
      break label57;
      Object localObject1 = localReferenceEntry1;
      label130: int i4;
      if (localReferenceEntry2 != null)
      {
        i4 = k & localReferenceEntry2.getHash();
        if (i4 == i1)
          break label294;
      }
      for (Object localObject2 = localReferenceEntry2; ; localObject2 = localObject1)
      {
        localReferenceEntry2 = localReferenceEntry2.getNext();
        localObject1 = localObject2;
        i1 = i4;
        break label130;
        localAtomicReferenceArray2.set(i1, localObject1);
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry3 = localReferenceEntry1;
        n = j;
        label194: if (localReferenceEntry3 != localObject1)
        {
          if (!e(localReferenceEntry3))
            break label238;
          d(localReferenceEntry3);
        }
        for (int i3 = n - 1; ; i3 = n)
        {
          localReferenceEntry3 = localReferenceEntry3.getNext();
          n = i3;
          break label194;
          break;
          label238: int i2 = k & localReferenceEntry3.getHash();
          localAtomicReferenceArray2.set(i2, a(localReferenceEntry3, (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray2.get(i2)));
        }
        this.table = localAtomicReferenceArray2;
        this.count = j;
        break;
        label294: i4 = i1;
      }
      label305: n = j;
    }
  }

  void m()
  {
    if (this.count != 0)
      lock();
    while (true)
    {
      int j;
      try
      {
        AtomicReferenceArray localAtomicReferenceArray = this.table;
        if (this.map.removalNotificationQueue == CustomConcurrentHashMap.f)
          break label184;
        j = 0;
        if (j >= localAtomicReferenceArray.length())
          break label184;
        CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(j);
        if (localReferenceEntry != null)
        {
          if (!localReferenceEntry.getValueReference().b())
            a(localReferenceEntry, MapMaker.RemovalCause.EXPLICIT);
          localReferenceEntry = localReferenceEntry.getNext();
          continue;
          if (i < localAtomicReferenceArray.length())
          {
            localAtomicReferenceArray.set(i, null);
            i++;
            continue;
          }
          e();
          this.evictionQueue.clear();
          this.expirationQueue.clear();
          this.readCount.set(0);
          this.modCount = (1 + this.modCount);
          this.count = 0;
          return;
        }
      }
      finally
      {
        unlock();
        p();
      }
      j++;
      continue;
      label184: int i = 0;
    }
  }

  void n()
  {
    if ((0x3F & this.readCount.incrementAndGet()) == 0)
      q();
  }

  void o()
  {
    r();
  }

  void p()
  {
    s();
  }

  void q()
  {
    r();
    s();
  }

  void r()
  {
    if (tryLock());
    try
    {
      b();
      j();
      this.readCount.set(0);
      return;
    }
    finally
    {
      unlock();
    }
  }

  void s()
  {
    if (!isHeldByCurrentThread())
      this.map.j();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap.Segment
 * JD-Core Version:    0.6.2
 */