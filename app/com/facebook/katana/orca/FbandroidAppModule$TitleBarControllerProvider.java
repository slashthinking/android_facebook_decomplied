package com.facebook.katana.orca;

import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.ui.TitleBarController;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$TitleBarControllerProvider extends AbstractProvider<TitleBarController>
{
  private FbandroidAppModule$TitleBarControllerProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public TitleBarController a()
  {
    return new TitleBarController((FacebookActivityDelegate)b(FacebookActivityDelegate.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.TitleBarControllerProvider
 * JD-Core Version:    0.6.0
 */