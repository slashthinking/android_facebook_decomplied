package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class Iterables
{
  public static <F, T> Iterable<T> a(Iterable<F> paramIterable, Function<? super F, ? extends T> paramFunction)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramFunction);
    return new Iterables.8(paramIterable, paramFunction);
  }

  public static <T> Iterable<T> a(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramPredicate);
    return new Iterables.6(paramIterable, paramPredicate);
  }

  public static <T> Iterable<T> a(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2)
  {
    Preconditions.checkNotNull(paramIterable1);
    Preconditions.checkNotNull(paramIterable2);
    return c(Arrays.asList(new Iterable[] { paramIterable1, paramIterable2 }));
  }

  public static <T> T a(Iterable<T> paramIterable, int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    Object localObject;
    if ((paramIterable instanceof List))
    {
      localObject = ((List)paramIterable).get(paramInt);
      return localObject;
    }
    if ((paramIterable instanceof Collection))
      Preconditions.checkElementIndex(paramInt, ((Collection)paramIterable).size());
    while (true)
    {
      localObject = Iterators.a(paramIterable.iterator(), paramInt);
      break;
      a(paramInt);
    }
  }

  public static <T> T a(Iterable<T> paramIterable, Predicate<? super T> paramPredicate, T paramT)
  {
    return Iterators.a(paramIterable.iterator(), paramPredicate, paramT);
  }

  public static String a(Iterable<?> paramIterable)
  {
    return Iterators.c(paramIterable.iterator());
  }

  private static void a(int paramInt)
  {
    if (paramInt < 0)
      throw new IndexOutOfBoundsException("position cannot be negative: " + paramInt);
  }

  public static <T> boolean a(Collection<T> paramCollection, Iterable<? extends T> paramIterable)
  {
    if ((paramIterable instanceof Collection));
    for (boolean bool = paramCollection.addAll(Collections2.a(paramIterable)); ; bool = Iterators.a(paramCollection, paramIterable.iterator()))
      return bool;
  }

  public static <T> T b(Iterable<T> paramIterable)
  {
    return Iterators.d(paramIterable.iterator());
  }

  public static <T> Iterable<T> c(Iterable<? extends Iterable<? extends T>> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    return new Iterables.2(paramIterable);
  }

  private static <T> UnmodifiableIterator<Iterator<? extends T>> e(Iterable<? extends Iterable<? extends T>> paramIterable)
  {
    return new Iterables.3(paramIterable.iterator());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterables
 * JD-Core Version:    0.6.2
 */