package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;

final class Futures$7
  implements Runnable
{
  Futures$7(ListenableFuture paramListenableFuture, FutureCallback paramFutureCallback)
  {
  }

  public void run()
  {
    try
    {
      Object localObject = Uninterruptibles.a(this.a);
      this.b.a(localObject);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      while (true)
        this.b.a(localExecutionException.getCause());
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
        this.b.a(localRuntimeException);
    }
    catch (Error localError)
    {
      while (true)
        this.b.a(localError);
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.Futures.7
 * JD-Core Version:    0.6.2
 */