package com.facebook.katana.orca;

import com.facebook.katana.activity.nearby.IsNearbyPlacesEnabled;
import com.facebook.katana.activity.nearby.NearbyPlacesUriIntentBuilder;
import com.facebook.orca.inject.AbstractProvider;

class FbandroidAppModule$NearbyPlacesUriIntentBuilderProvider extends AbstractProvider<NearbyPlacesUriIntentBuilder>
{
  private FbandroidAppModule$NearbyPlacesUriIntentBuilderProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public NearbyPlacesUriIntentBuilder a()
  {
    return new NearbyPlacesUriIntentBuilder(a(Boolean.class, IsNearbyPlacesEnabled.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.NearbyPlacesUriIntentBuilderProvider
 * JD-Core Version:    0.6.0
 */