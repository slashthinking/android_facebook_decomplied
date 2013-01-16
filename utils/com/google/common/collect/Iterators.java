package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class Iterators
{
  static final UnmodifiableIterator<Object> a = new Iterators.1();
  private static final Iterator<Object> b = new Iterators.2();

  public static <T> UnmodifiableIterator<T> a()
  {
    return a;
  }

  public static <T> UnmodifiableIterator<T> a(T paramT)
  {
    return new Iterators.13(paramT);
  }

  public static <T> UnmodifiableIterator<T> a(Iterator<T> paramIterator)
  {
    Preconditions.checkNotNull(paramIterator);
    if ((paramIterator instanceof UnmodifiableIterator));
    for (Object localObject = (UnmodifiableIterator)paramIterator; ; localObject = new Iterators.3(paramIterator))
      return localObject;
  }

  public static <T> UnmodifiableIterator<T> a(Iterator<T> paramIterator, Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramIterator);
    Preconditions.checkNotNull(paramPredicate);
    return new Iterators.7(paramIterator, paramPredicate);
  }

  public static <T> UnmodifiableIterator<T> a(T[] paramArrayOfT)
  {
    Preconditions.checkNotNull(paramArrayOfT);
    return new Iterators.11(paramArrayOfT.length, paramArrayOfT);
  }

  static <T> UnmodifiableIterator<T> a(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfT.length);
      return new Iterators.12(paramInt2, paramArrayOfT, paramInt1);
    }
  }

  public static <T> T a(Iterator<T> paramIterator, int paramInt)
  {
    a(paramInt);
    int j;
    for (int i = 0; paramIterator.hasNext(); i = j)
    {
      Object localObject = paramIterator.next();
      j = i + 1;
      if (i == paramInt)
        return localObject;
    }
    throw new IndexOutOfBoundsException("position (" + paramInt + ") must be less than the number of elements that remained (" + i + ")");
  }

  public static <T> T a(Iterator<T> paramIterator, Predicate<? super T> paramPredicate, T paramT)
  {
    UnmodifiableIterator localUnmodifiableIterator = a(paramIterator, paramPredicate);
    if (localUnmodifiableIterator.hasNext())
      paramT = localUnmodifiableIterator.next();
    return paramT;
  }

  public static <F, T> Iterator<T> a(Iterator<F> paramIterator, Function<? super F, ? extends T> paramFunction)
  {
    Preconditions.checkNotNull(paramIterator);
    Preconditions.checkNotNull(paramFunction);
    return new Iterators.8(paramIterator, paramFunction);
  }

  private static void a(int paramInt)
  {
    if (paramInt < 0)
      throw new IndexOutOfBoundsException("position (" + paramInt + ") must not be negative");
  }

  public static <T> boolean a(Collection<T> paramCollection, Iterator<? extends T> paramIterator)
  {
    Preconditions.checkNotNull(paramCollection);
    boolean bool = false;
    while (paramIterator.hasNext())
      bool |= paramCollection.add(paramIterator.next());
    return bool;
  }

  public static boolean a(Iterator<?> paramIterator, Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null)
      do
        if (!paramIterator.hasNext())
          break;
      while (paramIterator.next() != null);
    while (true)
    {
      return bool;
      while (true)
        if (paramIterator.hasNext())
          if (paramObject.equals(paramIterator.next()))
            break;
      bool = false;
    }
  }

  public static boolean a(Iterator<?> paramIterator, Collection<?> paramCollection)
  {
    Preconditions.checkNotNull(paramCollection);
    boolean bool = false;
    while (paramIterator.hasNext())
      if (paramCollection.contains(paramIterator.next()))
      {
        paramIterator.remove();
        bool = true;
      }
    return bool;
  }

  public static boolean a(Iterator<?> paramIterator1, Iterator<?> paramIterator2)
  {
    boolean bool2;
    if (paramIterator1.hasNext())
    {
      boolean bool3 = paramIterator2.hasNext();
      bool2 = false;
      if (bool3);
    }
    while (true)
    {
      return bool2;
      if (Objects.equal(paramIterator1.next(), paramIterator2.next()))
        break;
      bool2 = false;
      continue;
      boolean bool1 = paramIterator2.hasNext();
      bool2 = false;
      if (!bool1)
        bool2 = true;
    }
  }

  public static int b(Iterator<?> paramIterator)
  {
    for (int i = 0; paramIterator.hasNext(); i++)
      paramIterator.next();
    return i;
  }

  static <T> Iterator<T> b()
  {
    return b;
  }

  public static <T> Iterator<T> b(Iterator<? extends T> paramIterator1, Iterator<? extends T> paramIterator2)
  {
    Preconditions.checkNotNull(paramIterator1);
    Preconditions.checkNotNull(paramIterator2);
    return e(Arrays.asList(new Iterator[] { paramIterator1, paramIterator2 }).iterator());
  }

  public static boolean b(Iterator<?> paramIterator, Collection<?> paramCollection)
  {
    Preconditions.checkNotNull(paramCollection);
    boolean bool = false;
    while (paramIterator.hasNext())
      if (!paramCollection.contains(paramIterator.next()))
      {
        paramIterator.remove();
        bool = true;
      }
    return bool;
  }

  public static String c(Iterator<?> paramIterator)
  {
    if (!paramIterator.hasNext());
    StringBuilder localStringBuilder;
    for (String str = "[]"; ; str = ']')
    {
      return str;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append('[').append(paramIterator.next());
      while (paramIterator.hasNext())
        localStringBuilder.append(", ").append(paramIterator.next());
    }
  }

  public static <T> T d(Iterator<T> paramIterator)
  {
    Object localObject = paramIterator.next();
    if (!paramIterator.hasNext())
      return localObject;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expected one element but was: <" + localObject);
    for (int i = 0; (i < 4) && (paramIterator.hasNext()); i++)
      localStringBuilder.append(", " + paramIterator.next());
    if (paramIterator.hasNext())
      localStringBuilder.append(", ...");
    localStringBuilder.append('>');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }

  public static <T> Iterator<T> e(Iterator<? extends Iterator<? extends T>> paramIterator)
  {
    Preconditions.checkNotNull(paramIterator);
    return new Iterators.5(paramIterator);
  }

  static void f(Iterator<?> paramIterator)
  {
    Preconditions.checkNotNull(paramIterator);
    while (paramIterator.hasNext())
    {
      paramIterator.next();
      paramIterator.remove();
    }
  }

  public static <T> PeekingIterator<T> g(Iterator<? extends T> paramIterator)
  {
    if ((paramIterator instanceof Iterators.PeekingImpl));
    for (Iterators.PeekingImpl localPeekingImpl = (Iterators.PeekingImpl)paramIterator; ; localPeekingImpl = new Iterators.PeekingImpl(paramIterator))
      return localPeekingImpl;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.Iterators
 * JD-Core Version:    0.6.2
 */