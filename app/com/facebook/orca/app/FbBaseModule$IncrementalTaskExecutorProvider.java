package com.facebook.orca.app;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.task.IncrementalTaskExecutor;

class FbBaseModule$IncrementalTaskExecutorProvider extends AbstractProvider<IncrementalTaskExecutor>
{
  private FbBaseModule$IncrementalTaskExecutorProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public IncrementalTaskExecutor a()
  {
    return new IncrementalTaskExecutor((Clock)b(SystemClock.class), (UserInteractionController)b(UserInteractionController.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.IncrementalTaskExecutorProvider
 * JD-Core Version:    0.6.0
 */