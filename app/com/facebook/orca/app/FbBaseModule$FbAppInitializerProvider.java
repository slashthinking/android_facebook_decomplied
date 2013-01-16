package com.facebook.orca.app;

import com.facebook.orca.annotations.NeedsHighPriorityInitOnBackgroundThread;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnBackgroundThread;
import com.facebook.orca.annotations.NeedsLowPriorityInitOnUiThread;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$FbAppInitializerProvider extends AbstractProvider<FbAppInitializer>
{
  private FbBaseModule$FbAppInitializerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public FbAppInitializer a()
  {
    return new FbAppInitializer((AndroidThreadUtil)b(AndroidThreadUtil.class), c(INeedInit.class, NeedsHighPriorityInitOnBackgroundThread.class), c(INeedInit.class, NeedsLowPriorityInitOnUiThread.class), c(INeedInit.class, NeedsLowPriorityInitOnBackgroundThread.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.FbAppInitializerProvider
 * JD-Core Version:    0.6.0
 */