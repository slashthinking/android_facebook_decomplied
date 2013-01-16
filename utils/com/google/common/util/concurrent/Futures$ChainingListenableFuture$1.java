package com.google.common.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

class Futures$ChainingListenableFuture$1
  implements Runnable
{
  Futures$ChainingListenableFuture$1(Futures.ChainingListenableFuture paramChainingListenableFuture, ListenableFuture paramListenableFuture)
  {
  }

  public void run()
  {
    try
    {
      this.b.a_(Uninterruptibles.a(this.a));
      return;
    }
    catch (CancellationException localCancellationException)
    {
      while (true)
      {
        this.b.cancel(false);
        Futures.ChainingListenableFuture.a(this.b, null);
      }
    }
    catch (ExecutionException localExecutionException)
    {
      while (true)
      {
        this.b.a_(localExecutionException.getCause());
        Futures.ChainingListenableFuture.a(this.b, null);
      }
    }
    finally
    {
      Futures.ChainingListenableFuture.a(this.b, null);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures.ChainingListenableFuture.1
 * JD-Core Version:    0.6.2
 */