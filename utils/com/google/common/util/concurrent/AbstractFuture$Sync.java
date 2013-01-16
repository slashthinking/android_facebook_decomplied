package com.google.common.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

final class AbstractFuture$Sync<V> extends AbstractQueuedSynchronizer
{
  private static final long serialVersionUID;
  private Throwable exception;
  private V value;

  private boolean a(V paramV, Throwable paramThrowable, int paramInt)
  {
    int i = 1;
    if (compareAndSetState(0, i))
    {
      this.value = paramV;
      this.exception = paramThrowable;
      releaseShared(paramInt);
    }
    while (true)
    {
      return i;
      int j = 0;
    }
  }

  private V e()
  {
    int i = getState();
    switch (i)
    {
    case 3:
    default:
      throw new IllegalStateException("Error, synchronizer in invalid state: " + i);
    case 2:
      if (this.exception != null)
        throw new ExecutionException(this.exception);
      return this.value;
    case 4:
    }
    throw new CancellationException("Task was cancelled.");
  }

  V a()
  {
    acquireSharedInterruptibly(-1);
    return e();
  }

  V a(long paramLong)
  {
    if (!tryAcquireSharedNanos(-1, paramLong))
      throw new TimeoutException("Timeout waiting for task.");
    return e();
  }

  boolean a(V paramV)
  {
    return a(paramV, null, 2);
  }

  boolean a(Throwable paramThrowable)
  {
    return a(null, paramThrowable, 2);
  }

  boolean b()
  {
    if ((0x6 & getState()) != 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean c()
  {
    if (getState() == 4);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean d()
  {
    return a(null, null, 4);
  }

  protected int tryAcquireShared(int paramInt)
  {
    if (b());
    for (int i = 1; ; i = -1)
      return i;
  }

  protected boolean tryReleaseShared(int paramInt)
  {
    setState(paramInt);
    return true;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.AbstractFuture.Sync
 * JD-Core Version:    0.6.2
 */