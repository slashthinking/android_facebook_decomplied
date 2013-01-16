package android.support.v4.content;

import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class ModernAsyncTask<Params, Progress, Result>
{
  private static final ThreadFactory a = new ModernAsyncTask.1();
  private static final BlockingQueue<Runnable> b = new LinkedBlockingQueue(10);
  private static final ModernAsyncTask.InternalHandler c;
  public static final Executor d = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, b, a);
  private static volatile Executor e;
  private final ModernAsyncTask.WorkerRunnable<Params, Result> f = new ModernAsyncTask.2(this);
  private final FutureTask<Result> g = new ModernAsyncTask.3(this, this.f);
  private volatile ModernAsyncTask.Status h = ModernAsyncTask.Status.PENDING;
  private final AtomicBoolean i = new AtomicBoolean();

  static
  {
    c = new ModernAsyncTask.InternalHandler(null);
    e = d;
  }

  private void c(Result paramResult)
  {
    if (!this.i.get())
      d(paramResult);
  }

  private Result d(Result paramResult)
  {
    c.obtainMessage(1, new ModernAsyncTask.AsyncTaskResult(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }

  private void e(Result paramResult)
  {
    if (c())
      b(paramResult);
    while (true)
    {
      this.h = ModernAsyncTask.Status.FINISHED;
      return;
      a(paramResult);
    }
  }

  public final ModernAsyncTask<Params, Progress, Result> a(Executor paramExecutor, Params[] paramArrayOfParams)
  {
    if (this.h != ModernAsyncTask.Status.PENDING);
    switch (ModernAsyncTask.4.a[this.h.ordinal()])
    {
    default:
      this.h = ModernAsyncTask.Status.RUNNING;
      b();
      this.f.b = paramArrayOfParams;
      paramExecutor.execute(this.g);
      return this;
    case 1:
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    case 2:
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }

  protected abstract Result a(Params[] paramArrayOfParams);

  protected void a()
  {
  }

  protected void a(Result paramResult)
  {
  }

  public final boolean a(boolean paramBoolean)
  {
    return this.g.cancel(paramBoolean);
  }

  protected void b()
  {
  }

  protected void b(Result paramResult)
  {
    a();
  }

  protected void b(Progress[] paramArrayOfProgress)
  {
  }

  public final boolean c()
  {
    return this.g.isCancelled();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ModernAsyncTask
 * JD-Core Version:    0.6.0
 */