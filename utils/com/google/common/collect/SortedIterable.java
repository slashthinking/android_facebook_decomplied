package com.google.common.collect;

import java.util.Comparator;

abstract interface SortedIterable<T> extends Iterable<T>
{
  public abstract Comparator<? super T> comparator();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.SortedIterable
 * JD-Core Version:    0.6.2
 */