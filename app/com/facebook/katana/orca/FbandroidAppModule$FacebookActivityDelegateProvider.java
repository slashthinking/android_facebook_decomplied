package com.facebook.katana.orca;

import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$FacebookActivityDelegateProvider extends AbstractProvider<FacebookActivityDelegate>
{
  private FbandroidAppModule$FacebookActivityDelegateProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public FacebookActivityDelegate a()
  {
    return new FacebookActivityDelegate(FbandroidAppModule.b(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.FacebookActivityDelegateProvider
 * JD-Core Version:    0.6.0
 */