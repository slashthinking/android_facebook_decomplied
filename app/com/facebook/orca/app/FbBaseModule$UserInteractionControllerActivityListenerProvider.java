package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$UserInteractionControllerActivityListenerProvider extends AbstractProvider<UserInteractionController.ActivityListener>
{
  private FbBaseModule$UserInteractionControllerActivityListenerProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public UserInteractionController.ActivityListener a()
  {
    return ((UserInteractionController)b(UserInteractionController.class)).a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.UserInteractionControllerActivityListenerProvider
 * JD-Core Version:    0.6.0
 */