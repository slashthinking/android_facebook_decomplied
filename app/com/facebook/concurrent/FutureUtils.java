package com.facebook.concurrent;

import com.facebook.orca.debug.BLog;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureUtils
{
  public static <T> T a(Future<T> paramFuture)
  {
    try
    {
      Object localObject2 = paramFuture.get();
      localObject1 = localObject2;
      return localObject1;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
      {
        Thread.currentThread().interrupt();
        BLog.e(paramFuture.getClass(), "Exception while blocking for future result", localInterruptedException);
        Object localObject1 = null;
      }
    }
    catch (ExecutionException localExecutionException)
    {
      label18: break label18;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.concurrent.FutureUtils
 * JD-Core Version:    0.6.0
 */