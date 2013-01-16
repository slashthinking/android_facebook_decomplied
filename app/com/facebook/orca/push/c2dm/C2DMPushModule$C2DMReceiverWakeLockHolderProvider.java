package com.facebook.orca.push.c2dm;

import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.inject.AbstractProvider;

class C2DMPushModule$C2DMReceiverWakeLockHolderProvider extends AbstractProvider<C2DMReceiverWakeLockHolder>
{
  private C2DMPushModule$C2DMReceiverWakeLockHolderProvider(C2DMPushModule paramC2DMPushModule)
  {
  }

  public C2DMReceiverWakeLockHolder a()
  {
    return new C2DMReceiverWakeLockHolder((OrcaWakeLockManager)b(OrcaWakeLockManager.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMPushModule.C2DMReceiverWakeLockHolderProvider
 * JD-Core Version:    0.6.0
 */