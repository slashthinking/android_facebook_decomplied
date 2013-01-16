package com.google.common.collect;

public final class Multimaps
{
  public static <K, V> Multimap<K, V> a(Multimap<K, V> paramMultimap)
  {
    return Synchronized.a(paramMultimap, null);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Multimaps
 * JD-Core Version:    0.6.2
 */