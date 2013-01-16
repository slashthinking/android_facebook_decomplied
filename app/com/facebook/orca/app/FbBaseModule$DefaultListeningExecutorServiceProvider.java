package com.facebook.orca.app;

import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.inject.AbstractProvider;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutorService;

class FbBaseModule$DefaultListeningExecutorServiceProvider extends AbstractProvider<ListeningExecutorService>
{
  private FbBaseModule$DefaultListeningExecutorServiceProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public ListeningExecutorService a()
  {
    return MoreExecutors.a((ExecutorService)b(ExecutorService.class, DefaultExecutorService.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.DefaultListeningExecutorServiceProvider
 * JD-Core Version:    0.6.0
 */