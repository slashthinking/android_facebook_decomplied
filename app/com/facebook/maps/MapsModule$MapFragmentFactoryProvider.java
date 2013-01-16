package com.facebook.maps;

import com.facebook.maps.annotation.MapApiKeyString;
import com.facebook.orca.inject.AbstractProvider;
import javax.inject.Provider;

class MapsModule$MapFragmentFactoryProvider extends AbstractProvider<MapFragmentFactory>
{
  private MapsModule$MapFragmentFactoryProvider(MapsModule paramMapsModule)
  {
  }

  public MapFragmentFactory a()
  {
    return new MapFragmentFactory((String)a(String.class, MapApiKeyString.class).b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.MapsModule.MapFragmentFactoryProvider
 * JD-Core Version:    0.6.0
 */