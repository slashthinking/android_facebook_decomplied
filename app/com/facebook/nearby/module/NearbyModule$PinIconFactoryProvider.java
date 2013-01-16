package com.facebook.nearby.module;

import android.content.res.Resources;
import com.facebook.nearby.places.NearbyMapPinFactory;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;

class NearbyModule$PinIconFactoryProvider extends AbstractProvider<NearbyMapPinFactory>
{
  private NearbyModule$PinIconFactoryProvider(NearbyModule paramNearbyModule)
  {
  }

  public NearbyMapPinFactory a()
  {
    return new NearbyMapPinFactory((Resources)b(Resources.class), (AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.module.NearbyModule.PinIconFactoryProvider
 * JD-Core Version:    0.6.0
 */