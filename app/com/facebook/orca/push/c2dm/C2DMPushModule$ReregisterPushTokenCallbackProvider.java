package com.facebook.orca.push.c2dm;

import com.facebook.orca.inject.AbstractProvider;

class C2DMPushModule$ReregisterPushTokenCallbackProvider extends AbstractProvider<ReregisterPushTokenCallback>
{
  private C2DMPushModule$ReregisterPushTokenCallbackProvider(C2DMPushModule paramC2DMPushModule)
  {
  }

  public ReregisterPushTokenCallback a()
  {
    return new ReregisterPushTokenCallback((C2DMRegistrar)b(C2DMRegistrar.class), (FacebookPushServerRegistrar)b(FacebookPushServerRegistrar.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMPushModule.ReregisterPushTokenCallbackProvider
 * JD-Core Version:    0.6.0
 */