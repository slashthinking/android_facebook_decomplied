package com.facebook.katana.activity.nearby;

import com.facebook.uri.UriIntentBuilder;
import javax.inject.Provider;

public class NearbyPlacesUriIntentBuilder extends UriIntentBuilder
{
  private final Provider<Boolean> a;

  public NearbyPlacesUriIntentBuilder(Provider<Boolean> paramProvider)
  {
    this.a = paramProvider;
    a("fb://nearby", NearbyPlacesActivity.class);
    a("fb://nearby/search", NearbySearchActivity.class);
  }

  public boolean a()
  {
    return ((Boolean)this.a.b()).booleanValue();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.nearby.NearbyPlacesUriIntentBuilder
 * JD-Core Version:    0.6.0
 */