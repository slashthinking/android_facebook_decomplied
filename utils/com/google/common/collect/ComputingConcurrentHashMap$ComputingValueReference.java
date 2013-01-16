package com.google.common.collect;

import com.google.common.base.Function;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;

final class ComputingConcurrentHashMap$ComputingValueReference<K, V>
  implements CustomConcurrentHashMap.ValueReference<K, V>
{
  final Function<? super K, ? extends V> a;
  volatile CustomConcurrentHashMap.ValueReference<K, V> b = CustomConcurrentHashMap.g();

  public ComputingConcurrentHashMap$ComputingValueReference(Function<? super K, ? extends V> paramFunction)
  {
    this.a = paramFunction;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> a()
  {
    return null;
  }

  public CustomConcurrentHashMap.ValueReference<K, V> a(ReferenceQueue<V> paramReferenceQueue, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return this;
  }

  V a(K paramK, int paramInt)
  {
    try
    {
      Object localObject = this.a.apply(paramK);
      b(new ComputingConcurrentHashMap.ComputedReference(localObject));
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      b(new ComputingConcurrentHashMap.ComputationExceptionReference(localThrowable));
      throw new ExecutionException(localThrowable);
    }
  }

  public void a(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference)
  {
    b(paramValueReference);
  }

  void b(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference)
  {
    try
    {
      if (this.b == CustomConcurrentHashMap.e)
      {
        this.b = paramValueReference;
        notifyAll();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean b()
  {
    return true;
  }

  public V c()
  {
    int i;
    if (this.b == CustomConcurrentHashMap.e)
      i = 0;
    try
    {
      try
      {
        while (true)
        {
          CustomConcurrentHashMap.ValueReference localValueReference1 = this.b;
          CustomConcurrentHashMap.ValueReference localValueReference2 = CustomConcurrentHashMap.e;
          if (localValueReference1 != localValueReference2)
            break;
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            i = 1;
          }
        }
        return this.b.c();
      }
      finally
      {
      }
    }
    finally
    {
      if (i != 0)
        Thread.currentThread().interrupt();
    }
  }

  public V get()
  {
    return null;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ComputingConcurrentHashMap.ComputingValueReference
 * JD-Core Version:    0.6.2
 */