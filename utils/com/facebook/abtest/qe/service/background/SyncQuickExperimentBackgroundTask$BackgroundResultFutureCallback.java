package com.facebook.abtest.qe.service.background;

import com.facebook.background.BackgroundResult;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.server.OperationResult;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FutureCallback;

class SyncQuickExperimentBackgroundTask$BackgroundResultFutureCallback extends AbstractFuture<BackgroundResult>
  implements FutureCallback<OperationResult>
{
  public void a(OperationResult paramOperationResult)
  {
    BLog.b(SyncQuickExperimentBackgroundTask.d(), "Finished sucessfully");
    a_(new BackgroundResult(true));
  }

  public void a(Throwable paramThrowable)
  {
    BLog.b(SyncQuickExperimentBackgroundTask.d(), "Finished with failure: " + paramThrowable.toString());
    a_(new BackgroundResult(false));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.abtest.qe.service.background.SyncQuickExperimentBackgroundTask.BackgroundResultFutureCallback
 * JD-Core Version:    0.6.2
 */