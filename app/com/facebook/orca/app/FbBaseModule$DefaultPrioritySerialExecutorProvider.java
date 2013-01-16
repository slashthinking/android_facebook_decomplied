package com.facebook.orca.app;

import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.common.async.PrioritySerialExecutor;
import com.facebook.orca.common.async.PrioritySerialExecutorImpl;
import com.facebook.orca.inject.AbstractProvider;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class FbBaseModule$DefaultPrioritySerialExecutorProvider extends AbstractProvider<PrioritySerialExecutor>
{
  private FbBaseModule$DefaultPrioritySerialExecutorProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public PrioritySerialExecutor a()
  {
    return new PrioritySerialExecutorImpl((Executor)b(ExecutorService.class, DefaultExecutorService.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.DefaultPrioritySerialExecutorProvider
 * JD-Core Version:    0.6.0
 */