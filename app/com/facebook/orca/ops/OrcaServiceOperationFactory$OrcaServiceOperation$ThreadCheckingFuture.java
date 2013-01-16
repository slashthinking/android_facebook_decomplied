package com.facebook.orca.ops;

import android.os.Handler;
import android.os.Looper;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.TimeUnit;

class OrcaServiceOperationFactory$OrcaServiceOperation$ThreadCheckingFuture<T> extends AbstractFuture<T>
{
  private OrcaServiceOperationFactory$OrcaServiceOperation$ThreadCheckingFuture(OrcaServiceOperationFactory.OrcaServiceOperation paramOrcaServiceOperation)
  {
  }

  private void c()
  {
    boolean bool1 = true;
    if (isDone())
      return;
    boolean bool2;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      bool2 = bool1;
      label21: Preconditions.checkState(bool2, "Cannot call get on main thread for unfinished operation");
      if (OrcaServiceOperationFactory.OrcaServiceOperation.b(this.a).getLooper() == Looper.myLooper())
        break label57;
    }
    while (true)
    {
      Preconditions.checkState(bool1, "Cannot call get on the operation's handler thread for unfinished operation");
      break;
      bool2 = false;
      break label21;
      label57: bool1 = false;
    }
  }

  public boolean a_(T paramT)
  {
    return super.a_(paramT);
  }

  public boolean a_(Throwable paramThrowable)
  {
    return super.a_(paramThrowable);
  }

  public T get()
  {
    c();
    return super.get();
  }

  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    c();
    return super.get(paramLong, paramTimeUnit);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation.ThreadCheckingFuture
 * JD-Core Version:    0.6.0
 */