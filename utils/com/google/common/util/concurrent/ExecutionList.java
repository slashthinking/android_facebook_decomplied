package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public final class ExecutionList
{
  private static final Logger a = Logger.getLogger(ExecutionList.class.getName());
  private static ExecutionList.UncaughtExceptionHandler b;
  private final Queue<ExecutionList.RunnableExecutorPair> c = Lists.b();
  private boolean d = false;

  public static void a(ExecutionList.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    b = paramUncaughtExceptionHandler;
  }

  public void a()
  {
    synchronized (this.c)
    {
      if (!this.d)
      {
        this.d = true;
        if (!this.c.isEmpty())
          ((ExecutionList.RunnableExecutorPair)this.c.poll()).a();
      }
    }
  }

  public void a(Runnable paramRunnable, Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramRunnable, "Runnable was null.");
    Preconditions.checkNotNull(paramExecutor, "Executor was null.");
    int i = 0;
    synchronized (this.c)
    {
      if (!this.d)
      {
        this.c.add(new ExecutionList.RunnableExecutorPair(paramRunnable, paramExecutor));
        if (i != 0)
          new ExecutionList.RunnableExecutorPair(paramRunnable, paramExecutor).a();
        return;
      }
      i = 1;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.ExecutionList
 * JD-Core Version:    0.6.2
 */