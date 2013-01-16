package com.google.common.collect;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;

final class ComputingConcurrentHashMap$ComputationExceptionReference<K, V>
  implements CustomConcurrentHashMap.ValueReference<K, V>
{
  final Throwable a;

  ComputingConcurrentHashMap$ComputationExceptionReference(Throwable paramThrowable)
  {
    this.a = paramThrowable;
  }

  public CustomConcurrentHashMap.ReferenceEntry<K, V> a()
  {
    return null;
  }

  public CustomConcurrentHashMap.ValueReference<K, V> a(ReferenceQueue<V> paramReferenceQueue, CustomConcurrentHashMap.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return this;
  }

  public void a(CustomConcurrentHashMap.ValueReference<K, V> paramValueReference)
  {
  }

  public boolean b()
  {
    return false;
  }

  public V c()
  {
    throw new ExecutionException(this.a);
  }

  public V get()
  {
    return null;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ComputingConcurrentHashMap.ComputationExceptionReference
 * JD-Core Version:    0.6.2
 */