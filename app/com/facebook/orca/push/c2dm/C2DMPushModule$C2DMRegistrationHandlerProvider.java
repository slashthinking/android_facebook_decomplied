package com.facebook.orca.push.c2dm;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class C2DMPushModule$C2DMRegistrationHandlerProvider extends AbstractProvider<C2DMRegistrationHandler>
{
  private C2DMPushModule$C2DMRegistrationHandlerProvider(C2DMPushModule paramC2DMPushModule)
  {
  }

  public C2DMRegistrationHandler a()
  {
    return new C2DMRegistrationHandler((RegisterPushTokenMethod)b(RegisterPushTokenMethod.class), (UnregisterPushTokenMethod)b(UnregisterPushTokenMethod.class), a(SingleMethodRunner.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMPushModule.C2DMRegistrationHandlerProvider
 * JD-Core Version:    0.6.0
 */