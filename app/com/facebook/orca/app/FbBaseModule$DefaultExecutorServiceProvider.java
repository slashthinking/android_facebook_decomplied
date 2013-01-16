package com.facebook.orca.app;

import com.facebook.concurrent.NamedThreadFactory;
import com.facebook.orca.inject.AbstractProvider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class FbBaseModule$DefaultExecutorServiceProvider extends AbstractProvider<ExecutorService>
{
  private FbBaseModule$DefaultExecutorServiceProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public ExecutorService a()
  {
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue(10);
    return new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, localLinkedBlockingQueue, new NamedThreadFactory("FbBaseModule Thread #"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.DefaultExecutorServiceProvider
 * JD-Core Version:    0.6.0
 */