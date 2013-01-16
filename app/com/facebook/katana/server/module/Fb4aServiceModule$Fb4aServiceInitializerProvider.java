package com.facebook.katana.server.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceRegistry;

class Fb4aServiceModule$Fb4aServiceInitializerProvider extends AbstractProvider<Fb4aServiceInitializer>
{
  private Fb4aServiceModule$Fb4aServiceInitializerProvider(Fb4aServiceModule paramFb4aServiceModule)
  {
  }

  public Fb4aServiceInitializer a()
  {
    return new Fb4aServiceInitializer((OrcaServiceRegistry)b(OrcaServiceRegistry.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceModule.Fb4aServiceInitializerProvider
 * JD-Core Version:    0.6.0
 */