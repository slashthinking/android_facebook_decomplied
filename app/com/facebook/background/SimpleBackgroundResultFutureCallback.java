package com.facebook.background;

import com.facebook.orca.debug.BLog;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FutureCallback;

public class SimpleBackgroundResultFutureCallback extends AbstractFuture<BackgroundResult>
  implements FutureCallback<OperationResult>
{
  private final Class<?> a;

  public SimpleBackgroundResultFutureCallback(Class<?> paramClass)
  {
    this.a = paramClass;
  }

  public void a(OperationResult paramOperationResult)
  {
    BLog.b(this.a, "Finished successfully");
    a_(new BackgroundResult(true));
  }

  public void a(Throwable paramThrowable)
  {
    BLog.b(this.a, "Finished with failure");
    a_(new BackgroundResult(false));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.background.SimpleBackgroundResultFutureCallback
 * JD-Core Version:    0.6.0
 */