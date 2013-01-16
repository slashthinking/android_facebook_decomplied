package com.facebook.timeline;

import android.os.Parcelable;
import com.facebook.feed.protocol.FetchParcelableResult;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.CancellationException;

public abstract class TimelineReplayableFetcher
  implements FutureCallback<OperationResult>
{
  private Throwable a = null;
  private OperationResult b = null;
  private TimelineReplayableFetcher.RetryHandler c;

  private boolean a(OperationResult paramOperationResult1, OperationResult paramOperationResult2)
  {
    FetchParcelableResult localFetchParcelableResult1 = (FetchParcelableResult)paramOperationResult1.h();
    FetchParcelableResult localFetchParcelableResult2 = (FetchParcelableResult)paramOperationResult2.h();
    if (localFetchParcelableResult1.f() > localFetchParcelableResult2.f());
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean c(OperationResult paramOperationResult)
  {
    if (!a(((FetchParcelableResult)paramOperationResult.h()).f()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private void h()
  {
    g();
    this.c.a(this);
  }

  public abstract Parcelable a();

  protected abstract void a(OperationResult paramOperationResult);

  public void a(TimelineReplayableFetcher.RetryHandler paramRetryHandler)
  {
    this.c = paramRetryHandler;
  }

  public final void a(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CancellationException));
    while (true)
    {
      return;
      if (this.b != null)
      {
        f();
        continue;
      }
      if (this.a != null)
      {
        a(this.a, paramThrowable);
        continue;
      }
      this.a = paramThrowable;
      h();
    }
  }

  protected abstract void a(Throwable paramThrowable1, Throwable paramThrowable2);

  protected abstract boolean a(long paramLong);

  public abstract String b();

  public final void b(OperationResult paramOperationResult)
  {
    if (this.b != null)
    {
      if (a(paramOperationResult, this.b))
        a(paramOperationResult);
      f();
    }
    while (true)
    {
      return;
      if ((this.a != null) || (c(paramOperationResult)))
      {
        a(paramOperationResult);
        f();
        continue;
      }
      this.b = paramOperationResult;
      a(paramOperationResult);
      h();
    }
  }

  public abstract String c();

  public abstract boolean d();

  public abstract int e();

  protected abstract void f();

  protected void g()
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineReplayableFetcher
 * JD-Core Version:    0.6.0
 */