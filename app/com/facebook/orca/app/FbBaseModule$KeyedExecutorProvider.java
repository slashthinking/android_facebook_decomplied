package com.facebook.orca.app;

import com.facebook.orca.annotations.DefaultExecutorService;
import com.facebook.orca.common.async.KeyedExecutor;
import com.facebook.orca.inject.AbstractProvider;
import java.util.concurrent.ExecutorService;

class FbBaseModule$KeyedExecutorProvider extends AbstractProvider<KeyedExecutor>
{
  private FbBaseModule$KeyedExecutorProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public KeyedExecutor a()
  {
    return new KeyedExecutor((ExecutorService)b(ExecutorService.class, DefaultExecutorService.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.KeyedExecutorProvider
 * JD-Core Version:    0.6.0
 */