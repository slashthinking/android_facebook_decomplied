package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.inject.FbInjectorImpl;
import com.facebook.orca.inject.FbInjectorImpl.LessEagerUiThreadSingletonInitializer;

class FbBaseModule$LessEagerUiThreadSingletonInitializerProvider extends AbstractProvider<FbInjectorImpl.LessEagerUiThreadSingletonInitializer>
{
  private FbBaseModule$LessEagerUiThreadSingletonInitializerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public FbInjectorImpl.LessEagerUiThreadSingletonInitializer a()
  {
    return ((FbInjectorImpl)d()).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.LessEagerUiThreadSingletonInitializerProvider
 * JD-Core Version:    0.6.0
 */