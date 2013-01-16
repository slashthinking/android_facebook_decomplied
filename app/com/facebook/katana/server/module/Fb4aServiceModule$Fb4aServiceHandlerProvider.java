package com.facebook.katana.server.module;

import com.facebook.katana.server.handler.FetchMinorStatusHandler;
import com.facebook.katana.server.protocol.FetchMinorStatusMethod;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class Fb4aServiceModule$Fb4aServiceHandlerProvider extends AbstractProvider<FetchMinorStatusHandler>
{
  private Fb4aServiceModule$Fb4aServiceHandlerProvider(Fb4aServiceModule paramFb4aServiceModule)
  {
  }

  public FetchMinorStatusHandler a()
  {
    return new FetchMinorStatusHandler(a(SingleMethodRunner.class), (FetchMinorStatusMethod)b(FetchMinorStatusMethod.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceModule.Fb4aServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */