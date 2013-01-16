package com.facebook.katana.server.module;

import com.facebook.katana.server.handler.UserSetContactInfoServiceHandler;
import com.facebook.katana.server.protocol.UserSetContactInfoMethod;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class Fb4aServiceModule$UserSetContactInfoServiceHandlerProvider extends AbstractProvider<UserSetContactInfoServiceHandler>
{
  private Fb4aServiceModule$UserSetContactInfoServiceHandlerProvider(Fb4aServiceModule paramFb4aServiceModule)
  {
  }

  public UserSetContactInfoServiceHandler a()
  {
    return new UserSetContactInfoServiceHandler(a(SingleMethodRunner.class), (UserSetContactInfoMethod)b(UserSetContactInfoMethod.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.server.module.Fb4aServiceModule.UserSetContactInfoServiceHandlerProvider
 * JD-Core Version:    0.6.0
 */