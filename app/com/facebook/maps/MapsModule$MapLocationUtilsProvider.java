package com.facebook.maps;

import android.content.res.Resources;
import com.facebook.orca.inject.AbstractProvider;

class MapsModule$MapLocationUtilsProvider extends AbstractProvider<MapsLocationUtils>
{
  private MapsModule$MapLocationUtilsProvider(MapsModule paramMapsModule)
  {
  }

  public MapsLocationUtils a()
  {
    return new MapsLocationUtils((Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.MapsModule.MapLocationUtilsProvider
 * JD-Core Version:    0.6.0
 */