package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$AppInitCompleteInitializerProvider extends AbstractProvider<AppInitCompleteInitializer>
{
  private FbBaseModule$AppInitCompleteInitializerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public AppInitCompleteInitializer a()
  {
    return new AppInitCompleteInitializer((AppInitLock)b(AppInitLock.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.AppInitCompleteInitializerProvider
 * JD-Core Version:    0.6.0
 */