package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;

class FbBaseModule$ActivityBroadcasterProvider extends AbstractProvider<ActivityBroadcaster>
{
  private FbBaseModule$ActivityBroadcasterProvider(FbBaseModule paramFbBaseModule)
  {
  }

  public ActivityBroadcaster a()
  {
    return new ActivityBroadcaster(FbBaseModule.b(this.a));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.FbBaseModule.ActivityBroadcasterProvider
 * JD-Core Version:    0.6.0
 */