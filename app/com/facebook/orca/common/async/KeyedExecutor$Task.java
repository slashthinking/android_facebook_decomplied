package com.facebook.orca.common.async;

import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.concurrent.Callable;

class KeyedExecutor$Task<T>
  implements Runnable
{
  final Object a;
  final Object b;
  final String c;
  private ListenableFutureTask<T> d;

  private KeyedExecutor$Task(Object paramObject1, Object paramObject2, Callable<T> paramCallable, String paramString)
  {
    this.d = ListenableFutureTask.a(paramCallable);
    this.a = paramObject1;
    this.b = paramObject2;
    this.c = paramString;
  }

  public void run()
  {
    Tracer.b(50L);
    String str = "KeyedExecutor " + this.a;
    if (this.c != null)
      str = str + " (" + this.c + ")";
    Tracer localTracer = Tracer.a(str);
    try
    {
      this.d.run();
      long l2;
      return;
    }
    finally
    {
      long l1 = localTracer.a();
      if ((BLog.b(3)) && (l1 > 50L))
        BLog.b(KeyedExecutor.a(), "Thread trace:\n" + Tracer.c());
    }
    throw localObject;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.async.KeyedExecutor.Task
 * JD-Core Version:    0.6.0
 */