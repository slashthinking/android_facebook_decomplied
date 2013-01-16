package com.facebook.orca.push.c2dm;

import com.facebook.orca.common.OrcaWakeLockManager;
import com.facebook.orca.common.WakeLockHolder;

public class C2DMReceiverWakeLockHolder extends WakeLockHolder
{
  public C2DMReceiverWakeLockHolder(OrcaWakeLockManager paramOrcaWakeLockManager)
  {
    super(paramOrcaWakeLockManager, "C2DM_LIB");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMReceiverWakeLockHolder
 * JD-Core Version:    0.6.0
 */