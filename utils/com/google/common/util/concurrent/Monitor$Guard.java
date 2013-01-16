package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Monitor$Guard
{
  final Monitor b;
  final Condition c;
  int d = 0;

  protected Monitor$Guard(Monitor paramMonitor)
  {
    this.b = ((Monitor)Preconditions.checkNotNull(paramMonitor, "monitor"));
    this.c = Monitor.a(paramMonitor).newCondition();
  }

  public abstract boolean a();

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public final int hashCode()
  {
    return super.hashCode();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.util.concurrent.Monitor.Guard
 * JD-Core Version:    0.6.2
 */