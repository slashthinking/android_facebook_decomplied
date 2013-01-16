package com.facebook.location;

import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class LocationModule extends AbstractModule
{
  protected void a()
  {
    a(LocationCache.class).a(new LocationModule.LocationCacheProvider(this, null)).a();
    a(GetDeviceLocationExecutor.class).a(new LocationModule.GetDeviceLocationExecutorProvider(this, null));
    a(LocationSourcesUtil.class).a(new LocationModule.LocationSourcesUtilProvider(this, null));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.location.LocationModule
 * JD-Core Version:    0.6.0
 */