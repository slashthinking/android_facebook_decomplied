package com.facebook.orca.app;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$UserInteractionControllerProvider extends AbstractProvider<UserInteractionController>
{
  private FbBaseModule$UserInteractionControllerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public UserInteractionController a()
  {
    return new UserInteractionController((AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.UserInteractionControllerProvider
 * JD-Core Version:    0.6.0
 */