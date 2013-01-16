package com.facebook.uberbar.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceRegistry;

class UberbarModule$UberbarServicesInitializerProvider extends AbstractProvider<UberbarServicesInitializer>
{
  private UberbarModule$UberbarServicesInitializerProvider(UberbarModule paramUberbarModule)
  {
  }

  public UberbarServicesInitializer a()
  {
    return new UberbarServicesInitializer((OrcaServiceRegistry)b(OrcaServiceRegistry.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.module.UberbarModule.UberbarServicesInitializerProvider
 * JD-Core Version:    0.6.2
 */