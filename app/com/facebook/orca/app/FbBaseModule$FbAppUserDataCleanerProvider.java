package com.facebook.orca.app;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$FbAppUserDataCleanerProvider extends AbstractProvider<FbAppUserDataCleaner>
{
  private FbBaseModule$FbAppUserDataCleanerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public FbAppUserDataCleaner a()
  {
    return new FbAppUserDataCleaner((AndroidThreadUtil)b(AndroidThreadUtil.class), c(IHaveUserData.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.FbAppUserDataCleanerProvider
 * JD-Core Version:    0.6.0
 */