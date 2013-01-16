package com.facebook.zero;

import com.facebook.background.BackgroundResult;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FutureCallback;

class ZeroValidateTokenBackgroundTask$BackgroundResultFutureCallback extends AbstractFuture<BackgroundResult>
  implements FutureCallback<OperationResult>
{
  private ZeroTokenManager a;

  public ZeroValidateTokenBackgroundTask$BackgroundResultFutureCallback(ZeroTokenManager paramZeroTokenManager)
  {
    this.a = paramZeroTokenManager;
  }

  public void a(OperationResult paramOperationResult)
  {
    if (!Boolean.parseBoolean(paramOperationResult.f()))
    {
      BLog.c(ZeroValidateTokenBackgroundTask.d(), "zero token was invalidated.");
      this.a.a();
    }
    a_(new BackgroundResult(true));
  }

  public void a(Throwable paramThrowable)
  {
    BLog.e(ZeroValidateTokenBackgroundTask.d(), "Failed while validating zero token", paramThrowable);
    a_(new BackgroundResult(false));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.zero.ZeroValidateTokenBackgroundTask.BackgroundResultFutureCallback
 * JD-Core Version:    0.6.2
 */