package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

class ExecutionList$RunnableExecutorPair
{
  final Runnable a;
  final Executor b;

  ExecutionList$RunnableExecutorPair(Runnable paramRunnable, Executor paramExecutor)
  {
    this.a = paramRunnable;
    this.b = paramExecutor;
  }

  void a()
  {
    if (ExecutionList.b() == null);
    while (true)
    {
      try
      {
        this.b.execute(this.a);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        ExecutionList.c().log(Level.SEVERE, "RuntimeException while executing runnable " + this.a + " with executor " + this.b, localRuntimeException);
        continue;
      }
      try
      {
        this.b.execute(this.a);
      }
      catch (Throwable localThrowable)
      {
        ExecutionList.b().a(localThrowable);
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.ExecutionList.RunnableExecutorPair
 * JD-Core Version:    0.6.2
 */