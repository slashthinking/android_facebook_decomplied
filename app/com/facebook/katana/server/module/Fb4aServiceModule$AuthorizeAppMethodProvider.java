package com.facebook.katana.server.module;

import com.facebook.katana.server.protocol.AuthorizeAppMethod;
import com.facebook.orca.inject.AbstractProvider;

class Fb4aServiceModule$AuthorizeAppMethodProvider extends AbstractProvider<AuthorizeAppMethod>
{
  private Fb4aServiceModule$AuthorizeAppMethodProvider(Fb4aServiceModule paramFb4aServiceModule)
  {
  }

  public AuthorizeAppMethod a()
  {
    return new AuthorizeAppMethod();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceModule.AuthorizeAppMethodProvider
 * JD-Core Version:    0.6.0
 */