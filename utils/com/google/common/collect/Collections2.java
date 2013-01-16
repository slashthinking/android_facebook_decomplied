package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;

public final class Collections2
{
  static final Joiner a = Joiner.on(", ");

  static String a(Collection<?> paramCollection)
  {
    StringBuilder localStringBuilder = a(paramCollection.size()).append('[');
    a.appendTo(localStringBuilder, Iterables.a(paramCollection, new Collections2.1(paramCollection)));
    return ']';
  }

  static StringBuilder a(int paramInt)
  {
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "size must be non-negative");
      return new StringBuilder((int)Math.min(8L * paramInt, 1073741824L));
    }
  }

  static <T> Collection<T> a(Iterable<T> paramIterable)
  {
    return (Collection)paramIterable;
  }

  public static <F, T> Collection<T> a(Collection<F> paramCollection, Function<? super F, T> paramFunction)
  {
    return new Collections2.TransformedCollection(paramCollection, paramFunction);
  }

  static boolean a(Collection<?> paramCollection, Object paramObject)
  {
    try
    {
      boolean bool2 = paramCollection.contains(paramObject);
      bool1 = bool2;
      return bool1;
    }
    catch (ClassCastException localClassCastException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  static boolean a(Collection<?> paramCollection1, Collection<?> paramCollection2)
  {
    Preconditions.checkNotNull(paramCollection1);
    Iterator localIterator = paramCollection2.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (paramCollection1.contains(localIterator.next()));
    for (boolean bool = false; ; bool = true)
      return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Collections2
 * JD-Core Version:    0.6.2
 */