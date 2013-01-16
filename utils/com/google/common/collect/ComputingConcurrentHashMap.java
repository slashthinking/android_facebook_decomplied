package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

class ComputingConcurrentHashMap<K, V> extends CustomConcurrentHashMap<K, V>
{
  private static final long serialVersionUID = 4L;
  final Function<? super K, ? extends V> computingFunction;

  ComputingConcurrentHashMap(MapMaker paramMapMaker, Function<? super K, ? extends V> paramFunction)
  {
    super(paramMapMaker);
    this.computingFunction = ((Function)Preconditions.checkNotNull(paramFunction));
  }

  ComputingConcurrentHashMap.ComputingSegment<K, V> a(int paramInt)
  {
    return (ComputingConcurrentHashMap.ComputingSegment)super.b(paramInt);
  }

  CustomConcurrentHashMap.Segment<K, V> a(int paramInt1, int paramInt2)
  {
    return new ComputingConcurrentHashMap.ComputingSegment(this, paramInt1, paramInt2);
  }

  V a(K paramK)
  {
    int i = b(Preconditions.checkNotNull(paramK));
    return a(i).a(paramK, i, this.computingFunction);
  }

  Object writeReplace()
  {
    return new ComputingConcurrentHashMap.ComputingSerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this, this.computingFunction);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ComputingConcurrentHashMap
 * JD-Core Version:    0.6.2
 */