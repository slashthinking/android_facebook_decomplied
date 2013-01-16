package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.logging.Level;
import java.util.logging.Logger;

class CustomConcurrentHashMap<K, V> extends AbstractMap<K, V>
  implements Serializable, ConcurrentMap<K, V>
{
  static final CustomConcurrentHashMap.ValueReference<Object, Object> e = new CustomConcurrentHashMap.1();
  static final Queue<? extends Object> f = new CustomConcurrentHashMap.2();
  private static final Logger g = Logger.getLogger(CustomConcurrentHashMap.class.getName());
  private static final long serialVersionUID = 5L;
  final transient int a;
  final transient int b;
  final transient CustomConcurrentHashMap.Segment<K, V>[] c;
  final int concurrencyLevel;
  final transient CustomConcurrentHashMap.EntryFactory d;
  Set<Map.Entry<K, V>> entrySet;
  final long expireAfterAccessNanos;
  final long expireAfterWriteNanos;
  final Equivalence<Object> keyEquivalence;
  Set<K> keySet;
  final CustomConcurrentHashMap.Strength keyStrength;
  final int maximumSize;
  final MapMaker.RemovalListener<K, V> removalListener;
  final Queue<MapMaker.RemovalNotification<K, V>> removalNotificationQueue;
  final Ticker ticker;
  final Equivalence<Object> valueEquivalence;
  final CustomConcurrentHashMap.Strength valueStrength;
  Collection<V> values;

  CustomConcurrentHashMap(MapMaker paramMapMaker)
  {
    this.concurrencyLevel = Math.min(paramMapMaker.e(), 65536);
    this.keyStrength = paramMapMaker.g();
    this.valueStrength = paramMapMaker.j();
    this.keyEquivalence = paramMapMaker.b();
    this.valueEquivalence = paramMapMaker.c();
    this.maximumSize = paramMapMaker.e;
    this.expireAfterAccessNanos = paramMapMaker.l();
    this.expireAfterWriteNanos = paramMapMaker.k();
    this.d = CustomConcurrentHashMap.EntryFactory.getFactory(this.keyStrength, b(), a());
    this.ticker = paramMapMaker.m();
    this.removalListener = paramMapMaker.a();
    if (this.removalListener == GenericMapMaker.NullListener.INSTANCE);
    int j;
    int k;
    int m;
    for (Object localObject = i(); ; localObject = new ConcurrentLinkedQueue())
    {
      this.removalNotificationQueue = ((Queue)localObject);
      j = Math.min(paramMapMaker.d(), 1073741824);
      if (a())
        j = Math.min(j, this.maximumSize);
      k = i;
      m = 0;
      while ((k < this.concurrencyLevel) && ((!a()) || (k * 2 <= this.maximumSize)))
      {
        m++;
        k <<= 1;
      }
    }
    this.b = (32 - m);
    this.a = (k - 1);
    this.c = d(k);
    int n = j / k;
    int i1;
    if (n * k < j)
      i1 = n + 1;
    while (true)
      if (i < i1)
      {
        i <<= 1;
      }
      else
      {
        boolean bool = a();
        int i2 = 0;
        if (bool)
        {
          int i3 = 1 + this.maximumSize / k;
          int i4 = this.maximumSize % k;
          while (i2 < this.c.length)
          {
            if (i2 == i4)
              i3--;
            this.c[i2] = a(i, i3);
            i2++;
          }
        }
        while (i2 < this.c.length)
        {
          this.c[i2] = a(i, -1);
          i2++;
        }
        return;
        i1 = n;
      }
  }

  static <K, V> void a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry1, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry2)
  {
    paramReferenceEntry1.setNextExpirable(paramReferenceEntry2);
    paramReferenceEntry2.setPreviousExpirable(paramReferenceEntry1);
  }

  static <K, V> void b(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry1, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry2)
  {
    paramReferenceEntry1.setNextEvictable(paramReferenceEntry2);
    paramReferenceEntry2.setPreviousEvictable(paramReferenceEntry1);
  }

  static int c(int paramInt)
  {
    int i = paramInt + (0xFFFFCD7D ^ paramInt << 15);
    int j = i ^ i >>> 10;
    int k = j + (j << 3);
    int m = k ^ k >>> 6;
    int n = m + ((m << 2) + (m << 14));
    return n ^ n >>> 16;
  }

  static <K, V> void d(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = h();
    paramReferenceEntry.setNextExpirable(localReferenceEntry);
    paramReferenceEntry.setPreviousExpirable(localReferenceEntry);
  }

  static <K, V> void e(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = h();
    paramReferenceEntry.setNextEvictable(localReferenceEntry);
    paramReferenceEntry.setPreviousEvictable(localReferenceEntry);
  }

  static <K, V> CustomConcurrentHashMap.ValueReference<K, V> g()
  {
    return e;
  }

  static <K, V> CustomConcurrentHashMap.ReferenceEntry<K, V> h()
  {
    return CustomConcurrentHashMap.NullEntry.INSTANCE;
  }

  static <E> Queue<E> i()
  {
    return f;
  }

  CustomConcurrentHashMap.Segment<K, V> a(int paramInt1, int paramInt2)
  {
    return new CustomConcurrentHashMap.Segment(this, paramInt1, paramInt2);
  }

  void a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    int i = paramReferenceEntry.getHash();
    b(i).a(paramReferenceEntry, i);
  }

  void a(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference)
  {
    CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = paramValueReference.a();
    int i = localReferenceEntry.getHash();
    b(i).a(localReferenceEntry.getKey(), i, paramValueReference);
  }

  boolean a()
  {
    if (this.maximumSize != -1);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean a(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry, long paramLong)
  {
    if (paramLong - paramReferenceEntry.getExpirationTime() > 0L);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  int b(Object paramObject)
  {
    return c(this.keyEquivalence.hash(paramObject));
  }

  CustomConcurrentHashMap.Segment<K, V> b(int paramInt)
  {
    return this.c[(paramInt >>> this.b & this.a)];
  }

  V b(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    Object localObject1 = paramReferenceEntry.getKey();
    Object localObject2 = null;
    if (localObject1 == null);
    while (true)
    {
      return localObject2;
      Object localObject3 = paramReferenceEntry.getValueReference().get();
      localObject2 = null;
      if (localObject3 != null)
        if (b())
        {
          boolean bool = c(paramReferenceEntry);
          localObject2 = null;
          if (bool);
        }
        else
        {
          localObject2 = localObject3;
        }
    }
  }

  boolean b()
  {
    if ((c()) || (d()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean c()
  {
    if (this.expireAfterWriteNanos > 0L);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean c(CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return a(paramReferenceEntry, this.ticker.read());
  }

  public void clear()
  {
    CustomConcurrentHashMap.Segment[] arrayOfSegment = this.c;
    int i = arrayOfSegment.length;
    for (int j = 0; j < i; j++)
      arrayOfSegment[j].m();
  }

  public boolean containsKey(Object paramObject)
  {
    if (paramObject == null);
    int i;
    for (boolean bool = false; ; bool = b(i).d(paramObject, i))
    {
      return bool;
      i = b(paramObject);
    }
  }

  public boolean containsValue(Object paramObject)
  {
    boolean bool;
    if (paramObject == null)
    {
      bool = false;
      return bool;
    }
    CustomConcurrentHashMap.Segment[] arrayOfSegment = this.c;
    int i = 0;
    long l2;
    for (long l1 = -1L; ; l1 = l2)
    {
      if (i < 3)
      {
        int j = arrayOfSegment.length;
        l2 = 0L;
        for (int k = 0; ; k++)
        {
          if (k >= j)
            break label161;
          CustomConcurrentHashMap.Segment localSegment = arrayOfSegment[k];
          AtomicReferenceArray localAtomicReferenceArray = localSegment.table;
          label138: for (int m = 0; ; m++)
          {
            if (m >= localAtomicReferenceArray.length())
              break label144;
            for (CustomConcurrentHashMap.ReferenceEntry localReferenceEntry = (CustomConcurrentHashMap.ReferenceEntry)localAtomicReferenceArray.get(m); ; localReferenceEntry = localReferenceEntry.getNext())
            {
              if (localReferenceEntry == null)
                break label138;
              Object localObject = localSegment.f(localReferenceEntry);
              if ((localObject != null) && (this.valueEquivalence.equivalent(paramObject, localObject)))
              {
                bool = true;
                break;
              }
            }
          }
          label144: l2 += localSegment.modCount;
        }
        label161: if (l2 != l1);
      }
      else
      {
        bool = false;
        break;
      }
      i++;
    }
  }

  boolean d()
  {
    if (this.expireAfterAccessNanos > 0L);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  final CustomConcurrentHashMap.Segment<K, V>[] d(int paramInt)
  {
    return new CustomConcurrentHashMap.Segment[paramInt];
  }

  boolean e()
  {
    if (this.keyStrength != CustomConcurrentHashMap.Strength.STRONG);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    Object localObject = this.entrySet;
    if (localObject != null);
    while (true)
    {
      return localObject;
      localObject = new CustomConcurrentHashMap.EntrySet(this);
      this.entrySet = ((Set)localObject);
    }
  }

  boolean f()
  {
    if (this.valueStrength != CustomConcurrentHashMap.Strength.STRONG);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public V get(Object paramObject)
  {
    if (paramObject == null);
    int i;
    for (Object localObject = null; ; localObject = b(i).c(paramObject, i))
    {
      return localObject;
      i = b(paramObject);
    }
  }

  public boolean isEmpty()
  {
    CustomConcurrentHashMap.Segment[] arrayOfSegment = this.c;
    int i = 0;
    long l = 0L;
    boolean bool1;
    if (i < arrayOfSegment.length)
    {
      int m = arrayOfSegment[i].count;
      bool1 = false;
      if (m == 0);
    }
    while (true)
    {
      return bool1;
      l += arrayOfSegment[i].modCount;
      i++;
      break;
      if (l != 0L)
      {
        for (int j = 0; ; j++)
        {
          if (j >= arrayOfSegment.length)
            break label100;
          int k = arrayOfSegment[j].count;
          bool1 = false;
          if (k != 0)
            break;
          l -= arrayOfSegment[j].modCount;
        }
        label100: boolean bool2 = l < 0L;
        bool1 = false;
        if (bool2);
      }
      else
      {
        bool1 = true;
      }
    }
  }

  void j()
  {
    while (true)
    {
      MapMaker.RemovalNotification localRemovalNotification = (MapMaker.RemovalNotification)this.removalNotificationQueue.poll();
      if (localRemovalNotification == null)
        break;
      try
      {
        this.removalListener.onRemoval(localRemovalNotification);
      }
      catch (Exception localException)
      {
        g.log(Level.WARNING, "Exception thrown by removal listener", localException);
      }
    }
  }

  public Set<K> keySet()
  {
    Object localObject = this.keySet;
    if (localObject != null);
    while (true)
    {
      return localObject;
      localObject = new CustomConcurrentHashMap.KeySet(this);
      this.keySet = ((Set)localObject);
    }
  }

  public V put(K paramK, V paramV)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    int i = b(paramK);
    return b(i).a(paramK, i, paramV, false);
  }

  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }

  public V putIfAbsent(K paramK, V paramV)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    int i = b(paramK);
    return b(i).a(paramK, i, paramV, true);
  }

  public V remove(Object paramObject)
  {
    if (paramObject == null);
    int i;
    for (Object localObject = null; ; localObject = b(i).e(paramObject, i))
    {
      return localObject;
      i = b(paramObject);
    }
  }

  public boolean remove(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null));
    int i;
    for (boolean bool = false; ; bool = b(i).b(paramObject1, i, paramObject2))
    {
      return bool;
      i = b(paramObject1);
    }
  }

  public V replace(K paramK, V paramV)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    int i = b(paramK);
    return b(i).a(paramK, i, paramV);
  }

  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV2);
    if (paramV1 == null);
    int i;
    for (boolean bool = false; ; bool = b(i).a(paramK, i, paramV1, paramV2))
    {
      return bool;
      i = b(paramK);
    }
  }

  public int size()
  {
    CustomConcurrentHashMap.Segment[] arrayOfSegment = this.c;
    long l = 0L;
    for (int i = 0; i < arrayOfSegment.length; i++)
      l += arrayOfSegment[i].count;
    return Ints.b(l);
  }

  public Collection<V> values()
  {
    Object localObject = this.values;
    if (localObject != null);
    while (true)
    {
      return localObject;
      localObject = new CustomConcurrentHashMap.Values(this);
      this.values = ((Collection)localObject);
    }
  }

  Object writeReplace()
  {
    return new CustomConcurrentHashMap.SerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.CustomConcurrentHashMap
 * JD-Core Version:    0.6.2
 */