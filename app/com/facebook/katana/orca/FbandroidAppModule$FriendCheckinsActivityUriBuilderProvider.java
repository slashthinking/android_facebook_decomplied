package com.facebook.katana.orca;

import com.facebook.katana.activity.nearby.FallBackToFriendCheckinsUriBuilder;
import com.facebook.katana.activity.nearby.IsNearbyPlacesEnabled;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$FriendCheckinsActivityUriBuilderProvider extends AbstractProvider<FallBackToFriendCheckinsUriBuilder>
{
  private FbandroidAppModule$FriendCheckinsActivityUriBuilderProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public FallBackToFriendCheckinsUriBuilder a()
  {
    return new FallBackToFriendCheckinsUriBuilder(a(Boolean.class, IsNearbyPlacesEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.FriendCheckinsActivityUriBuilderProvider
 * JD-Core Version:    0.6.0
 */