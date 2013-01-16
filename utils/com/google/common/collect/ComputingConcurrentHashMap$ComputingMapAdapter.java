package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Throwables;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;

final class ComputingConcurrentHashMap$ComputingMapAdapter<K, V> extends ComputingConcurrentHashMap<K, V>
  implements Serializable
{
  private static final long serialVersionUID;

  ComputingConcurrentHashMap$ComputingMapAdapter(MapMaker paramMapMaker, Function<? super K, ? extends V> paramFunction)
  {
    super(paramMapMaker, paramFunction);
  }

  public V get(Object paramObject)
  {
    Object localObject;
    try
    {
      localObject = a(paramObject);
      if (localObject == null)
        throw new NullPointerException(this.computingFunction + " returned null for key " + paramObject + ".");
    }
    catch (ExecutionException localExecutionException)
    {
      Throwable localThrowable = localExecutionException.getCause();
      Throwables.propagateIfInstanceOf(localThrowable, ComputationException.class);
      throw new ComputationException(localThrowable);
    }
    return localObject;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ComputingConcurrentHashMap.ComputingMapAdapter
 * JD-Core Version:    0.6.2
 */