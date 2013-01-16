package com.facebook.orca.app;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$AppInitLockProvider extends AbstractProvider<AppInitLock>
{
  private FbBaseModule$AppInitLockProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public AppInitLock a()
  {
    return new AppInitLock((AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.AppInitLockProvider
 * JD-Core Version:    0.6.0
 */