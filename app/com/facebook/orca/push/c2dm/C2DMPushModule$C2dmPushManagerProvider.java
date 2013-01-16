package com.facebook.orca.push.c2dm;

import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.inject.AbstractProvider;

class C2DMPushModule$C2dmPushManagerProvider extends AbstractProvider<C2dmPushManager>
{
  private C2DMPushModule$C2dmPushManagerProvider(C2DMPushModule paramC2DMPushModule)
  {
  }

  public C2dmPushManager a()
  {
    return new C2dmPushManager((C2DMRegistrar)b(C2DMRegistrar.class), (FacebookPushServerRegistrar)b(FacebookPushServerRegistrar.class), a(String.class, MeUserId.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMPushModule.C2dmPushManagerProvider
 * JD-Core Version:    0.6.0
 */