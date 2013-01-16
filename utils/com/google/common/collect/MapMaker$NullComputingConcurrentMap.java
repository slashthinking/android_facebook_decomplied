package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

final class MapMaker$NullComputingConcurrentMap<K, V> extends MapMaker.NullConcurrentMap<K, V>
{
  private static final long serialVersionUID;
  final Function<? super K, ? extends V> computingFunction;

  MapMaker$NullComputingConcurrentMap(MapMaker paramMapMaker, Function<? super K, ? extends V> paramFunction)
  {
    super(paramMapMaker);
    this.computingFunction = ((Function)Preconditions.checkNotNull(paramFunction));
  }

  private V a(K paramK)
  {
    Preconditions.checkNotNull(paramK);
    try
    {
      Object localObject = this.computingFunction.apply(paramK);
      return localObject;
    }
    catch (ComputationException localComputationException)
    {
      throw localComputationException;
    }
    catch (Throwable localThrowable)
    {
      throw new ComputationException(localThrowable);
    }
  }

  public V get(Object paramObject)
  {
    Object localObject = a(paramObject);
    Preconditions.checkNotNull(localObject, this.computingFunction + " returned null for key " + paramObject + ".");
    a(paramObject, localObject);
    return localObject;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.MapMaker.NullComputingConcurrentMap
 * JD-Core Version:    0.6.2
 */