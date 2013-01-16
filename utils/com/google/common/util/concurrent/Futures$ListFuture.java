package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class Futures$ListFuture<V> extends AbstractFuture<List<V>>
{
  ImmutableList<? extends ListenableFuture<? extends V>> a;
  final boolean b;
  final AtomicInteger c;
  List<V> d;

  Futures$ListFuture(ImmutableList<? extends ListenableFuture<? extends V>> paramImmutableList, boolean paramBoolean, Executor paramExecutor)
  {
    this.a = paramImmutableList;
    this.d = Lists.b(paramImmutableList.size());
    this.b = paramBoolean;
    this.c = new AtomicInteger(paramImmutableList.size());
    a(paramExecutor);
  }

  private void a(int paramInt, Future<? extends V> paramFuture)
  {
    boolean bool = true;
    List localList1 = this.d;
    if ((isDone()) || (localList1 == null))
      Preconditions.checkState(this.b, "Future was done before all dependencies completed");
    label108: int i;
    while (true)
    {
      return;
      try
      {
        Preconditions.checkState(paramFuture.isDone(), "Tried to set value from future which is not done");
        localList1.set(paramInt, Uninterruptibles.a(paramFuture));
        int i1 = this.c.decrementAndGet();
        if (i1 >= 0);
        while (true)
        {
          Preconditions.checkState(bool, "Less than 0 remaining futures");
          if (i1 != 0)
            break;
          List localList7 = this.d;
          if (localList7 == null)
            break label108;
          a_(Lists.a(localList7));
          break;
          bool = false;
        }
        Preconditions.checkState(isDone());
      }
      catch (CancellationException localCancellationException)
      {
        if (this.b)
          cancel(false);
        int n = this.c.decrementAndGet();
        if (n >= 0);
        while (true)
        {
          Preconditions.checkState(bool, "Less than 0 remaining futures");
          if (n != 0)
            break;
          List localList6 = this.d;
          if (localList6 == null)
            break label187;
          a_(Lists.a(localList6));
          break;
          bool = false;
        }
        Preconditions.checkState(isDone());
      }
      catch (ExecutionException localExecutionException)
      {
        if (this.b)
          a_(localExecutionException.getCause());
        int m = this.c.decrementAndGet();
        if (m >= 0);
        while (true)
        {
          Preconditions.checkState(bool, "Less than 0 remaining futures");
          if (m != 0)
            break;
          List localList5 = this.d;
          if (localList5 == null)
            break label270;
          a_(Lists.a(localList5));
          break;
          bool = false;
        }
        Preconditions.checkState(isDone());
      }
      catch (RuntimeException localRuntimeException)
      {
        if (this.b)
          a_(localRuntimeException);
        int k = this.c.decrementAndGet();
        if (k >= 0);
        while (true)
        {
          Preconditions.checkState(bool, "Less than 0 remaining futures");
          if (k != 0)
            break;
          List localList4 = this.d;
          if (localList4 == null)
            break label350;
          a_(Lists.a(localList4));
          break;
          bool = false;
        }
        Preconditions.checkState(isDone());
      }
      catch (Error localError)
      {
        label187: label350: a_(localError);
        label270: int j = this.c.decrementAndGet();
        if (j >= 0);
        while (true)
        {
          Preconditions.checkState(bool, "Less than 0 remaining futures");
          if (j != 0)
            break;
          List localList3 = this.d;
          if (localList3 == null)
            break label423;
          a_(Lists.a(localList3));
          break;
          bool = false;
        }
        label423: Preconditions.checkState(isDone());
      }
      finally
      {
        i = this.c.decrementAndGet();
        if (i < 0)
          break label484;
      }
    }
    Preconditions.checkState(bool, "Less than 0 remaining futures");
    if (i == 0)
    {
      List localList2 = this.d;
      if (localList2 == null)
        break label489;
      a_(Lists.a(localList2));
    }
    while (true)
    {
      throw localObject;
      label484: bool = false;
      break;
      label489: Preconditions.checkState(isDone());
    }
  }

  private void a(Executor paramExecutor)
  {
    int i = 0;
    a(new Futures.ListFuture.1(this), MoreExecutors.a());
    if (this.a.isEmpty())
      a_(Lists.a(this.d));
    while (true)
    {
      return;
      for (int j = 0; j < this.a.size(); j++)
        this.d.add(null);
      ImmutableList localImmutableList = this.a;
      while (i < localImmutableList.size())
      {
        ListenableFuture localListenableFuture = (ListenableFuture)localImmutableList.get(i);
        localListenableFuture.a(new Futures.ListFuture.2(this, i, localListenableFuture), paramExecutor);
        i++;
      }
    }
  }

  private void d()
  {
    ImmutableList localImmutableList = this.a;
    if ((localImmutableList != null) && (!isDone()))
      label42: 
      do
      {
        Iterator localIterator = localImmutableList.iterator();
        break label42;
        if (!localIterator.hasNext())
          break;
        ListenableFuture localListenableFuture = (ListenableFuture)localIterator.next();
        while (!localListenableFuture.isDone())
          try
          {
            localListenableFuture.get();
          }
          catch (Error localError)
          {
            throw localError;
          }
          catch (InterruptedException localInterruptedException)
          {
            throw localInterruptedException;
          }
          catch (Throwable localThrowable)
          {
          }
      }
      while (!this.b);
  }

  public List<V> c()
  {
    d();
    return (List)super.get();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures.ListFuture
 * JD-Core Version:    0.6.2
 */