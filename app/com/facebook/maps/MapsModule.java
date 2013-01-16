package com.facebook.maps;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;

public class MapsModule extends AbstractModule
{
  protected void a()
  {
    a(MapFragmentFactory.class).a(new MapsModule.MapFragmentFactoryProvider(this, null));
    a(MapsLocationUtils.class).a(new MapsModule.MapLocationUtilsProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.maps.MapsModule
 * JD-Core Version:    0.6.0
 */