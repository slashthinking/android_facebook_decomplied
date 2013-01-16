package com.google.common.collect;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public final class MapMaker extends GenericMapMaker<Object, Object>
{
  boolean b;
  int c = -1;
  int d = -1;
  int e = -1;
  CustomConcurrentHashMap.Strength f;
  CustomConcurrentHashMap.Strength g;
  long h = -1L;
  long i = -1L;
  MapMaker.RemovalCause j;
  Equivalence<Object> k;
  Equivalence<Object> l;
  Ticker m;

  private void d(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool1;
    boolean bool2;
    if (this.h == -1L)
    {
      bool1 = true;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Long.valueOf(this.h);
      Preconditions.checkState(bool1, "expireAfterWrite was already set to %s ns", arrayOfObject1);
      if (this.i != -1L)
        break label124;
      bool2 = true;
      label54: Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Long.valueOf(this.i);
      Preconditions.checkState(bool2, "expireAfterAccess was already set to %s ns", arrayOfObject2);
      if (paramLong < 0L)
        break label130;
    }
    label130: for (boolean bool3 = true; ; bool3 = false)
    {
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = Long.valueOf(paramLong);
      arrayOfObject3[1] = paramTimeUnit;
      Preconditions.checkArgument(bool3, "duration cannot be negative: %s %s", arrayOfObject3);
      return;
      bool1 = false;
      break;
      label124: bool2 = false;
      break label54;
    }
  }

  private boolean o()
  {
    if (this.j == null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  <K, V> GenericMapMaker<K, V> a(MapMaker.RemovalListener<K, V> paramRemovalListener)
  {
    if (this.a == null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool);
      this.a = ((MapMaker.RemovalListener)Preconditions.checkNotNull(paramRemovalListener));
      this.b = true;
      return this;
    }
  }

  public MapMaker a(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.c == -1)
    {
      bool2 = bool1;
      Object[] arrayOfObject = new Object[bool1];
      arrayOfObject[0] = Integer.valueOf(this.c);
      Preconditions.checkState(bool2, "initial capacity was already set to %s", arrayOfObject);
      if (paramInt < 0)
        break label57;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      this.c = paramInt;
      return this;
      bool2 = false;
      break;
      label57: bool1 = false;
    }
  }

  @Deprecated
  public MapMaker a(long paramLong, TimeUnit paramTimeUnit)
  {
    return b(paramLong, paramTimeUnit);
  }

  MapMaker a(Equivalence<Object> paramEquivalence)
  {
    if (this.k == null);
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.k;
      Preconditions.checkState(bool, "key equivalence was already set to %s", arrayOfObject);
      this.k = ((Equivalence)Preconditions.checkNotNull(paramEquivalence));
      this.b = true;
      return this;
    }
  }

  MapMaker a(CustomConcurrentHashMap.Strength paramStrength)
  {
    if (this.f == null);
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.f;
      Preconditions.checkState(bool, "Key strength was already set to %s", arrayOfObject);
      this.f = ((CustomConcurrentHashMap.Strength)Preconditions.checkNotNull(paramStrength));
      if (paramStrength != CustomConcurrentHashMap.Strength.STRONG)
        this.b = true;
      return this;
    }
  }

  @Deprecated
  public <K, V> ConcurrentMap<K, V> a(Function<? super K, ? extends V> paramFunction)
  {
    if (o());
    for (Object localObject = new ComputingConcurrentHashMap.ComputingMapAdapter(this, paramFunction); ; localObject = new MapMaker.NullComputingConcurrentMap(this, paramFunction))
      return (ConcurrentMap)localObject;
  }

  Equivalence<Object> b()
  {
    return (Equivalence)Objects.firstNonNull(this.k, g().defaultEquivalence());
  }

  @Deprecated
  public MapMaker b(int paramInt)
  {
    if (this.e == -1);
    for (boolean bool1 = true; ; bool1 = false)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.e);
      Preconditions.checkState(bool1, "maximum size was already set to %s", arrayOfObject);
      boolean bool2 = false;
      if (paramInt >= 0)
        bool2 = true;
      Preconditions.checkArgument(bool2, "maximum size must not be negative");
      this.e = paramInt;
      this.b = true;
      if (this.e == 0)
        this.j = MapMaker.RemovalCause.SIZE;
      return this;
    }
  }

  @Deprecated
  public MapMaker b(long paramLong, TimeUnit paramTimeUnit)
  {
    d(paramLong, paramTimeUnit);
    this.h = paramTimeUnit.toNanos(paramLong);
    if ((paramLong == 0L) && (this.j == null))
      this.j = MapMaker.RemovalCause.EXPIRED;
    this.b = true;
    return this;
  }

  MapMaker b(Equivalence<Object> paramEquivalence)
  {
    if (this.l == null);
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.l;
      Preconditions.checkState(bool, "value equivalence was already set to %s", arrayOfObject);
      this.l = ((Equivalence)Preconditions.checkNotNull(paramEquivalence));
      this.b = true;
      return this;
    }
  }

  MapMaker b(CustomConcurrentHashMap.Strength paramStrength)
  {
    if (this.g == null);
    for (boolean bool = true; ; bool = false)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.g;
      Preconditions.checkState(bool, "Value strength was already set to %s", arrayOfObject);
      this.g = ((CustomConcurrentHashMap.Strength)Preconditions.checkNotNull(paramStrength));
      if (paramStrength != CustomConcurrentHashMap.Strength.STRONG)
        this.b = true;
      return this;
    }
  }

  Equivalence<Object> c()
  {
    return (Equivalence)Objects.firstNonNull(this.l, j().defaultEquivalence());
  }

  public MapMaker c(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.d == -1)
    {
      bool2 = bool1;
      Object[] arrayOfObject = new Object[bool1];
      arrayOfObject[0] = Integer.valueOf(this.d);
      Preconditions.checkState(bool2, "concurrency level was already set to %s", arrayOfObject);
      if (paramInt <= 0)
        break label57;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      this.d = paramInt;
      return this;
      bool2 = false;
      break;
      label57: bool1 = false;
    }
  }

  @Deprecated
  public MapMaker c(long paramLong, TimeUnit paramTimeUnit)
  {
    d(paramLong, paramTimeUnit);
    this.i = paramTimeUnit.toNanos(paramLong);
    if ((paramLong == 0L) && (this.j == null))
      this.j = MapMaker.RemovalCause.EXPIRED;
    this.b = true;
    return this;
  }

  int d()
  {
    if (this.c == -1);
    for (int n = 16; ; n = this.c)
      return n;
  }

  int e()
  {
    if (this.d == -1);
    for (int n = 4; ; n = this.d)
      return n;
  }

  public MapMaker f()
  {
    return a(CustomConcurrentHashMap.Strength.WEAK);
  }

  CustomConcurrentHashMap.Strength g()
  {
    return (CustomConcurrentHashMap.Strength)Objects.firstNonNull(this.f, CustomConcurrentHashMap.Strength.STRONG);
  }

  public MapMaker h()
  {
    return b(CustomConcurrentHashMap.Strength.WEAK);
  }

  public MapMaker i()
  {
    return b(CustomConcurrentHashMap.Strength.SOFT);
  }

  CustomConcurrentHashMap.Strength j()
  {
    return (CustomConcurrentHashMap.Strength)Objects.firstNonNull(this.g, CustomConcurrentHashMap.Strength.STRONG);
  }

  long k()
  {
    if (this.h == -1L);
    for (long l1 = 0L; ; l1 = this.h)
      return l1;
  }

  long l()
  {
    if (this.i == -1L);
    for (long l1 = 0L; ; l1 = this.i)
      return l1;
  }

  Ticker m()
  {
    return (Ticker)Objects.firstNonNull(this.m, Ticker.systemTicker());
  }

  public <K, V> ConcurrentMap<K, V> n()
  {
    Object localObject1;
    if (!this.b)
    {
      localObject1 = new ConcurrentHashMap(d(), 0.75F, e());
      return localObject1;
    }
    if (this.j == null);
    for (Object localObject2 = new CustomConcurrentHashMap(this); ; localObject2 = new MapMaker.NullConcurrentMap(this))
    {
      localObject1 = (ConcurrentMap)localObject2;
      break;
    }
  }

  public String toString()
  {
    Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this);
    if (this.c != -1)
      localToStringHelper.add("initialCapacity", Integer.valueOf(this.c));
    if (this.d != -1)
      localToStringHelper.add("concurrencyLevel", Integer.valueOf(this.d));
    if (this.e != -1)
      localToStringHelper.add("maximumSize", Integer.valueOf(this.e));
    if (this.h != -1L)
      localToStringHelper.add("expireAfterWrite", this.h + "ns");
    if (this.i != -1L)
      localToStringHelper.add("expireAfterAccess", this.i + "ns");
    if (this.f != null)
      localToStringHelper.add("keyStrength", Ascii.toLowerCase(this.f.toString()));
    if (this.g != null)
      localToStringHelper.add("valueStrength", Ascii.toLowerCase(this.g.toString()));
    if (this.k != null)
      localToStringHelper.addValue("keyEquivalence");
    if (this.l != null)
      localToStringHelper.addValue("valueEquivalence");
    if (this.a != null)
      localToStringHelper.addValue("removalListener");
    return localToStringHelper.toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.MapMaker
 * JD-Core Version:    0.6.2
 */