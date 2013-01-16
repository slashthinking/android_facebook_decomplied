package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.Executor;

public final class Futures
{
  private static final Ordering<Constructor<?>> a = Ordering.b().a(new Futures.8()).a();

  public static <I, O> ListenableFuture<O> a(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction)
  {
    return b(paramListenableFuture, paramFunction, MoreExecutors.a());
  }

  public static <I, O> ListenableFuture<O> a(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends ListenableFuture<? extends O>> paramFunction, Executor paramExecutor)
  {
    Futures.ChainingListenableFuture localChainingListenableFuture = new Futures.ChainingListenableFuture(paramFunction, paramListenableFuture, null);
    paramListenableFuture.a(localChainingListenableFuture, paramExecutor);
    return localChainingListenableFuture;
  }

  public static <V> ListenableFuture<List<V>> a(Iterable<? extends ListenableFuture<? extends V>> paramIterable)
  {
    return new Futures.ListFuture(ImmutableList.a(paramIterable), true, MoreExecutors.a());
  }

  public static <V> ListenableFuture<V> a(V paramV)
  {
    SettableFuture localSettableFuture = SettableFuture.c();
    localSettableFuture.a_(paramV);
    return localSettableFuture;
  }

  public static <V> ListenableFuture<V> a(Throwable paramThrowable)
  {
    Preconditions.checkNotNull(paramThrowable);
    SettableFuture localSettableFuture = SettableFuture.c();
    localSettableFuture.a_(paramThrowable);
    return localSettableFuture;
  }

  public static <V> ListenableFuture<List<V>> a(ListenableFuture<? extends V>[] paramArrayOfListenableFuture)
  {
    return new Futures.ListFuture(ImmutableList.a(paramArrayOfListenableFuture), true, MoreExecutors.a());
  }

  public static <V> void a(ListenableFuture<V> paramListenableFuture, FutureCallback<? super V> paramFutureCallback)
  {
    a(paramListenableFuture, paramFutureCallback, MoreExecutors.a());
  }

  public static <V> void a(ListenableFuture<V> paramListenableFuture, FutureCallback<? super V> paramFutureCallback, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramFutureCallback);
    paramListenableFuture.a(new Futures.7(paramListenableFuture, paramFutureCallback), paramExecutor);
  }

  public static <I, O> ListenableFuture<O> b(ListenableFuture<I> paramListenableFuture, Function<? super I, ? extends O> paramFunction, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramFunction);
    return a(paramListenableFuture, new Futures.4(paramFunction), paramExecutor);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures
 * JD-Core Version:    0.6.2
 */