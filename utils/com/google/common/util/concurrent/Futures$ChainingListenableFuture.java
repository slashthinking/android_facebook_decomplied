package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Futures$ChainingListenableFuture<I, O> extends AbstractFuture<O>
  implements Runnable
{
  private Function<? super I, ? extends ListenableFuture<? extends O>> a;
  private ListenableFuture<? extends I> b;
  private volatile ListenableFuture<? extends O> c;
  private final BlockingQueue<Boolean> d = new LinkedBlockingQueue(1);
  private final CountDownLatch e = new CountDownLatch(1);

  private Futures$ChainingListenableFuture(Function<? super I, ? extends ListenableFuture<? extends O>> paramFunction, ListenableFuture<? extends I> paramListenableFuture)
  {
    this.a = ((Function)Preconditions.checkNotNull(paramFunction));
    this.b = ((ListenableFuture)Preconditions.checkNotNull(paramListenableFuture));
  }

  private void a(Future<?> paramFuture, boolean paramBoolean)
  {
    if (paramFuture != null)
      paramFuture.cancel(paramBoolean);
  }

  public boolean cancel(boolean paramBoolean)
  {
    if (super.cancel(paramBoolean))
    {
      Uninterruptibles.a(this.d, Boolean.valueOf(paramBoolean));
      a(this.b, paramBoolean);
      a(this.c, paramBoolean);
    }
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public O get()
  {
    if (!isDone())
    {
      ListenableFuture localListenableFuture1 = this.b;
      if (localListenableFuture1 != null)
        localListenableFuture1.get();
      this.e.await();
      ListenableFuture localListenableFuture2 = this.c;
      if (localListenableFuture2 != null)
        localListenableFuture2.get();
    }
    return super.get();
  }

  public O get(long paramLong, TimeUnit paramTimeUnit)
  {
    if (!isDone())
    {
      if (paramTimeUnit != TimeUnit.NANOSECONDS)
      {
        paramLong = TimeUnit.NANOSECONDS.convert(paramLong, paramTimeUnit);
        paramTimeUnit = TimeUnit.NANOSECONDS;
      }
      ListenableFuture localListenableFuture1 = this.b;
      if (localListenableFuture1 != null)
      {
        long l2 = System.nanoTime();
        localListenableFuture1.get(paramLong, paramTimeUnit);
        paramLong -= Math.max(0L, System.nanoTime() - l2);
      }
      long l1 = System.nanoTime();
      if (!this.e.await(paramLong, paramTimeUnit))
        throw new TimeoutException();
      paramLong -= Math.max(0L, System.nanoTime() - l1);
      ListenableFuture localListenableFuture2 = this.c;
      if (localListenableFuture2 != null)
        localListenableFuture2.get(paramLong, paramTimeUnit);
    }
    return super.get(paramLong, paramTimeUnit);
  }

  public void run()
  {
    try
    {
      Object localObject2 = Uninterruptibles.a(this.b);
      localListenableFuture = (ListenableFuture)this.a.apply(localObject2);
      this.c = localListenableFuture;
      if (isCancelled())
      {
        localListenableFuture.cancel(((Boolean)Uninterruptibles.a(this.d)).booleanValue());
        this.c = null;
        return;
      }
    }
    catch (CancellationException localCancellationException)
    {
      while (true)
      {
        cancel(false);
        this.a = null;
        this.b = null;
        this.e.countDown();
      }
    }
    catch (ExecutionException localExecutionException)
    {
      while (true)
      {
        ListenableFuture localListenableFuture;
        a_(localExecutionException.getCause());
        this.a = null;
        this.b = null;
        this.e.countDown();
        continue;
        localListenableFuture.a(new Futures.ChainingListenableFuture.1(this, localListenableFuture), MoreExecutors.a());
        this.a = null;
        this.b = null;
        this.e.countDown();
      }
    }
    catch (UndeclaredThrowableException localUndeclaredThrowableException)
    {
      while (true)
      {
        a_(localUndeclaredThrowableException.getCause());
        this.a = null;
        this.b = null;
        this.e.countDown();
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
      {
        a_(localRuntimeException);
        this.a = null;
        this.b = null;
        this.e.countDown();
      }
    }
    catch (Error localError)
    {
      while (true)
      {
        a_(localError);
        this.a = null;
        this.b = null;
        this.e.countDown();
      }
    }
    finally
    {
      this.a = null;
      this.b = null;
      this.e.countDown();
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures.ChainingListenableFuture
 * JD-Core Version:    0.6.2
 */